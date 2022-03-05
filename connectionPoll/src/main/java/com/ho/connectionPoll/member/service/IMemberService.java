package com.ho.connectionPoll.member.service;

import com.ho.connectionPoll.member.Member;

public interface IMemberService {
	void memberRegister(Member member);
	Member memberSearch(Member member);
	Member memberModify(Member member);
	int memberRemove(Member member);
}