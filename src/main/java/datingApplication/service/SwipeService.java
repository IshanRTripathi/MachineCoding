package datingApplication.service;

import datingApplication.repository.UserRepository;

public class SwipeService {

    MatchingService matchingService;
    UserRepository userRepository;

    void performSwipeOperation(Integer userId1, Integer userId2, String operationType) {
        if(operationType.equals("RIGHT")) {
            matchingService.performMatchOperation(userId1, userId2);
            userRepository.getUserById(userId1).getSwipeRightIds().add(userId2);
        }
    }
}
