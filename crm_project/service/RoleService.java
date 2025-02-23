package crm_project.service;

import java.util.List;

import crm_project.repository.RoleRepository;

public class RoleService {

	private RoleRepository roleRepository = new RoleRepository();

	public boolean saveRole(String name, String description) {
		if (roleRepository.saveRole(name, description) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
