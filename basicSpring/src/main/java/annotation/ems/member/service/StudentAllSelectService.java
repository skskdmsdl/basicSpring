package annotation.ems.member.service;

import java.util.Map;

import annotation.ems.member.Student;
import annotation.ems.member.dao.StudentDao;

public class StudentAllSelectService {

	private StudentDao studentDao;
	
	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Map<String, Student> allSelect() {
		return studentDao.getStudentDB();
	}
	
}