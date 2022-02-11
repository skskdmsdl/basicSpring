package annotation.ems.member.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import annotation.ems.member.dao.StudentDao;
import annotation.ems.member.service.StudentAllSelectService;
import annotation.ems.member.service.StudentDeleteService;
import annotation.ems.member.service.StudentModifyService;
import annotation.ems.member.service.StudentRegisterService;
import annotation.ems.member.service.StudentSelectService;

@Configuration
public class MemberConfig1 {

	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
	
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}
	
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDao());
	}
	
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}
	
	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	
}