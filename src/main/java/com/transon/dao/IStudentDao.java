package com.transon.dao;

import com.transon.entity.Student;

import java.util.List;

public interface IStudentDao extends IGenericDao<Student> {
    List<Student> searchByName(String q);
}
