package com.project.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login {
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	GET방식 생략 가능, 값이 하나일 때 value 생략 가능
	@RequestMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("loginKey", "loginValue");
		
		return "login"; // login.jsp 실행
	}

}
