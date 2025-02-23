package crm_project.service;

import java.util.List;

import crm_project.entity.TaskEntity;
import crm_project.repository.TaskRepository;

public class TaskService {

private TaskRepository taskRepo = new TaskRepository();
	
	public List<TaskEntity> findAll() {
		return taskRepo.findAll();
	}
	
	public boolean saveTask(String name, String start_date, String end_date, String user_id, String job_id) {
		int result = taskRepo.saveTask(name, start_date, end_date, user_id, job_id);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
}
