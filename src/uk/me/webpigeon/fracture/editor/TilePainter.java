package uk.me.webpigeon.fracture.editor;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import uk.me.webpigeon.fracture.game.Area;
import uk.me.webpigeon.fracture.game.AreaManager;
import uk.me.webpigeon.fracture.game.FloorTile;
import uk.me.webpigeon.fracture.game.TileType;

public class TilePainter extends MouseAdapter {
	private final TypeSelectorModel model;
	private final AreaManager manager;

	public TilePainter(TypeSelectorModel model, AreaManager manager) {
		this.model = model;
		this.manager = manager;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			paintTile(e.getPoint());
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			paintTile(e.getPoint());
		}
	}

	private void paintTile(Point p) {
		TileType type = model.getSelectedType();

		if (type != null) {
			int x = p.x / 32;
			int y = p.y / 32;

			Area area = manager.getCurrentArea();
			if (area != null) {
				area.setTile(x, y, new FloorTile(type));
				manager.fireTilesChanged();
			}
		}
	}

}
