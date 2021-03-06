package lifeCycle.com.brms.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import lifeCycle.com.brms.member.Member;
import lifeCycle.com.brms.member.dao.MemberDao;

public class MemberSearchService {

	@Autowired
	private MemberDao memberDao;
	
	public MemberSearchService() { }
	
	public Member searchMember(String mId) {
		return memberDao.select(mId);
	}
	
}