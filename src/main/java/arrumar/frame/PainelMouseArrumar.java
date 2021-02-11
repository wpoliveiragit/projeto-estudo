package frame;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

class PainelMouseArrumar extends JPanel implements MouseMotionListener {

	private static final long serialVersionUID = 1L;

	public PainelMouseArrumar() {
		addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent evt) {
		Graphics g = getGraphics();
		g.drawLine(evt.getX(), evt.getY(), 1, 1);
		g.dispose();
	}

	@Override
	public void mouseMoved(MouseEvent evt) {
		System.out.println("x:" + evt.getX() + ", y:" + evt.getY());
	}

	static class JanelaMouse extends JFrame {

		private static final long serialVersionUID = 1L;

		public JanelaMouse() {
			setSize(800, 600);
			getContentPane().add(new PainelMouseArrumar());
		}
	}

	public static void main(String args[]) {
		JanelaMouse jm = new JanelaMouse();
		jm.setVisible(true);
	}
}
