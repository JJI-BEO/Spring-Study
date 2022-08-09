package polymorphism;

public class BeanFactory {
	// 클래스 형식으로 만들 파일들을 모두 빈으로 본다 
	public Object getBean(String beanName) {
		
		if(beanName.equals("samsung")) {
			return new SamsungTV();
		} else if(beanName.equals("lg")) {
			return new LgTV();
		} 
		
		return null;
	}
	
}