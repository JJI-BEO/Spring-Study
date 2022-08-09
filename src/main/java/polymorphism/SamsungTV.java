package polymorphism;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SamsungTV implements TV{
	
//    private SonySpeaker speaker;
    private Speaker speaker;
    private int price;
    
	public SamsungTV() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("===> SamsungTV 按眉积己");
	}
	public SamsungTV(Speaker speaker) {
		super();
		System.out.println("--->SamsunTv(2) 按眉积己");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		super();
		System.out.println("--->SamsunTv(3) 按眉积己");
		this.speaker = speaker;
		this.price = price;
	}
	public void powerOn() {
		System.out.println("SamsungTv---傈盔挪促.(啊拜: "+ price +")");
	}
	public void powerOff() {
		System.out.println("SamsungTv---傈盔馋促.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
	
}