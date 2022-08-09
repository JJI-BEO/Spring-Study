package polymorphism;

//@Component("sony")
public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 按眉积己");
	}
	
	public void volumeUp() {
		System.out.println("SonySpeak --- 家府棵赴促");
	}
	public void volumeDown() {
		System.out.println("SonySpeak --- 家府郴赴促");
	}
}