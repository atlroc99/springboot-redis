package com.example.redis.repository;

import com.example.redis.entity.Student;
import org.springframework.context.annotation.Profile;

import java.util.Map;

@Profile("default")
public class StudentDaoH2Impl implements StudentDao{
    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public Map<String, Student> list() {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Student getById(String id) {
        return null;
    }
}
