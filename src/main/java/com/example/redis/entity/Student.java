package com.example.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Student implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private int grade;
}
