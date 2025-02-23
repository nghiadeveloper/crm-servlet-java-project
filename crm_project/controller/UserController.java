package crm_project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project.entity.RoleEntity;
import crm_project.entity.UserEntity;
import crm_project.service.RoleService;
import crm_project.service.TaskService;
import crm_project.service.UserService;

@WebServlet(name = "userController", urlPatterns = { "/user", "/user-add", "/user-details" })
public class UserController extends HttpServlet {

	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();

		switch (servletPath) {
		case "/user": {
			getUser(req, resp);
			break;
		}
		case "/user-add": {
			addUser(req, resp);
			break;
		}
		case "/user-table": {
			req.getRequestDispatcher("user-table.jsp").forward(req, resp);
			break;
		}
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		if (servletPath.equals("/user-add")) {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String fullname = req.getParameter("fullname");
			String avatar = req.getParameter("avatar");
			String role_id = req.getParameter("role_id");
			if (userService.saveUser(email, password, fullname, avatar, role_id)) {
				req.getRequestDispatcher("user.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("user-add.jsp").forward(req, resp);
			}
		} else {
			req.getRequestDispatcher("user-add.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		if (servletPath.equals("/user")) {
			int id = Integer.parseInt(req.getParameter("id"));
			userService.deleteUser(id);
		}
		req.getRequestDispatcher("user-table.jsp").forward(req, resp);
	}

	private void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserEntity> userList = userService.getAllUsers();
		req.setAttribute("users", userList);
		System.out.println(userList.size());
		req.getRequestDispatcher("user-table.jsp").forward(req, resp);
	}

	private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<RoleEntity> roleList = new ArrayList<RoleEntity>();
		roleList = userService.getRoles();
		System.out.println(roleList.get(0).getName());
		req.setAttribute("roles", roleList);
		req.getRequestDispatcher("user-add.jsp").forward(req, resp);
	}

}
