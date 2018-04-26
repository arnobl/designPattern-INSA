package flyweight;

import java.util.IdentityHashMap;
import java.util.Map;

public final class GlyphFactory {
	public static final GlyphFactory INSTANCE = new GlyphFactory();

	private Map<Character, Glyph> cacheGlyphs;

	private GlyphFactory() {
		cacheGlyphs = new IdentityHashMap<>();
	}

	public Glyph getGlyph(final char character) {
		return cacheGlyphs.computeIfAbsent(character, value -> new Glyph(value));
	}
}