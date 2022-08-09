package polymorphism;

import lombok.Setter;

@Setter
public class SamsungTV implements TV{
	
//    private SonySpeaker speaker;
    private Speaker speaker;
    private int price;
    
	public SamsungTV() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("===> SamsungTV 객체생성");
	}
	public SamsungTV(Speaker speaker) {
		super();
		System.out.println("--->SamsunTv(2) 객체생성");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		super();
		System.out.println("--->SamsunTv(3) 객체생성");
		this.speaker = speaker;
		this.price = price;
	}
	public void powerOn() {
		System.out.println("SamsungTv---전원킨다.(가격: "+ price +")");
	}
	public void powerOff() {
		System.out.println("SamsungTv---전원끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
	
}
