package com.example.redis.service;

import com.example.redis.entity.Student;

import java.util.Map;
import java.util.UUID;

public interface StudentService {

    public Student addStudent(Student student);
    public Student getStudentById(String id);
    public Map<String, Student> getStudents();
    public void updateStudent(Student student) throws Exception ;
    public void deleteStudent(String id);
//    private boolean isNullOrEmpty(String val);
}