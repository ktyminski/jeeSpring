package   com.mieszkaniabaza.web;

import com.mieszkaniabaza.service.WynajmujacyManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Wynajmujacy")
public class giveWynajmujacyServlet extends HttpServlet{
    @EJB
    private WynajmujacyManager wm;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        request.getRequestDispatcher("dane/wynajmujacy.jsp").forward(request, response);
    }
}
