package exercises.exercise11;

public abstract class Arbre {
	protected int age;
	protected int hauteur;

	public Arbre(final int age, final int hauteur) {
		this.age = age;
		this.hauteur = hauteur;
	}
}

class Chene extends Arbre {
	private boolean feuilles;

	public Chene(final int age, final int hauteur, final boolean feuilles) {
		super(age, hauteur);
		this.feuilles = feuilles;
	}
}

class Pin extends Arbre {
	private int cones;

	public Pin(final int age, final int hauteur, final int cones) {
		super(age, hauteur);
		this.cones = cones;
	}
}

class Main {
	public static void main(final String[] args) {
	}
}
