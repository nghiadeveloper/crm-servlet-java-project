package crm_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "homeController",urlPatterns = {"/home", "/blank", "/error"})
public class HomeController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
        switch (action) {
            case "/home":
                req.getRequestDispatcher("/index.html").forward(req,resp);
                break;
            case "/blank":
                req.getRequestDispatcher("/blank.html").forward(req,resp);
                break;
            case "/error":
                req.getRequestDispatcher("/404.html").forward(req,resp);
                break;
        }
	}
	
}
