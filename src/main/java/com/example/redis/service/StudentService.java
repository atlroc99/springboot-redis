package com.example.redis.service;

import com.example.redis.entity.Student;

import java.util.Map;

public interface StudentService {

    Student addStudent(Student student);

    Student getStudentById(String id);

    Map<String, Student> getStudents();

    void updateStudent(Student student) throws Exception;

    void deleteStudent(String id);
//    private boolean isNullOrEmpty(String val);
}