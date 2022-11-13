package tinderLLD.entities;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import datingApplication.entities.Gender;
import datingApplication.entities.InterestsEnum;
import datingApplication.entities.User;

@Getter
@AllArgsConstructor
public class UserEntity {
    private Integer id;
    private Integer age;
    private String userName;
    private String firstName;
    private String lastname;
    private String phoneNumber;
    private Gender gender;
    private String bio;
    private Set<InterestsEnum> interests;
    private String email;
    private Set<String> blockedUsers;
    private String currentLocation;
    private Set<String> matchedUsers;
    private Set<String> rightSwipedUsers;
    private Set<String> likedUsers;

    public UserEntity() {

    }


    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public String getBio() {
        return bio;
    }

    public Set<InterestsEnum> getInterests() {
        return interests;
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getBlockedUsers() {
        return blockedUsers;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public Set<String> getMatchedUsers() {
        return matchedUsers;
    }

    public Set<String> getRightSwipedUsers() {
        return rightSwipedUsers;
    }

    public Set<String> getLikedUsers() {
        return likedUsers;
    }

    public UserEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public UserEntity setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEntity setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserEntity setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public UserEntity setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public UserEntity setInterests(Set<InterestsEnum> interests) {
        this.interests = interests;
        return this;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity setBlockedUsers(Set<String> blockedUsers) {
        this.blockedUsers = blockedUsers;
        return this;
    }

    public UserEntity setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
        return this;
    }

    public UserEntity setMatchedUsers(Set<String> matchedUsers) {
        this.matchedUsers = matchedUsers;
        return this;
    }

    public UserEntity setRightSwipedUsers(Set<String> rightSwipedUsers) {
        this.rightSwipedUsers = rightSwipedUsers;
        return this;
    }

    public UserEntity setLikedUsers(Set<String> likedUsers) {
        this.likedUsers = likedUsers;
        return this;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
            "id=" + id +
            ", age=" + age +
            ", userName='" + userName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastname='" + lastname + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", gender=" + gender +
            ", bio='" + bio + '\'' +
            ", interests=" + interests +
            ", email='" + email + '\'' +
            ", blockedUsers=" + blockedUsers +
            ", currentLocation='" + currentLocation + '\'' +
            ", matchedUsers=" + matchedUsers +
            ", rightSwipedUsers=" + rightSwipedUsers +
            ", likedUsers=" + likedUsers +
            '}';
    }
}
