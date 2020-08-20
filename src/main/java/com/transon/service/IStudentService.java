package com.transon.service;

import com.transon.entity.Student;

import java.util.List;

public interface IStudentService extends IGenericService<Student> {
    List<Student> searchByName(String q);
}
