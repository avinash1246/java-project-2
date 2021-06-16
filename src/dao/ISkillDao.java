package dao;

import java.util.*;

import model.Empskill;
import model.Skill;
public interface ISkillDao {
	List<Skill> getAllSkill();
	void addSkill(Skill k);
	Skill getSkillById(Skill k);
	void updateSkill(Skill skill);
	void activateSkill(Skill skill);
	void deactivateSkill(Skill skill);
	void deleteSkill(Skill k);

}
