package lifeCycle.com.brms.book.service;

import org.springframework.beans.factory.annotation.Autowired;

import lifeCycle.com.brms.book.Book;
import lifeCycle.com.brms.book.dao.BookDao;

// bean 속성을 이용하여 init-method, destroy-method 사용하기 
public class BookSearchService {

	@Autowired
	private BookDao bookDao;
	
	public BookSearchService() { }
	
	public Book searchBook(String bNum) {
		Book book = bookDao.select(bNum);
		return book;
	}
	
	public void initMethod() {
		System.out.println("--initMethod--");
	}
	
	public void destroyMethod() {
		System.out.println("--destroyMethod--");
	}
	
}
