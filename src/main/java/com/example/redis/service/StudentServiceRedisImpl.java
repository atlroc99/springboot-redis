package com.example.redis.service;

import com.example.redis.entity.Student;
import com.example.redis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;


import com.example.redis.entity.Student;
import com.example.redis.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Profile("test")
@Service
@Qualifier("StudentServiceRedisImpl")
public class StudentServiceRedisImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceRedisImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        if (isNullOrEmpty(student.getId())) {
            student.setId(UUID.randomUUID().toString());
        }
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.getById(id);
    }

    public Map<String, Student> getStudents() {
        return studentRepository.list();
    }

    public void updateStudent(Student student) throws Exception {
        if (isNullOrEmpty(student.getId())) {
            throw new Exception("*** NOT ABLE TO UPDATE STUDENT. STUDENT ID IS NULL OR EMPTY*** ");
        }
        Student existingStudent = getStudentById(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setGender(student.getGender());
        existingStudent.setGrade(student.getGrade());
        studentRepository.save(existingStudent);
    }

    public void deleteStudent(String id) {
        studentRepository.delete(id);
    }

    private boolean isNullOrEmpty(String val) {
        if (val == null || val.trim().length() == 0)
            return true;
        return false;
    }
}

