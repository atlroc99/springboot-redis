package com.example.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Student {
/*    public enum Gender {
        MALE("Male"), FEMALE("Female");
        private String gender;

        Gender(String gender) {
            this.gender = gender;
        }

        public String getGender() {
            return this.gender;
        }
    }*/

    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private int grade;
}
