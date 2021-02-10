package com.example.redis.service;

import com.example.redis.entity.Student;
import com.example.redis.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        if (isNullOrEmpty(student.getId())) {
            student.setId(UUID.randomUUID().toString());
        }
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        Optional<Student> op = studentRepository.findById(id);
        return op.get();
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
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
        studentRepository.delete(getStudentById(id));
    }

    private boolean isNullOrEmpty(String val) {
        if (val == null || val.trim().length() == 0)
            return true;
        return false;
    }
}
