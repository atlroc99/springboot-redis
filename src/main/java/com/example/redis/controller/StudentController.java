package com.example.redis.controller;

import com.example.redis.entity.Student;
import com.example.redis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/test")
    public String home() {
        return "<h1>Success</h1>";
    }

    @GetMapping("/all")
    public Map<String, Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("")
    public Student getStudentById(@RequestParam("id") String id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student s = studentService.addStudent(student);
        return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateStudent(@RequestBody Student student) throws Exception {
        studentService.updateStudent(student);
        return new ResponseEntity<>(HttpStatus.ACCEPTED, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteStudent(@RequestParam(name = "id") String id) throws Exception {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED, HttpStatus.NO_CONTENT);
    }
}
