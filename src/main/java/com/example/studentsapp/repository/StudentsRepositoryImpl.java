package com.example.studentsapp.repository;

import com.example.studentsapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsRepositoryImpl implements StudentsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Student student) {
        jdbcTemplate.update("insert into students(first_name, last_name, patronymic, date_of_birth, student_group)" +
                        "values (?, ?, ?, ?, ?)", student.getFirstName(), student.getLastName(), student.getPatronymic(),
                student.getDateOfBirth(), student.getGroup());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("delete from students where id=?", id);
    }

    @Override
    public List<Student> getAll() {
        return jdbcTemplate.query("select * from students order by id",
                BeanPropertyRowMapper.newInstance(Student.class));
    }
}
