package polymorphism;

public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 객체생성");
	}
	
	public void volumeUp() {
		System.out.println("SonySpeak --- 소리올린다");
	}
	public void volumeDown() {
		System.out.println("SonySpeak --- 소리내린다");
	}
}
