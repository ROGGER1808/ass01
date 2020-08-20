package com.transon.controller.Student;

import com.transon.entity.Student;
import com.transon.entity.common.Gender;
import com.transon.service.IStudentService;
import com.transon.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IStudentService studentService;

    public UpdateStudent() {
        super();
       	studentService = new StudentServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		Student student = studentService.findOne(studentId);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/views/student/updateStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = studentService.findOne(request.getParameter("studentID"));
		student.setID(request.getParameter("studentID"));
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
		student.setPhoneNumber(request.getParameter("phoneNumber"));
		studentService.update(student);
		response.sendRedirect(request.getContextPath());
	}

}
