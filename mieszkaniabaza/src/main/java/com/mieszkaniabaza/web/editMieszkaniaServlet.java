package com.mieszkaniabaza.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mieszkaniabaza.domain.Mieszkania;
import com.mieszkaniabaza.domain.Wynajmujacy;

import com.mieszkaniabaza.service.WynajmujacyManager;
import com.mieszkaniabaza.service.MieszkaniaManager;
@WebServlet(urlPatterns = "/EdytujMieszkania/*")
public class editMieszkaniaServlet extends HttpServlet{
    @EJB
    private WynajmujacyManager wm;
    @EJB
    private MieszkaniaManager mm;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String link = request.getPathInfo();
        request.setAttribute("mieszkanieEdit", wm.pobierzPoId(Long.parseLong(link.substring(link.lastIndexOf("/") + 1, link.length()))));
        request.getRequestDispatcher("/mieszkania/edit.jsp").forward(request, response);
    }
}
