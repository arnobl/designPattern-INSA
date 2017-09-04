package insa.flyweight;

import java.util.IdentityHashMap;
import java.util.Map;

public final class FabriqueGlyphe {
	public static FabriqueGlyphe INSTANCE = new FabriqueGlyphe();

	private Map<Character, Glyphe> mapGlyphes;

	private FabriqueGlyphe() {
		mapGlyphes = new IdentityHashMap<>();
	}

	public Glyphe ObtenirGlyphe(char valeur) {
		return mapGlyphes.
			computeIfAbsent(valeur, v -> new Glyphe(v));
	}
}