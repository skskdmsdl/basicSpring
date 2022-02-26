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

// handler mapping ���� ��û�� ������ ��Ʈ�ѷ��� ã��
@Controller
@RequestMapping("/member")
public class MemberController {

// ���� �ڹٸ� �̿��� ������Ʈ�� �� �� ��� �ϴ� ��� => ������������ X
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
	// member��� Ŀ�ǵ� ��ü�� ����� �ִ� �� ���� ��Ȳ�� �ڵ� ���̱� => ���� ����ϴ� ���
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
			// required �Ӽ��� Ŭ���̾�Ʈ �ܿ��� üũ�� �ϰ� ������ ��ȿ�� üũ���� ������ ���� ��Ű�� ����
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