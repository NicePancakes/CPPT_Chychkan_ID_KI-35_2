package Lab3;
interface CaptureTarget {

	public String GetCapturedTaget();
	public String SetCapturedTarget(String Target);
}

public class SmartBullet extends Bullet implements CaptureTarget{

	private String Target;
	public SmartBullet(String name) {
		super(name);
		System.out.println("This is SmartBullet");
	}

	public String GetCapturedTaget() {
		return this.Target;
	}
	
	public String SetCapturedTarget(String Target) {
		this.Target = Target;
		return this.Target;
	}




}
