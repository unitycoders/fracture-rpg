package uk.me.webpigeon.fracture.game;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JViewport;
import javax.swing.SwingUtilities;

public class AreaMouseScroller extends MouseAdapter {
	private final JViewport viewport;
	private Point startPt;

	public AreaMouseScroller(JViewport viewport) {
		this.viewport = viewport;
		// viewport.addMouseMotionListener(this);
		// viewport.addMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			startPt = e.getPoint();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e) && startPt != null) {
			Point pt = e.getPoint();
			int dx = startPt.x - pt.x;
			int dy = startPt.y - pt.y;

			Point vp = viewport.getViewPosition();
			vp.translate(dx, dy);

			vp.x = Math.max(vp.x, 0);
			vp.y = Math.max(vp.y, 0);

			viewport.setViewPosition(vp);
			viewport.repaint();
		}
	}

}
