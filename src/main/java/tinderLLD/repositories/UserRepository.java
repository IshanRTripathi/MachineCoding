package tinderLLD.repositories;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;

import datingApplication.entities.Gender;
import datingApplication.entities.InterestsEnum;
import tinderLLD.entities.UserEntity;
import tinderLLD.entities.request.CreateUserRequest;

public class UserRepository {
    public UserRepository getUserRepository(){
        if(this != null){
            return this;
        } else {
            return new UserRepository();
        }
    }
    public Map<String, UserEntity> userEntityMap = new HashMap<>(){{
        put("ishanr", new UserEntity()
            .setId(1)
            .setAge(26)
            .setUserName("ishanr")
            .setBio("My bio")
            .setFirstName("Ishan R")
            .setCurrentLocation("GKP")
            .setGender(Gender.MALE)
            .setPhoneNumber("+91 9348453705")
            .setEmail("ishaanr@gmail.com")
            .setMatchedUsers(Set.of("pingss"))
            .setRightSwipedUsers(Set.of("pingss")));

        put("pingss", new UserEntity()
            .setId(2)
            .setAge(24)
            .setUserName("pooks")
            .setBio("My bio")
            .setFirstName("Pooks R")
            .setCurrentLocation("GKP")
            .setGender(Gender.FEMALE)
            .setPhoneNumber("+91 67736329232")
            .setEmail("skfbskbfskdjbc@gmail.com")
            .setMatchedUsers(Set.of("ishanr"))
            .setRightSwipedUsers(Set.of("ishanr")));
    }};

    public Map<String, UserEntity> getAllUsers(){
        return userEntityMap;
    }

    public UserEntity getUserByUserName(String username){
        return userEntityMap.get(username);
    }

    public void save(CreateUserRequest createUserRequest) {
        userEntityMap.put(createUserRequest.getUserName(),
            new UserEntity().setId(userEntityMap.size() + 1).setAge(createUserRequest.getAge()).setUserName(createUserRequest.getUserName()).setGender(Gender.MALE).setInterests(Set.of(InterestsEnum.BADMINTON)).setPhoneNumber("+919348453700")
            .setEmail("null@gmail.com").setLikedUsers(new HashSet<>()).setBlockedUsers(new HashSet<>()).setMatchedUsers(new HashSet<>()).setRightSwipedUsers(new HashSet<>()));
    }

    public void delete(String userName) {
        userEntityMap.remove(userName);
    }
}
