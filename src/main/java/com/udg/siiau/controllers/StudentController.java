package com.udg.siiau.controllers;

import com.udg.siiau.models.StudentModel;
import com.udg.siiau.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return service.saveStudent(student);
    }

    @PutMapping()
    public StudentModel editStudent(@RequestBody StudentModel student){
        return service.editStudent(student);
    }

    @GetMapping()
    public ArrayList<StudentModel> getAllStudents(){
        return service.getAllStudents();
    }


    @GetMapping("/findStudentById/{id}")
    public Optional<StudentModel> findStudentById(@PathVariable Long id){
        return service.findStudentById(id);
    }

    @GetMapping("/findStudentByCode/{code}")
    public Optional<ArrayList<StudentModel>> finStudentByCode(@PathVariable String code){
        return service.findStudentByCode(code);
    }


    @GetMapping("/findStudentByName/{name}")
    public Optional<ArrayList<StudentModel>> finStudentByName(@PathVariable String name){
        return service.findStudentByName(name);
    }
    @DeleteMapping("/delete-student-by-id")
    public String deleteStudentById(@RequestParam("id") Long id){
        return service.deleteStudentById(id);
    }


}
