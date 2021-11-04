package com.gabrielgoodman.controller;

import com.gabrielgoodman.entity.Student;
import com.gabrielgoodman.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public Collection<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudentById(@PathVariable("id") int id){
         studentService.removeStudentById(id);
    }

    @PutMapping()
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @PostMapping()
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }
}
