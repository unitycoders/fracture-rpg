package uk.me.webpigeon.fracture.game;

public class TileSet {
	private final TileType[] types;

	public TileSet(TileType[] types) {
		this.types = types;
		for (int i = 0; i < types.length; i++) {
			if (types[i] != null) {
				types[i].init(this, i);
			}
		}
	}

	public TileType getType(int id) {
		if (id >= types.length) {
			return null;
		}

		return types[id];
	}

	public int getSize() {
		return types.length;
	}

}
