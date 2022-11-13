package datingApplication.service;


import datingApplication.entities.User;
import datingApplication.repository.UserRepository;

public class MatchingService {
    UserRepository userRepository;

    void performMatchOperation(Integer userId1, Integer userId2){
        userRepository = new UserRepository();
        User firstUser = userRepository.getUserById(userId1);
        User secondUser = userRepository.getUserById(userId2);

        if(validateIfMatchPossible(firstUser, secondUser)){
            // move ahead with matching
            firstUser.getMatchedUsers().add(secondUser);
            secondUser.getMatchedUsers().add(firstUser);
            userRepository.save(firstUser);
            userRepository.save(secondUser);

            initiateChat(userId1, userId2);
        } else {
            System.out.println("Only 1 user swiped right so far");
        }
    }

    void performUnMatchOperation(Integer userId1, Integer userId2) {

    }

    private void initiateChat(Integer userId1, Integer userId2) {
        // call chat service to make these ids as eligible for chatting
    }

    private boolean validateIfMatchPossible(User firstUser, User secondUser) {
        return secondUser.getSwipeRightIds().contains(firstUser.getId());
    }
}
