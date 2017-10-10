package insa.activeobject.latexcompilation;

import java.awt.Image;
import java.util.concurrent.FutureTask;
import javax.swing.JTextField;

public class MyFutureTask extends FutureTask<Image> {
	Frame.DrawingArea area;

	public MyFutureTask(final JTextField textField, final Frame.DrawingArea area) {
		super(new LatexBuilder(textField.getText()));
		this.area = area;
	}

	// When the Future task is done, it can notifies its handler.
	@Override
	protected void done() {
		super.done();
		// In our case, the drawing area is notified to be repainted.
		area.repaint();
	}
}
