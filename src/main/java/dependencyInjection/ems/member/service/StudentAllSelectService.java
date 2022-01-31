package dependencyInjection.ems.member.service;

import java.util.Map;

import dependencyInjection.ems.member.Student;
import dependencyInjection.ems.member.dao.StudentDao;

public class StudentAllSelectService {

	private StudentDao studentDao;
	
	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
	
}