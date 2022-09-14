package flyweight;

public class MainGlyph {
	public static void main(final String[] args) {
		System.out.println(GlyphFactory.INSTANCE.getGlyph('a'));
		System.out.println(GlyphFactory.INSTANCE.getGlyph('a'));
		System.out.println(GlyphFactory.INSTANCE.getGlyph('b'));
		System.out.println(GlyphFactory.INSTANCE.getGlyph('b'));
	}
}
