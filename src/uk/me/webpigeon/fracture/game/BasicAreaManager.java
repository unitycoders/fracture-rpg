package uk.me.webpigeon.fracture.game;

import java.util.ArrayList;
import java.util.List;

public class BasicAreaManager implements AreaManager {
	private final TileSet set;
	private Area area;
	private final List<AreaListener> listeners;

	public BasicAreaManager(TileSet set, Area area) {
		this.set = set;
		this.area = area;
		this.listeners = new ArrayList<AreaListener>();
	}

	@Override
	public Area getCurrentArea() {
		return area;
	}

	@Override
	public void add(AreaListener listener) {
		listeners.add(listener);
	}

	@Override
	public void remove(AreaListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void fireTilesChanged() {
		for (AreaListener listener : listeners) {
			listener.tileChanged();
		}
	}

	public void fireAreaChanged() {
		for (AreaListener listener : listeners) {
			listener.areaChanged();
		}
	}

	@Override
	public void setCurrentArea(Area area) {
		this.area = area;
		fireAreaChanged();
	}

	@Override
	public TileSet getTileset() {
		return set;
	}

}
