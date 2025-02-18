package crm_project.model;

import java.util.List;

import crm_project.entity.TaskEntity;

public class JobModel {

	private int idUser;
	private String userName;
	List<TaskEntity> taskEntities;

	public JobModel(int idUser, String userName, List<TaskEntity> taskEntities) {
		this.idUser = idUser;
		this.userName = userName;
		this.taskEntities = taskEntities;
	}

	public JobModel() {

	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<TaskEntity> getTaskEntities() {
		return taskEntities;
	}

	public void setTaskEntities(List<TaskEntity> taskEntities) {
		this.taskEntities = taskEntities;
	}
}
