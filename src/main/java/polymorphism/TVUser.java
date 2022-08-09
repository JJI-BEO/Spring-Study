package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

		// 1 결합도가 높은 방식 
//		SamsungTV tv = new SamsungTV();
//		LgTV tv = new LgTV();

		// 2 다형성 .. interface 사용해 결합도를 낮추는 방식으로 개발 해야한다
		// 삼성티비와 엘지티비를 직접 호출해서 사용하는게아닌 인터페이스를 통해 사용한다
//		TV tv = new SamsungTV();
//		TV tv = new LgTV();
	
		// 3 팩토리에 호출해서 해당하는 클래스를 가져온다
//		BeanFactory factory = new BeanFactory(); 
//		TV tv = (TV)factory.getBean("samsung"); // TVUser클래스는 SamsungTV,LgTV 클래스의 존재를 모른다
//		TV tv = (TV)factory.getBean("lg");

		// 4  예전엔 팩토리를 직접 만들어야 했지만 스프링프레임워크에서 대신 만들어주기 때문에 안만들어도 됨
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); // 싱글톤 패턴임
		TV tv = (TV)factory.getBean("lgTV");
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		factory.close();
	}

}