package lifeCycle.com.brms.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import lifeCycle.com.brms.book.Book;
import lifeCycle.com.brms.book.dao.BookDao;

// interface 이용하여  init-method, destroy-method 사용하기
public class BookRegisterService implements InitializingBean, DisposableBean{

	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}
	
	public void initMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 생성 단계");
	}
	
	public void destroyMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 소멸 단계");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("bean 객체 생성");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("bean 객체 소멸");
		
	}
}