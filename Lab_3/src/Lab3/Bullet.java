package Lab3;

public abstract class Bullet {
	enum Kind {
		Blank, Ammunition
	};


	private Kind kind;
	private String name;
	private float size;
	private boolean intact;

	public Bullet(String name){
		this.kind = Kind.Blank;
		this.name = name;
		this.size = 7.62f;
		this.intact = true;
	}

	public Bullet(String name, float size, boolean intact){
		this.kind = Kind.Blank;
		this.name = name;
		this.size = size;
		this.intact = intact;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Kind getState() {
		return this.kind;
	}

	public Kind shoot() {
		System.out.println("Shot! Kind of bullet:" + this.kind);

		return this.kind;
	}

	public Kind change_kind() {
		this.kind = this.kind == Kind.Blank ? Kind.Ammunition : Kind.Blank;
		System.out.println("TV turned:" + this.kind);

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
		System.out.println("Bullet assembled:" + this.intact);
		
		return this.intact;
	}
	
	public boolean assemble_bullet() {
		intact = true;
		System.out.println("Bullet assembled:" + this.intact);
		
		return this.intact;
	}

}