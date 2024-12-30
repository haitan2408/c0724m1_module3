package com.codegym.c0724m1.controller;

import com.codegym.c0724m1.dto.StudentDTO;
import com.codegym.c0724m1.entity.Student;
import com.codegym.c0724m1.service.IClassroomService;
import com.codegym.c0724m1.service.IStudentService;
import com.codegym.c0724m1.service.impl.ClassroomService;
import com.codegym.c0724m1.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentController", urlPatterns = "/student")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();
    private IClassroomService classroomService = new ClassroomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.setAttribute("classrooms", classroomService.getAll());
                req.getRequestDispatcher("/WEB-INF/view/student/create.jsp").forward(req, resp);
                break;
            case "update":

                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                studentService.remove(id);
                resp.sendRedirect("/student?message=deleted");
                break;
            default:
                String message = req.getParameter("message");
                if (message != null) {
                   if (message.equals("deleted")) {
                       req.setAttribute("message", "Xóa thành công");
                   } else if(message.equals("created")) {
                       req.setAttribute("message", "Thêm mới thành công");
                   }
                }
                List<StudentDTO> students = studentService.getAllDTO();
                req.setAttribute("students", students);
                req.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                double point = Double.parseDouble(req.getParameter("point"));
                Integer idClass = Integer.valueOf(req.getParameter("idClass"));
                Student student = new Student(name, address, point, idClass);
                studentService.save(student);
                resp.sendRedirect("/student?message=created");
        }
    }
}
