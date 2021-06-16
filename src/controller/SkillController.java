package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;


import daoimpl.SkillDao;
import model.Employee;
import model.Skill;

public class SkillController {
	
		SkillDao skillDao=null;
		public SkillController() throws ClassNotFoundException, SQLException {
			skillDao= new SkillDao();
		}


	public void addSkill(String j1, String j2) {
		Skill j = new Skill();
		j.setSkillName(j1);
		j.setSkillDescription(j2);
		
		skillDao.addSkill(j);
		}
	
    public void getAllSkill() {
		
		List<Skill> allkList=skillDao.getAllSkill();
		for(Skill k:allkList) {
			System.out.println(k);
		}
	}
    
    public  Skill getSkillById(int s) {
    	Skill k = new Skill();
 	   k.setSkillId(s);
 	   skillDao.getSkillById(k);
 	   return k;
    }
   public Skill activateSkill(int s) {
	   Skill k = new Skill();
	   k.setSkillId(s);
	   skillDao.activateSkill(k);
	   return k;
   }
   public Skill deactivateSkill(int s) {
	   Skill k = new Skill();
	   k.setSkillId(s);
	   skillDao.deactivateSkill(k);
	   return k;
  }
   
   public Skill DeleteSkill(int s) {
	   Skill k= new Skill();
	   k.setSkillId(s);
	   skillDao.deleteSkill(k);
	   return k;
   }
}



