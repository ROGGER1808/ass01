package com.transon.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.transon.dao.IStudentDao;
import com.transon.dao.impl.StudentDaoImpl;
import com.transon.entity.Student;
import com.transon.service.IStudentService;

public class StudentServiceImpl extends GenericServiceImpl<Student> implements IStudentService{
	private IStudentDao studentDao;
	public StudentServiceImpl() {
		studentDao = new StudentDaoImpl();
		this.setGenericDao(studentDao);
	}
	
	@Override
	public void create(Student entity) {
		StringBuilder builder = new StringBuilder();
		Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = formatter.format(date);
       	String[] arrString = entity.getFullName().split(" ");
       	for (String a : arrString){
       		builder.append(a.toUpperCase());
		}
       	builder.append(strDate);
       	entity.setID(builder.toString());
 		super.create(entity);
	}


	@Override
	public List<Student> searchByName(String q) {
		return studentDao.searchByName(q);
	}
}
