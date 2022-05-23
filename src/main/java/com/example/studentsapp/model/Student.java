package com.example.studentsapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    Long id;
    String firstName;
    String lastName;
    String patronymic;
    LocalDate dateOfBirth;
    String group;
}
