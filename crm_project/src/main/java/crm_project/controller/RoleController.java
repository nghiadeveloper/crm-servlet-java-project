package crm_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project.model.RoleModel;
import crm_project.service.RoleService;

@WebServlet(name = "rolePage", urlPatterns = { "/role", "/role-add", "/role-update" })
public class RoleController extends HttpServlet {

	private RoleService roleService = new RoleService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getServletPath();
		switch (action) {
			case "/role":
				req.setAttribute("roles", roleService.getAllRoles());
				req.getRequestDispatcher("/role-table.jsp").forward(req, resp);
				break;
			case "/role-add":
				req.getRequestDispatcher("/role-add.jsp").forward(req, resp);
				break;
			case "/role-update":
				req.getRequestDispatcher("/role-update.jsp").forward(req, resp);
				break;
			}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
			case "/role-update":
				int id = Integer.parseInt(req.getParameter("id"));
				String name = req.getParameter("name");
				String description = req.getParameter("description");
				RoleModel role = new RoleModel(id, name, description);
				req.getSession().setAttribute("role", role);
				req.getRequestDispatcher("/role-update.jsp").forward(req, resp);
				break;
			}
	}

}
