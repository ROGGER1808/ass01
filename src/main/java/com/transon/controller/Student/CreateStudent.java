package com.transon.controller.Student;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.transon.entity.Student;
import com.transon.entity.common.Gender;
import com.transon.service.IStudentService;
import com.transon.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class CreateStudent
 */
@WebServlet("/CreateStudent")
public class CreateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IStudentService studentService;
	
    public CreateStudent() {
        super();
        studentService = new StudentServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/student/createStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setFullName(request.getParameter("fullName"));
		student.setAddress(request.getParameter("address"));
		student.setEmail(request.getParameter("email"));
		String gender = request.getParameter("gender");
		switch (gender){
			case "1": student.setGender(Gender.Male);
				break;
			case "2": student.setGender(Gender.Female);
				break;
			default: student.setGender(Gender.Other);
				break;
		}
		String dateInString = request.getParameter("birthday");

		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateInString);
			student.setBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		student.setPhoneNumber(request.getParameter("phoneNumber"));
		studentService.create(student);
		response.sendRedirect(request.getContextPath());
	}

}
