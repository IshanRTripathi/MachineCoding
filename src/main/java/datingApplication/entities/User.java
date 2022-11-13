package datingApplication.entities;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

//@Builder
@Data
public class User {
    Integer id;
    String userName;
    String firstName;
    String lastname;
    String phoneNumber;
    Gender gender;
    String bio;
    Set<InterestsEnum> interests;
    String email;
    Set<String> blockedUsers;
    String currentLocation;
    Set<User> matchedUsers;
    Set<Integer> swipeRightIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<InterestsEnum> getInterests() {
        return interests;
    }

    public void setInterests(Set<InterestsEnum> interests) {
        this.interests = interests;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(Set<String> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Set<User> getMatchedUsers() {
        return matchedUsers;
    }

    public void setMatchedUsers(Set<User> matchedUsers) {
        this.matchedUsers = matchedUsers;
    }

    public Set<Integer> getSwipeRightIds() {
        return swipeRightIds;
    }

    public void setSwipeRightIds(Set<Integer> swipeRightIds) {
        this.swipeRightIds = swipeRightIds;
    }
}
