package com.mieszkaniabaza.web;

import com.mieszkaniabaza.service.MieszkaniaManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Mieszkania")
public class giveMieszkaniayServlet extends HttpServlet{
    @EJB
    private MieszkaniaManager mm;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.getRequestDispatcher("dane/mieszkania.jsp").forward(request, response);
    }
}
