package crm_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crm_project.service.LoginService;

@WebServlet(name = "loginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		boolean isLogin = loginService.checkLogin(email, password);
		System.out.println("Kiem tra " + isLogin);

		if (isLogin) {
			HttpSession session = req.getSession();
			session.setAttribute("isLogin", true);
			session.setMaxInactiveInterval(5 * 60);
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

}
