package uk.me.webpigeon.fracture.game;

import java.awt.Graphics;
import java.io.Serializable;

public interface Tile extends Serializable {

	public void init(Area area, int x, int y);

	public TileType getType();

	public void render(Graphics g);

}
