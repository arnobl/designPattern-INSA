package insa.structural

import javafx.scene.control.Button
import javax.swing.JButton

class Main {
	def foo() {
		val swingButton = new JButton()
		val javaFXButton = new Button()

		// Even if JButton and Button share no super class, then can be passed as argument to setVisibleWidget thanks
		// to a structural typing feature.
		setVisibleWidget(swingButton)
		setVisibleWidget(javaFXButton)
	}

	// Structural typing in scala. Not a mainstream feature (should be avoided)
	def setVisibleWidget(widget :{def setVisible(v:Boolean)}) {
		widget.setVisible(true)
	}
}
