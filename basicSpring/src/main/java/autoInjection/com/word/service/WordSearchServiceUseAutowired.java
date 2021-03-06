package autoInjection.com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import autoInjection.com.word.WordSet;
import autoInjection.com.word.dao.WordDao;

public class WordSearchServiceUseAutowired {
	
//	가장 많이 사용하는 방식
	@Autowired
//  동일한 스프링 컨테이너에 같은 이름의 빈 객체가 여러개 생성시 구분(빈 객체 선택)을 위해 사용
//	qualifier는 동일한 스프링 컨테이너에 같은 이름의 빈 객체가 여러개 생성시 구분(빈 객체 선택)을 위해 사용함 
//	@Qualifier("usedDao")
	private WordDao wordDao;
	
	public WordSearchServiceUseAutowired() {
		// TODO Auto-generated constructor stub
	}
	
//	@Autowired
	public WordSearchServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		
		return null;
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}
	
//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
