package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

		// 1 ���յ��� ���� ��� 
//		SamsungTV tv = new SamsungTV();
//		LgTV tv = new LgTV();

		// 2 ������ .. interface ����� ���յ��� ���ߴ� ������� ���� �ؾ��Ѵ�
		// �ＺƼ��� ����Ƽ�� ���� ȣ���ؼ� ����ϴ°Ծƴ� �������̽��� ���� ����Ѵ�
//		TV tv = new SamsungTV();
//		TV tv = new LgTV();
	
		// 3 ���丮�� ȣ���ؼ� �ش��ϴ� Ŭ������ �����´�
//		BeanFactory factory = new BeanFactory(); 
//		TV tv = (TV)factory.getBean("samsung"); // TVUserŬ������ SamsungTV,LgTV Ŭ������ ���縦 �𸥴�
//		TV tv = (TV)factory.getBean("lg");

		// 4  ������ ���丮�� ���� ������ ������ �����������ӿ�ũ���� ��� ������ֱ� ������ �ȸ��� ��
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml"); // �̱��� ������
		TV tv = (TV)factory.getBean("samsungTV");
		TV tv1 = (TV)factory.getBean("samsungTV");
		TV tv2= (TV)factory.getBean("samsungTV");
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		factory.close();
	}

}