package insa.command.swingaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
	public static void main(final String[] args) {
		final JButton button = new JButton();

		// The command ActionForMyButton is executed each time the button is used.
		button.setAction(new ActionForMyButton());

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(button);
		frame.setVisible(true);
		frame.pack();
	}
}


class ActionForMyButton extends AbstractAction {
	public ActionForMyButton() {
		super("My Button");
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		System.out.printf("Action performed by the command: %s%n", this);
	}
}
