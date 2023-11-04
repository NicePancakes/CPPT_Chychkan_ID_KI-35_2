package Lab2;

import java.io.*;

public class BulletApp {
	public static void main(String[] args) throws FileNotFoundException {
		Bullet bullet = new Bullet("1", 5.56f, 2, "logs.txt");
		bullet.disassemble_bullet();
		bullet.assemble_bullet();
		bullet.shoot();
		bullet.dispose();
	}
}
