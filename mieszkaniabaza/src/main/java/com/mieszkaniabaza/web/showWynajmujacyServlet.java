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

@WebServlet(urlPatterns = "/PokazWynajmujacy/*")
public class showWynajmujacyServlet extends HttpServlet{
    @EJB
    private WynajmujacyManager wm = new WynajmujacyManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String link = request.getPathInfo();
	request.setAttribute("WynajmujacyId", link.substring(link.lastIndexOf("/") + 1, link.length()));
        request.getRequestDispatcher("/wynajmujacy/show.jsp").forward(request, response);
    }
}
