package tinderLLD.service;

import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import tinderLLD.entities.UserEntity;
import tinderLLD.entities.request.CreateUserRequest;
import tinderLLD.repositories.UserRepository;

public class UserService {
    static UserRepository userRepository;
    static MatchMakingService matchMakingService;

    private void initialiseIfNull() {
        if(userRepository == null) {
            System.out.println("Initialising");
            userRepository = new UserRepository();
        }
        if(matchMakingService == null){
            System.out.println("Initialising");
            matchMakingService = new MatchMakingService();
        }
    }

    public void createUser(CreateUserRequest createUserRequest) {
        initialiseIfNull();
        if(!validateCreateUserRequest(createUserRequest)) {
            userRepository.save(createUserRequest);
            System.out.println("New user created success with userName: " + createUserRequest.getUserName());
        }
    }

    private boolean validateCreateUserRequest(CreateUserRequest createUserRequest) {
        AtomicBoolean response = new AtomicBoolean(Boolean.TRUE);
        Optional.ofNullable(userRepository.getUserByUserName(createUserRequest.getUserName())).ifPresentOrElse(userEntity -> {
            System.out.println("User already present in database, please request using a unique userName");
            response.set(Boolean.FALSE);
        }, () -> {
            System.out.println("Validated create user request");
        });
        return response.get();
    }

    public List<UserEntity> getPotentialUsers(String userName) {
//        PriorityQueue<UserEntity> potentialUsers = new PriorityQueue<>((u1, u2) -> {
//            // lesser the weightage, better the matching
//            int weightage = 0;
//            if (u1.getGender() != u2.getGender()) {
//                weightage--;
//            } else {
//                weightage++;
//            }
//            weightage += Math.abs(u1.getCurrentLocation().compareTo(u2.getCurrentLocation()));
//            weightage += Math.abs(u1.getAge() - u2.getAge());
//            return weightage;
//        });

        initialiseIfNull();
        UserEntity currentUser = userRepository.getUserByUserName(userName);
        return userRepository.getAllUsers().values().stream().filter(user -> {
            int res = calculateWeightage(user, currentUser);
            if(res > 0) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
    }

    private int calculateWeightage(UserEntity user, UserEntity currentUser) {
        int weightage = 0;
        if (user.getGender() != currentUser.getGender()) {
            weightage--;
        } else {
            weightage++;
        }
        weightage += Math.abs(user.getCurrentLocation().compareTo(currentUser.getCurrentLocation()));
        weightage += Math.abs(user.getAge() - currentUser.getAge());
        return weightage;
    }

    public void performLikeOperation(String currentUser, String likedUser) {
        initialiseIfNull();
        userRepository.getUserByUserName(currentUser).getLikedUsers().add(likedUser);
        boolean matchStatus = validateIfUsersMatched(currentUser, likedUser);

        if(matchStatus) {
            matchMakingService.initiateMatchedOperation(currentUser, likedUser);

        } else {
            System.out.println("Not initiating match because user: " + likedUser + " has not yet liked user: " + currentUser);
        }
    }

    private boolean validateIfUsersMatched(String currentUser, String likedUser) {
        return userRepository.getUserByUserName(likedUser).getLikedUsers()
            .contains(userRepository.getUserByUserName(currentUser).getUserName());
    }

    public void ignoreUser(String currentUser, String ignoredUser) {
        initialiseIfNull();
        userRepository.getUserByUserName(currentUser).getBlockedUsers().add(ignoredUser);
    }

    public void deleteAccount(String userName) {
        initialiseIfNull();
        // remove userName from UserRepository
        userRepository.delete(userName);
        // traverse all users which the current user interacted to
        userRepository.getAllUsers().values().forEach(userEntity -> {
            // remove from blocked users
            // remove from liked users
            // remove from matched users
            userEntity.getMatchedUsers().remove(userName);
            userEntity.getLikedUsers().remove(userName);
            userEntity.getBlockedUsers().remove(userName);
            userEntity.getRightSwipedUsers().remove(userName);
        });

    }

    public Set<String> getAllMatches(String userName) {
        return userRepository.getUserByUserName(userName).getMatchedUsers();
    }
}
