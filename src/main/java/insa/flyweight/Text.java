package insa.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Text {
	private final List<Glyph> glyphs;

	public Text() {
		super();
		glyphs = new ArrayList<>();
	}

	public void display() {
		//...
	}

	public void addGlyph(final char character) {
		glyphs.add(GlyphFactory.INSTANCE.getGlyph(character));
	}
}
