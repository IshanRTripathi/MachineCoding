package datingApplication.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import datingApplication.entities.Gender;
import datingApplication.entities.User;

public class UserRepository {
    Map<Integer, User> userMap = new HashMap<>();
//    {{
//        put(1,
//            User.builder()
//                .id(1)
//                .userName("ishanr")
//                .bio("My bio")
//                .firstName("Ishan R")
//                .currentLocation("GKP")
//                .gender(Gender.MALE)
//                .phoneNumber("+91 9348453705")
//                .email("ishaanr@gmail.com")
//                .swipeRightIds(Set.of(2))
//                .build());
//        put(2,
//            User.builder()
//                .id(2)
//                .userName("s")
//                .bio("My bio")
//                .firstName("S R")
//                .currentLocation("LKO")
//                .gender(Gender.FEMALE)
//                .phoneNumber("+91 923848347638643")
//                .email("s@gmail.com")
//                .swipeRightIds(Set.of(1))
//                .build());
//    }};

    public User getUserById(Integer id) {
        return userMap.get(id);
    }

    public void save(User user) {
//        userMap.put(user.getId(), user);
    }
}
