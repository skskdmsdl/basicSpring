package basicSpring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
//		TransportationWalk transportationWalk = new TransportationWalk();
//		transportationWalk.move();
		
		// applicationContext 빈에 등록해놨기에 위처럼 new 키워드 사용 안해도 됨(자바와 스프링의 차이점)
		// 스프링에서는 xml을 통해 객체를 생성 => 어노테이션 사용과 같음
		// 1. application 컨테이너에서 생성된 spring 컨테이너 접근
		// 파라미터로 어플리케이션 컨텍스트 리소스와 파일이름 적기("classpath:파일이름")
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml"); // 컨테이너 
		
		// 2. 컨테이너로부터 컨테이너의 객체(bean) 가져와서 변수에 담기 = 객체 불러오기
		TransportationWalk transportationWalk = ctx.getBean("tWalk", TransportationWalk.class); // bean의 id, 데이터 타입
		
		// 3. 객체 사용
		transportationWalk.move();
		
		// 4. 자바에서는 외부 리소스를 쓰면 반환해야함
		ctx.close();
		
	}
}
