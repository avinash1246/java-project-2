package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import dao.IJobDao;
import daoimpl.JobDao;
import model.Employee;
import model.Job;

public class JobController {
	
		JobDao jobDao=null;
		public JobController() throws ClassNotFoundException, SQLException {
			jobDao= new JobDao();
		}


	public void addJob(String j1, String j2, String j3, String j4, String j5, String j6) {
		Job j = new Job();
		j.setJobTitle(j1);
		j.setJobDescription(j2);
		j.setCompanyName(j3);
		j.setLocation(j4);
		j.setKeySkill(j5);
		j.setSalary(j6);
		jobDao.addJob(j);
		}
	
    public void getAllJob() {
		
		List<Job> allJList=jobDao.getAllJobs();
		for(Job j:allJList) {
			System.out.println(j);
		}
	}
    
    public  Job getJobById(int s) {
    	Job j = new Job();
 	   j.setJobId(s);
 	   jobDao.getJobById(j);
 	   return j;
    }
   public Job activateJob(int s) {
	   Job j = new Job();
	   j.setJobId(s);
	   jobDao.activateJob(j);
	   return j;
   }
   public Job deactivateJob(int s) {
	   Job j = new Job();
	   j.setJobId(s);
	   jobDao.deactivateJob(j);
	   return j;
  }
   
   public Job DeleteJob(int s) {
	   Job j= new Job();
	   j.setJobId(s);
	   jobDao.deleteJob(j);
	   return j;
   }
}



