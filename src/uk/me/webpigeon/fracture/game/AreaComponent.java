package uk.me.webpigeon.fracture.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class AreaComponent extends JComponent implements AreaListener {
	private static final long serialVersionUID = -6473101005822559578L;
	private Area area;
	private final AreaManager manager;

	public AreaComponent(AreaManager manager) {
		this.manager = manager;
		area = manager.getCurrentArea();
		manager.add(this);

		if (area != null) {
			this.setPreferredSize(new Dimension(area.getCols() * 32, area
					.getRows() * 32));
		}
	}

	@Override
	protected void paintComponent(Graphics g) {

		if (area == null) {
			return;
		}

		System.out.println("Configuring viewport sizes");
		// work out what's visible so we know what to draw
		Rectangle bounds = g.getClipBounds();
		Rectangle viewportRegion = new Rectangle();
		viewportRegion.x = bounds.x / 32;
		viewportRegion.y = bounds.y / 32;
		viewportRegion.width = Math.min(bounds.width / 32 + 1, area.getCols()
				- viewportRegion.x);
		viewportRegion.height = Math.min(bounds.height / 32 + 1, area.getRows()
				- viewportRegion.y);

		System.out.println("rendering world");
		// render each visible cell
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < viewportRegion.width; i++) {
			for (int j = 0; j < viewportRegion.height; j++) {
				int x = i + viewportRegion.x;
				int y = j + viewportRegion.y;

				drawCell(x, y, g2);
			}
		}

		g.setColor(Color.WHITE);
		g.drawRect(viewportRegion.x * 32, viewportRegion.y * 32,
				viewportRegion.width * 32, viewportRegion.height * 32);
	}

	protected void drawCell(int x, int y, Graphics g) {
		if (x > area.getCols() || y > area.getRows()) {
			return;
		}

		// render all the tiles in the stack
		for (Tile t : area.getTilesAt(x, y)) {
			t.render(g);
		}

		// render all the entities in the stack
		for (Entity e : area.getEntitiesAt(x, y)) {
			e.render(g);
		}
	}

	public static void main(String[] args) {

		TileSet set = GameFactory.buildTileset();
		Area area = new Area(20, 20);
		for (int x = 0; x < 20; x++) {
			for (int y = 0; y < 20; y++) {
				area.add(x, y, new FloorTile(set.getType(0)));
			}
		}

		AreaManager manager = new BasicAreaManager(set, area);
		AreaComponent component = new AreaComponent(manager);

		JFrame frame = new JFrame("RenderComponent Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(component);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void areaChanged() {
		this.area = manager.getCurrentArea();
		if (area != null) {
			this.setPreferredSize(new Dimension(area.getRows() * 32, area
					.getCols() * 32));
		}
		invalidate();
		repaint();
	}

	@Override
	public void tileChanged() {
		repaint();
	}

}
