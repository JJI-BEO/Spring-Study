package polymorphism;

//@Component("apple")
public class AppleSpeaker implements Speaker{

	public AppleSpeaker() {
		// TODO Auto-generated constructor stub
		System.out.println("���ý���Ŀ ��ü ����");
	}
	
	
	@Override
	public void volumeUp() {
		System.out.println("���ý���Ŀ �����ø�");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("���ý���Ŀ ��������");
		
	}
	
	

}