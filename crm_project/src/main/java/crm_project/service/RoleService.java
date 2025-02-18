package crm_project.service;

import java.util.List;

import crm_project.model.RoleModel;
import crm_project.repository.RoleRepository;

public class RoleService {

	private RoleRepository rolesRepository = new RoleRepository();

	public List<RoleModel> getAllRoles() {
		return rolesRepository.getRoles();
	}

	public boolean deleteRoleById(int id) {
		int result = rolesRepository.deleteRoleById(id);
		return result > 0;
	}

	public boolean insertRole(String name, String description) {
		int result = rolesRepository.insertRole(name, description);
		return result > 0;
	}

	public boolean updateRole(RoleModel role) {
		int result = rolesRepository.updateRole(role);
		return result > 0;
	}

}
