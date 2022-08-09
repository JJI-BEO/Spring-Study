package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("lgTV")
public class LgTV implements TV{
	
	@Autowired
//	@Qualifier("apple")
	private Speaker speaker;
	
	public void powerOn() {
		System.out.println("LgTV---전원킨다.");
	}
	public void powerOff() {
		System.out.println("LgTV---전원끈다.");
	}
	public void volumeUp() {
//		System.out.println("LgTV---소리올린다.");
		speaker.volumeUp();
	}
	public void volumeDown() {
//		System.out.println("LgTV---소리내린다.");
		speaker.volumeDown();
	}
}