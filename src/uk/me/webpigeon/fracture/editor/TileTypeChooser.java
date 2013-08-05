package uk.me.webpigeon.fracture.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import uk.me.webpigeon.fracture.game.GameFactory;
import uk.me.webpigeon.fracture.game.TileSet;
import uk.me.webpigeon.fracture.game.TileType;

public class TileTypeChooser extends JComponent implements SelectionListener {
	private static final long serialVersionUID = 2321107004319272662L;
	private final Integer TILE_WIDTH = 5;
	private final TileSet set;
	private final TypeSelectorModel model;

	public TileTypeChooser(TileSet set, TypeSelectorModel model) {
		this.set = set;
		this.model = model;

		int cols = (int) Math.ceil(set.getSize() / (TILE_WIDTH * 1.0));
		this.setPreferredSize(new Dimension(TILE_WIDTH * 32, cols * 32));
		this.setToolTipText("Tile Type Selector");
	}

	@Override
	protected void paintComponent(Graphics g) {
		Integer selected = model.getSelected();

		for (int i = 0; i < set.getSize(); i++) {
			int x = i % TILE_WIDTH;
			int y = i / TILE_WIDTH;

			TileType type = set.getType(i);
			if (type != null) {
				type.render(x * 32, y * 32, g);
			}
		}

		if (selected != null) {
			int x = selected % TILE_WIDTH;
			int y = selected / TILE_WIDTH;
			g.setColor(Color.red);
			g.drawRect(x * 32, y * 32, 32, 32);
		}

	}

	public int getTypeAtPoint(Point p) {
		int x = p.x / 32;
		int y = p.y / 32;

		return x + y * TILE_WIDTH;
	}

	@Override
	public void onSelectionChanged() {
		repaint();
	}

	@Override
	public String getToolTipText(MouseEvent event) {
		int x = event.getX() / 32;
		int y = event.getY() / 32;
		int id = x * y + TILE_WIDTH;

		TileType type = set.getType(id);
		if (type != null) {
			return type.toString();
		}

		return "";
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Tile Selector Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TileSet set = GameFactory.buildTileset();
		TypeSelectorModel model = new TypeSelectorModel(set);

		TileTypeChooser selector = new TileTypeChooser(set, model);
		TileTypeSelectionAdapter adapater = new TileTypeSelectionAdapter(model,
				selector);
		selector.addMouseListener(adapater);

		frame.add(new JScrollPane(selector));

		frame.pack();
		frame.setVisible(true);
	}

}
