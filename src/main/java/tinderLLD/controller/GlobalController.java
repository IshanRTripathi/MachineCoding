package tinderLLD.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import tinderLLD.entities.UserEntity;
import tinderLLD.entities.request.CreateUserRequest;
import tinderLLD.repositories.UserRepository;
import tinderLLD.service.MatchMakingService;
import tinderLLD.service.UserService;

public class GlobalController {
    UserService userService;
    MatchMakingService matchMakingService;

    void initialiseIfNull(){
        if(userService == null) {
            userService = new UserService();
        }
        if(matchMakingService == null) {
            matchMakingService = new MatchMakingService();
        }
    }

    public void createUser(CreateUserRequest createUserRequest){
        initialiseIfNull();
        userService.createUser(createUserRequest);
    }

    public void getPotentialUsers(String userName) {
        initialiseIfNull();
        List<UserEntity> potentialUsers = userService.getPotentialUsers(userName);
        System.out.println("Potential users" + potentialUsers);
    }

    public void performLikeOperation(String currentUser, String likedUser) {
        initialiseIfNull();
        userService.performLikeOperation(currentUser, likedUser);
    }

    public void showAllMatches() {
        initialiseIfNull();
        Map<String, Set<String>> userMatched = matchMakingService.findAllMatchesInTheSystem();
        System.out.println("User  ->  MatchedUsers");
        userMatched.forEach((k,v) -> {
            System.out.println(k+" -> "+v);
        });
    }

    public void ignoreUser(String currentUser, String ignoredUser) {
        initialiseIfNull();
        userService.ignoreUser(currentUser, ignoredUser);
    }

    public void deleteAccount(String userName) {
        initialiseIfNull();
        userService.deleteAccount(userName);
    }

    public void showAllMatchesByUser(String userName) {
        initialiseIfNull();
        System.out.println(userService.getAllMatches(userName));
    }
}
