package com.orm.jpademo.dao;

import com.orm.jpademo.entities.Student;

import java.util.List;

public interface IStudentDAO {

    void saveStudent(Student student);
    Student findStudentById(int studentId);
    List<Student> findAllStudents();
    List<Student> findStudentsByLastName(String lastName);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
    int deleteAllStudents();
}
