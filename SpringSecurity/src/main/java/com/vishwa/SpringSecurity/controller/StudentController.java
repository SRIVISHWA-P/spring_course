package com.vishwa.SpringSecurity.controller;

import com.vishwa.SpringSecurity.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    public List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1,"Navin","java"),
                    new Student(2,"kiran","Python")

    ));

//    @GetMapping("csrf-token")
//    public CsrfToken getCsrfToken(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//    }

    @GetMapping("students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("student")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }
}
