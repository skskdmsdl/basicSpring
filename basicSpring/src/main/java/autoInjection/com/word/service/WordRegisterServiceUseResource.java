package autoInjection.com.word.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import autoInjection.com.word.WordSet;
import autoInjection.com.word.dao.WordDao;

public class WordRegisterServiceUseResource {

	@Resource // @Resource는 생성자에는 사용 X, 프로퍼티, 메소드에 사용 가능
//	@Qualifier("usedDao")
	private WordDao wordDao;
	
	// 디폴트 생성자 명시 필요
	public WordRegisterServiceUseResource() {
		
	}
	
	//@Resource
	public WordRegisterServiceUseResource(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	//@Resource
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}