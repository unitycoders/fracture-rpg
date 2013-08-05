package uk.me.webpigeon.fracture.game;

import java.awt.Dimension;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Area implements Serializable {
	private final Dimension size;
	private final List<Tile>[] tiles;
	private final List<Entity>[] entities;

	@SuppressWarnings("unchecked")
	public Area(int rows, int cols) {
		this.size = new Dimension(rows, cols);
		this.tiles = (List<Tile>[]) Array.newInstance(ArrayList.class, rows
				* cols);
		this.entities = (List<Entity>[]) Array.newInstance(ArrayList.class,
				rows * cols);
		init();
	}

	private void init() {
		for (int i = 0; i < size.width * size.height; i++) {
			tiles[i] = new ArrayList<Tile>();
			entities[i] = new ArrayList<Entity>();
		}
	}

	public void add(int x, int y, Tile t) {
		tiles[x + y * size.width].add(t);
		t.init(this, x, y);
	}

	public int getRows() {
		return size.height;
	}

	public int getCols() {
		return size.width;
	}

	public Collection<Tile> getTilesAt(int x, int y) {
		return Collections.unmodifiableCollection(tiles[x + y * size.width]);
	}

	public Collection<Entity> getEntitiesAt(int x, int y) {
		return Collections
				.unmodifiableCollection(entities[x * y + size.height]);
	}

	public void setTile(int x, int y, Tile tile) {
		if (x >= size.width || y >= size.height) {
			return;
		}

		int id = x + y * size.width;
		tiles[id].clear();
		tiles[id].add(tile);
		tile.init(this, x, y);
	}

}
