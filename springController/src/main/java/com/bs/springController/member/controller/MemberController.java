package com.bs.springController.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bs.springController.member.Member;
import com.bs.springController.member.service.MemberService;

// handler mapping 빈이 요청이 들어오면 컨트롤러를 찾음
@Controller
@RequestMapping("/member")
public class MemberController {

// 순수 자바를 이용해 프로젝트를 할 때 사용 하는 방법 => 스프링에서는 X
//	MemberService service = new MemberService();
//	@Autowired
	@Resource(name="memService")
	MemberService service;
	
	/* @RequestMapping(value="/memJoin", method=RequestMethod.POST)
	public String memJoin(Model model, HttpServletRequest request) {
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memMail = request.getParameter("memMail");
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memPhone3 = request.getParameter("memPhone3");
		
		service.memberRegister(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
		
		model.addAttribute("memId", memId);
		model.addAttribute("memPw", memPw);
		model.addAttribute("memMail", memMail);
		model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		return "memJoinOk";
	} */
	
	@RequestMapping(value="/memJoin", method=RequestMethod.POST)
	// member라는 커맨드 객체를 명시해 주는 걸 통해 장황한 코드 줄이기 => 자주 사용하는 방식
	public String memJoin(Member member) {
//		String memId = request.getParameter("memId");
//		String memPw = request.getParameter("memPw");
//		String memMail = request.getParameter("memMail");
//		String memPhone1 = request.getParameter("memPhone1");
//		String memPhone2 = request.getParameter("memPhone2");
//		String memPhone3 = request.getParameter("memPhone3");
		
		service.memberRegister(member.getMemId(), member.getMemPw(), member.getMemMail(), 
				member.getMemPhone1(), member.getMemPhone2(), member.getMemPhone3());
		
//		model.addAttribute("memId", memId);
//		model.addAttribute("memPw", memPw);
//		model.addAttribute("memMail", memMail);
//		model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		return "memJoinOk";
	}
	
	
	/* @RequestMapping(value="/memLogin", method=RequestMethod.POST)
	public String memLogin(Model model, HttpServletRequest request) {
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		
		Member member = service.memberSearch(memId, memPw);
		
		try {
			model.addAttribute("memId", member.getMemId());
			model.addAttribute("memPw", member.getMemPw());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "memLoginOk";
	} */
	
	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
	public String memLogin(Model model, @RequestParam("memId") String memId, 
			// required 속성은 클라이언트 단에서 체크를 하고 서버에 유효성 체크같은 업무를 보통 시키진 않음
			@RequestParam(value="memPw", required=true, defaultValue="1234") String memPw) {
		
//		String memId = request.getParameter("memId");
//		String memPw = request.getParameter("memPw");
		
		Member member = service.memberSearch(memId, memPw);
		
		try {
			model.addAttribute("memId", member.getMemId());
			model.addAttribute("memPw", member.getMemPw());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "memLoginOk";
	}
	
}