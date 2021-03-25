package com.example.redis.service;

import com.example.redis.entity.Student;
import com.example.redis.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;

import java.util.Map;
import java.util.UUID;

@Profile("test, redis")
public class StudentServiceRedisImpl implements StudentService {

    @Autowired
    @Qualifier("studentDaoRedisImpl")
    private StudentDao studentDao;

    public Student addStudent(Student student) {
        if (isNullOrEmpty(student.getId())) {
            student.setId(UUID.randomUUID().toString());
        }
        return studentDao.save(student);
    }

    public Student getStudentById(String id) {
        return studentDao.getById(id);
    }

    public Map<String, Student> getStudents() {
        return studentDao.list();
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
        studentDao.save(existingStudent);
    }

    public void deleteStudent(String id) {
        studentDao.delete(id);
    }

    private boolean isNullOrEmpty(String val) {
        if (val == null || val.trim().length() == 0)
            return true;
        return false;
    }
}

