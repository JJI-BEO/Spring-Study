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
		System.out.println("===> SamsungTV ��ü����");
	}
	public SamsungTV(Speaker speaker) {
		super();
		System.out.println("--->SamsunTv(2) ��ü����");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		super();
		System.out.println("--->SamsunTv(3) ��ü����");
		this.speaker = speaker;
		this.price = price;
	}
	public void powerOn() {
		System.out.println("SamsungTv---����Ų��.(����: "+ price +")");
	}
	public void powerOff() {
		System.out.println("SamsungTv---��������.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
	
}