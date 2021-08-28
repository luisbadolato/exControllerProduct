package com.ironhack.controllerdemo.controller.interfaces;

import com.ironhack.controllerdemo.model.Course;

import java.util.List;

public interface ICourseController {
    List<Course> getAll();
    Course getById(String code);
}
