package com.spring.crudedemo.dao;

import com.spring.crudedemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findBylastName(String lastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();


}
