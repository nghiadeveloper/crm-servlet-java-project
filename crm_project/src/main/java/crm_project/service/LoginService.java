package crm_project.service;

import java.util.List;

import crm_project.model.UserModel;
import crm_project.repository.UserRepository;

public class LoginService {

	UserRepository usersRepository = new UserRepository();

	public boolean checkLogin(String email, String password) {
		List<UserModel> list = usersRepository.getUsersByEmailAndPassword(email, password);
		return list.size() > 0;
	}

}
