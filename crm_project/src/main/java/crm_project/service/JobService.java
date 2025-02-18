package crm_project.service;

import java.util.ArrayList;
import java.util.List;

import crm_project.entity.JobEntity;
import crm_project.entity.TaskEntity;
import crm_project.entity.UserEntity;
import crm_project.model.JobModel;
import crm_project.repository.JobRepository;
import crm_project.utils.DateFormat;

public class JobService {

	private JobRepository jobRepository = new JobRepository();
	private DateFormat dateFormat = new DateFormat();

	public List<JobEntity> getAllJobs() {
		List<JobEntity> jobs = jobRepository.getJobs();
		for (JobEntity job : jobs) {
			job.setStartDate(dateFormat.changeFormatDate(job.getStartDate(), "/"));
			job.setEndDate(dateFormat.changeFormatDate(job.getEndDate(), "/"));
		}
		return jobs;
	}

	public boolean deleteJobById(int id) {
		int result = jobRepository.deleteJobById(id);
		return result > 0;
	}

	public boolean insertJob(JobEntity job) {
		try {
			job.setStartDate(dateFormat.changeFormatDate(job.getStartDate(), "-"));
			job.setEndDate(dateFormat.changeFormatDate(job.getEndDate(), "-"));
			int result = jobRepository.insertJob(job);
			return result > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public JobEntity findJobById(int id) {
		JobEntity job = jobRepository.findJobById(id);
		job.setStartDate(dateFormat.changeFormatDate(job.getStartDate(), "/"));
		job.setEndDate(dateFormat.changeFormatDate(job.getEndDate(), "/"));
		return job;
	}

	public boolean updateJob(JobEntity job) {
		try {
			job.setStartDate(dateFormat.changeFormatDate(job.getStartDate(), "-"));
			job.setEndDate(dateFormat.changeFormatDate(job.getEndDate(), "-"));
			int result = jobRepository.updateJob(job);
			return result > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public List<JobModel> getDetailsByJobId(int jobId) {
		List<JobModel> jobDetails = new ArrayList<>();

		List<UserEntity> users = jobRepository.getUserByJobId(jobId);
		for (UserEntity user : users) {
			JobModel jobDetail = new JobModel();
			jobDetail.setIdUser(user.getId());
			jobDetail.setUserName(user.getFirstName() + " " + user.getLastName());
			List<TaskEntity> tasks = jobRepository.getTaskByJobIdAndUserId(jobId, user.getId());
			jobDetail.setTaskEntities(tasks);
			jobDetails.add(jobDetail);
		}
		return jobDetails;
	}

}
