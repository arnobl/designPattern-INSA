package insa.builder.jfx;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;

public class JFXBuilder {
	public static void main(final String[] args) {
		// A builder is first created and then parameterised to finally build the object.
		// Can be used to replace complex and multiple constructors.
		Text text1 = TextBuilder.create().text("Hello World!").x(50d).y(50d).fill(Color.WHITE).font(new Font(12d)).build();
		Text text2 = TextBuilder.create().text("Foo bar").x(-10d).y(0d).build();
	}
}
