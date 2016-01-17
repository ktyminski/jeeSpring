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
import com.mieszkaniabaza.domain.Mieszkania;

import com.mieszkaniabaza.service.MieszkaniaManager;
import com.mieszkaniabaza.service.WynajmujacyManager;

@WebServlet(urlPatterns = "/UsunWynajmujacy/*")
public class deleteWynajmujacyServlet extends HttpServlet{
    @EJB
    private WynajmujacyManager wm;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String link = request.getPathInfo();
        wm.usun(wm.pobierzPoId(Long.parseLong(link.substring(link.lastIndexOf("/") + 1, link.length()))));
 	response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Wynajmujacy"));
    }
}
