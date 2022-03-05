package com.ho.connectionPoll.member.dao;

import com.ho.connectionPoll.member.Member;

public interface IMemberDao {
	int memberInsert(Member member);
	Member memberSelect(Member member);
	int memberUpdate(Member member);
	int memberDelete(Member member);
}