package com.codegym.c0724m1.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SumController", urlPatterns = "/sum")
public class SumController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/sum.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Tính tổng 2 số
        Double num1 = Double.parseDouble(req.getParameter("num1"));
        Double num2 = Double.parseDouble(req.getParameter("num2"));
        Double sum = num1 + num2;
        req.setAttribute("sum", sum);
        req.getRequestDispatcher("/WEB-INF/view/sum.jsp").forward(req, resp);
    }
}
