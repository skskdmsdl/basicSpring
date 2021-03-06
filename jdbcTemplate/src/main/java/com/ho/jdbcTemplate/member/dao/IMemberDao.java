package com.ho.jdbcTemplate.member.dao;

import com.ho.jdbcTemplate.member.Member;

public interface IMemberDao {
	int memberInsert(Member member);
	Member memberSelect(Member member);
	int memberUpdate(Member member);
	int memberDelete(Member member);
}