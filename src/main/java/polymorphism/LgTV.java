package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("lgTV")
public class LgTV implements TV{
	
	@Autowired
//	@Qualifier("apple")
	private Speaker speaker;
	
	public void powerOn() {
		System.out.println("LgTV---����Ų��.");
	}
	public void powerOff() {
		System.out.println("LgTV---��������.");
	}
	public void volumeUp() {
//		System.out.println("LgTV---�Ҹ��ø���.");
		speaker.volumeUp();
	}
	public void volumeDown() {
//		System.out.println("LgTV---�Ҹ�������.");
		speaker.volumeDown();
	}
}