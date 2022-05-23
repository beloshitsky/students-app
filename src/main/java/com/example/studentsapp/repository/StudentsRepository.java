package com.example.studentsapp.repository;

import com.example.studentsapp.model.Student;

import java.util.List;

public interface StudentsRepository{
    void add(Student student);
    void delete(Long id);
    List<Student> getAll();
}
