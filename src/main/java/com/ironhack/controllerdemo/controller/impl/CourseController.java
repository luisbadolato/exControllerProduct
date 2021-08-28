package com.ironhack.controllerdemo.controller.impl;

import com.ironhack.controllerdemo.controller.interfaces.ICourseController;
import com.ironhack.controllerdemo.model.Course;
import com.ironhack.controllerdemo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController implements ICourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getAll() {
//        list<course> courses = list.of(new course("cs101", "intro to java"), new course("cs102", "databases"));
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{code}")
    @ResponseStatus(HttpStatus.OK)
    public Course getById(@PathVariable(name = "code") String code) {
        return courseRepository.findById(code).get();
    }
}
