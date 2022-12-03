package com.example.testrest2dbh2.controller;
import com.example.testrest2dbh2.entity.Student;
import com.example.testrest2dbh2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students_urfu")
    public List<Student> showAllStudents()
    {
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }
    @GetMapping("/students_urfu/{id}")
    public Student getStudent(@PathVariable("id") int id) { return studentService.getStudent(id); }

    @PostMapping("/students_urfu")
    public Student saveStudent(@RequestBody Student student) { return studentService.saveStudent(student); }

    @PutMapping("/students_urfu")
    public Student updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    return student;
    }
    @DeleteMapping ("/students_urfu/{id}")
    private void updateStudent(@PathVariable("id") int id) { studentService.deleteStudent(id); }
}
