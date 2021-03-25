package com.example.redis.repository;

import com.example.redis.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface StudentDao {
    Student save(Student student);
    Student update(Student student);
    Map<String, Student> list();
    void delete(String id);
    Student getById(String id);
}
