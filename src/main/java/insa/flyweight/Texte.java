package insa.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Texte {
	final List<Glyphe> glyphes;

	public Texte() {
		glyphes = new ArrayList<>();
	}

	public void afficher() {
		//...
	}

	public void ajouterGlyphe(char valeur) {
		glyphes.add(
			FabriqueGlyphe.INSTANCE.ObtenirGlyphe(valeur));
	}
}
