package com.example.studentsapp.controller;

import com.example.studentsapp.model.Student;
import com.example.studentsapp.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    StudentsRepository studentsRepository;

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentsRepository.getAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> add(@RequestBody Student student) {
        studentsRepository.add(student);
        return new ResponseEntity<>("Данные добавлены", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        studentsRepository.delete(id);
        return new ResponseEntity<>("Данные студента удалены", HttpStatus.OK);
    }

}
