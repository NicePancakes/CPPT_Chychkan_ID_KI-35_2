package Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Bullet {
	enum Kind {
		Blank, Ammunition
	};


	private Kind kind;
	private String name;
	private float size;
	private Qunpowder gunpowder;
	private boolean intact;
	private Printer printer;

	public Bullet(String name) throws FileNotFoundException {
		this.kind = Kind.Blank;
		this.name = name;
		this.size = 7.62f;
		this.printer = new Printer();
		this.printer.log("Bullet " + this.name + " created: " + this.kind);
		this.gunpowder = new Qunpowder(this.printer);
		this.intact = true;
	}

	public Bullet(String name, float size, int amount_powder, File file) throws FileNotFoundException {
		this.kind = Kind.Blank;
		this.name = name;
		this.size = size;
		this.printer = new Printer(file);
		this.printer.log("Bullet " + this.name + " created: " + this.kind);
		this.gunpowder = new Qunpowder(this.printer);
		this.gunpowder.set(amount_powder);
		this.intact = true;
	}

	public Bullet(String name, float size, int amount_powder, String filename) throws FileNotFoundException {
		this.kind = Kind.Blank;
		this.name = name;
		this.size = size;
		this.printer = new Printer(filename);
		this.printer.log("Bullet " + this.name + " created: " + this.kind);
		
		this.gunpowder = new Qunpowder(this.printer);
		this.intact = true;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Kind getState() {
		return this.kind;
	}

	public Kind shoot() {
		this.printer.log("Shot! Kind of bullet:" + this.kind);

		return this.kind;
	}

	public Kind change_kind() {
		this.kind = this.kind == Kind.Blank ? Kind.Ammunition : Kind.Blank;

		this.printer.log("TV turned:" + this.kind);

		return this.kind;
	}

	public float get_size() {
		return this.size;
	}
	
	public float set_size(float size) {
		return this.size = size;
	}

	public boolean disassemble_bullet() {
		intact = false;
		this.printer.log("Bullet assembled:" + this.intact);
		
		return this.intact;
	}
	
	public boolean assemble_bullet() {
		intact = true;
		this.printer.log("Bullet assembled:" + this.intact);
		
		return this.intact;
	}

	public int get_gunpowder() {
		return this.gunpowder.get();
	}

	public int set_gunpowder(int volume) {
		return this.gunpowder.set(volume);
	}

	public int increase_gunpowder(int volume) {
		return this.gunpowder.up_grams(volume);
	}

	public int increase_gunpowder() {
		return this.gunpowder.up_grams();
	}

	public int decrease_gunpowder(int volume) {
		return this.gunpowder.down_grams(volume);
	}

	public int decrease_gunpowder() {
		return this.gunpowder.down_grams();
	}

	public void dispose() {
		this.printer.dispose();
	}

	class Printer {
		private PrintWriter file;

		public Printer() throws FileNotFoundException {
			this.file = new PrintWriter(new File("log.txt"));
		}

		public Printer(File file) throws FileNotFoundException {
			this.file = new PrintWriter(file);
		}

		public Printer(String filename) throws FileNotFoundException {
			this.file = new PrintWriter(new File(filename));
		}

		public void log(String msg) {
			msg = msg.endsWith("\n") ? msg : msg + "\n";

			this.file.print(msg);
			this.file.flush();
		}

		public void dispose() {
			this.file.close();
		}
	}

	class Qunpowder {
		private int amount_powder; //in grams
		private Printer printer;

		public Qunpowder(Printer printer) {
			this.amount_powder = 5;
			this.printer = printer;

			this.printer.log("Bullet is ready");
		}

		public Qunpowder(Printer printer, int value) {
			this.amount_powder = value > 0 && value <= 10 ? value : 0;
			this.printer = printer;

			this.printer.log("Bullet is ready");
		}

		private void log() {
			this.printer.log("Amount powder set: " + this.amount_powder);
		}

		public int get() {
			return amount_powder;
		}

		public int set(int value) {
			if (value > 0 && value <= 10)
				this.amount_powder = value;

			this.log();
			return this.amount_powder;
		}

		public int up_grams() {
			this.amount_powder = Math.min(this.amount_powder + 1, 10);

			this.log();

			return this.amount_powder;
		}

		public int up_grams(int value) {
			this.amount_powder = Math.min(this.amount_powder + value, 10);

			this.log();

			return this.amount_powder;
		}

		public int down_grams() {
			this.amount_powder = Math.max(this.amount_powder - 1, 0);

			this.log();

			return this.amount_powder;
		}

		public int down_grams(int value) {
			this.amount_powder = Math.max(this.amount_powder - value, 0);

			this.log();

			return this.amount_powder;
		}
	}
}
