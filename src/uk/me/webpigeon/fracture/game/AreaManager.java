package uk.me.webpigeon.fracture.game;

public interface AreaManager {

	public Area getCurrentArea();

	public void add(AreaListener listener);

	public void remove(AreaListener listener);

	public void fireTilesChanged();

	public void setCurrentArea(Area area);

	public TileSet getTileset();

}
