package crm_project.service;

import java.util.List;

import crm_project.entity.StatusEntity;
import crm_project.repository.StatusRepository;

public class StatusService {

	private StatusRepository statusRepository = new StatusRepository();

	public List<StatusEntity> getAllStatuses() {
		return statusRepository.getStatuses();
	}

}
