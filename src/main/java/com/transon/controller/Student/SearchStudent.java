package com.transon.controller.Student;

import com.transon.entity.Student;
import com.transon.service.IStudentService;
import com.transon.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private IStudentService studentService;
    public SearchStudent() {
        super();
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> result = studentService.searchByName(request.getParameter("q"));
        request.setAttribute("students",result);
        request.getRequestDispatcher("/views/student/listStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
