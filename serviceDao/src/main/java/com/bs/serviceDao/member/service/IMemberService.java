package com.bs.serviceDao.member.service;

import com.bs.serviceDao.member.Member;

public interface IMemberService {
	void memberRegister(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3);
	Member memberSearch(String memId, String memPw);
	void memberModify();
	void memberRemove();
}
