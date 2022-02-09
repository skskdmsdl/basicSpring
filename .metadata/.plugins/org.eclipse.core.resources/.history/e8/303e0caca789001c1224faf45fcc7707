package lifeCycle.com.brms.book.service;

import org.springframework.beans.factory.annotation.Autowired;

import lifeCycle.com.brms.book.Book;
import lifeCycle.com.brms.book.dao.BookDao;

public class BookSearchService {

	@Autowired
	private BookDao bookDao;
	
	public BookSearchService() { }
	
	public Book searchBook(String bNum) {
		Book book = bookDao.select(bNum);
		return book;
	}
	
}
