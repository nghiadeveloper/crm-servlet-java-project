package crm_project.service;

import java.util.List;

import crm_project.entity.JobEntity;
import crm_project.repository.GroupworkRepository;

public class GroupworkService {

	private GroupworkRepository groupworkRepository = new GroupworkRepository();

	public List<JobEntity> findAll() {
		return groupworkRepository.findAll();
	}

	public boolean saveRole(String name, String startDate, String endDate) {
		if (groupworkRepository.saveGroupwork(name, startDate, endDate) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
