package uk.me.webpigeon.fracture.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class TileType implements Serializable {
	private TileSet set;
	private int id;
	private final String name;
	private final BufferedImage image;

	public TileType(String name, BufferedImage image) {
		this.name = name;
		this.image = image;
	}

	public void init(TileSet set, int id) {
		this.set = set;
		this.id = id;
	}

	public int getID() {
		return id;
	}

	public void render(int x, int y, Graphics g) {
		g.drawImage(image, x, y, null);
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

}
