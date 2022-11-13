package tinderLLD.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import tinderLLD.repositories.UserRepository;

public class MatchMakingService {

    UserRepository userRepository;

    public Map<String, Set<String>> findAllMatchesInTheSystem() {
        if(userRepository == null) {
            System.out.println("Initialising");
            userRepository = new UserRepository();
        }
        Map<String, Set<String>> userMatchedTo = new HashMap<>();
        userRepository.getAllUsers().values().forEach(userEntity -> {
            if(!userMatchedTo.containsKey(userEntity.getUserName())){
                userMatchedTo.put(userEntity.getUserName(), new HashSet<>());
            }
            userMatchedTo.get(userEntity.getUserName()).addAll(userEntity.getMatchedUsers());
        });
        return userMatchedTo;
    }

    public void initiateMatchedOperation(String currentUser, String likedUser) {
        if(userRepository == null) {
            System.out.println("Initialising");
            userRepository = new UserRepository();
        }
        userRepository.getUserByUserName(currentUser).getMatchedUsers().add(likedUser);
        userRepository.getUserByUserName(likedUser).getMatchedUsers().add(currentUser);
    }
}
