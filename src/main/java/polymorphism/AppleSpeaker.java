package polymorphism;

//@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		// TODO Auto-generated constructor stub
		System.out.println("애플스피커 객체 생성");
	}
	
	
	@Override
	public void volumeUp() {
		System.out.println("애플스피커 볼륨올림");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("애플스피커 볼륨내림");
		
	}
	
	

}