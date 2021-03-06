package com.example.redis.repository;

import com.example.redis.entity.Student;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    RedisTemplate<String, Object> redisTemplate;
    //    public interface HashOperations<H, HK, HV> {
    HashOperations<String, String, Student> hashOperations;

    public StudentRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Student save(Student student) {
        hashOperations.put("STUDENT", student.getId(), student);
        return hashOperations.get("STUDENT", student.getId());
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Override
    public Map<String, Student> list() {
        return hashOperations.entries("STUDENT");
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("STUDENT", id);
    }

    @Override
    public Student getById(String id) {
        return hashOperations.get("STUDENT", id);
    }
}
