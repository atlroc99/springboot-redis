package com.example.redis.service;

import com.example.redis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Map;
@Profile("default, h2")
public class StudentServiceH2Impl implements StudentService {

    @Override
    public Student addStudent(Student student) {
        return null;
    }

    @Override
    public Student getStudentById(String id) {
        return null;
    }

    @Override
    public Map<String, Student> getStudents() {
        return null;
    }

    @Override
    public void updateStudent(Student student) throws Exception {

    }

    @Override
    public void deleteStudent(String id) {

    }
}
