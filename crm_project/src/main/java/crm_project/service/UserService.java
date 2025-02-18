package crm_project.service;

import java.text.DateFormat;
import java.util.List;

import crm_project.entity.UserEntity;
import crm_project.model.UserModel;
import crm_project.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository = new UserRepository();

    public List<UserModel> getAllUsers() {
        return userRepository.getUsers();
    }

    public boolean deleteUserById(int id) {
        int result = userRepository.deleteUserById(id);
        return result > 0;
    }

    public boolean insertUser(UserEntity user) {
        int result = userRepository.insertUser(user);
        return result > 0;
    }

    public boolean updateUser(UserEntity user) {
        int result = userRepository.updateUser(user);
        return result > 0;
    }

    public UserEntity findUserById(int id) {
        return userRepository.findUserById(id);
    }

}
