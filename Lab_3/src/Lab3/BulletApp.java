package Lab3;

import java.io.*;

public class BulletApp {
	public static void main(String[] args) throws FileNotFoundException {
		SmartBullet bullet = new SmartBullet("1");
		bullet.disassemble_bullet();
		bullet.assemble_bullet();
		bullet.change_kind();
		bullet.shoot();
		bullet.SetCapturedTarget("Enemy1");
		System.out.println("Bullet target is " + bullet.GetCapturedTaget());
	}
}
