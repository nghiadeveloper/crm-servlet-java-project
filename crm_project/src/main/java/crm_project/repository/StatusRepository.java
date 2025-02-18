package crm_project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project.config.MysqlConfig;
import crm_project.entity.StatusEntity;

public class StatusRepository {
	
	public List<StatusEntity> getStatuses() {
        List<StatusEntity> statuses = new ArrayList<>();
        try {
            Connection connection = MysqlConfig.getConnection();
            String query = "select * from status";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                StatusEntity status = new StatusEntity();
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("name"));
                statuses.add(status);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error get statuses " + e.getMessage());
        }
        return statuses;
    }

}
