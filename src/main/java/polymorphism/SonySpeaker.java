package polymorphism;

public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
		System.out.println("===> SonySpeaker ��ü����");
	}
	
	public void volumeUp() {
		System.out.println("SonySpeak --- �Ҹ��ø���");
	}
	public void volumeDown() {
		System.out.println("SonySpeak --- �Ҹ�������");
	}
}