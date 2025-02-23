package crm_project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project.config.MysqlConfig;
import crm_project.entity.RoleEntity;

public class RoleRepository {

	public List<RoleEntity> findAll() {

		String query = "SELECT * FROM roles";
		List<RoleEntity> roleList = new ArrayList<RoleEntity>();

		try {
			Connection connection = MysqlConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				RoleEntity role = new RoleEntity();
				role.setId(result.getInt("id"));
				role.setName(result.getString("name"));
				role.setDescription(result.getString("description"));
				roleList.add(role);
			}

		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}

		return roleList;

	}

	public int saveRole(String name, String description) {
		String query = "INSERT INTO roles" + "(name, description)" + "VALUES" + "(?, ?)";
		int result = 0;

		try {
			Connection connection = MysqlConfig.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, name);
			statement.setString(2, description);

			result = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}

		return result;
	}

}
