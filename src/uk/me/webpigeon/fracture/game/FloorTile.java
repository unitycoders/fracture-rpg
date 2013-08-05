package uk.me.webpigeon.fracture.game;

import java.awt.Graphics;

public class FloorTile implements Tile {
	private final TileType type;
	private int x, y;

	public FloorTile(TileType type) {
		this.type = type;
	}

	@Override
	public void render(Graphics g) {
		type.render(x * 32, y * 32, g);
	}

	@Override
	public void init(Area area, int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public TileType getType() {
		return type;
	}

}
