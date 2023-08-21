package com.spring6.restful.controller;

import com.spring6.restful.entity.Student;
import com.spring6.restful.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    private void loadData(){

        students = new ArrayList<>();

        students.add(new Student("Jack","Ma"));
        students.add(new Student("Jeff","Bezos"));
        students.add(new Student("Elon","Musk"));
        students.add(new Student("Travis","Kalanick"));
        students.add(new Student("Steve","Jobs"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        if(studentId>=students.size() || studentId<0){
            throw new StudentNotFoundException("Student ID: " + studentId + " - Not Found");
        }
        return students.get(studentId);
    }

}
