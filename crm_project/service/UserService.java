package crm_project.service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import crm_project.entity.RoleEntity;
import crm_project.entity.UserEntity;
import crm_project.repository.RoleRepository;
import crm_project.repository.UserRepository;

public class UserService {

	private RoleRepository roleRepository = new RoleRepository();
	private UserRepository userRepository = new UserRepository();

	public List<RoleEntity> getRoles() {
		return roleRepository.findAll();
	}

	public List<UserEntity> authenticateUser(String email, String password) {
		List<UserEntity> userList = userRepository.findUserByEmailAndPassword(email, password);
		if (userList.size() > 0) {
			return userList;
		} else {
			return new ArrayList<UserEntity>();
		}
	}

	public List<UserEntity> getAllUsers() {
		List<UserEntity> userList = userRepository.findAll();
		if (userList.size() > 0) {
			return userList;
		} else {
			return new ArrayList<UserEntity>();
		}
	}

	public boolean saveUser(String email, String password, String fullname, String avatar, String role_id) {
		if (userRepository.saveUser(email, password, fullname, avatar, role_id) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteUser(int id) {
		if (userRepository.deleteUser(id) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
