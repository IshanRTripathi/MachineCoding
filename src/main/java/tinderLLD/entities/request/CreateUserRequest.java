package tinderLLD.entities.request;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;

import datingApplication.entities.Gender;
import datingApplication.entities.InterestsEnum;
import datingApplication.entities.User;

public class CreateUserRequest {
    Integer id;
    String userName;
    Gender gender;
    String location;
    Integer age;

    public Integer getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Gender getGender() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

    public CreateUserRequest(String userName, int lat, int lon, int age, String gender) {
        this.userName = userName;
        this.location = lat+":"+lon;
        this.gender = Gender.valueOf(gender);
        this.age = age;
    }
}
