package com.bs.redirect.member.service;

import com.bs.redirect.member.Member;

public interface IMemberService {
	void memberRegister(Member member);
	Member memberSearch(Member member);
	Member memberModify(Member member);
	void memberRemove(Member member);
}
