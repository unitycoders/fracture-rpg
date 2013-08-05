package uk.me.webpigeon.fracture.game.backend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import uk.me.webpigeon.fracture.game.Area;
import uk.me.webpigeon.fracture.game.AreaManager;
import uk.me.webpigeon.fracture.game.GameFactory;
import uk.me.webpigeon.fracture.game.TileSet;

public class SinglePlayerBackend implements Backend {
	private final ExecutorService service;
	private final Area area;

	public SinglePlayerBackend() {
		service = Executors.newCachedThreadPool();
		area = new Area(20, 20);
	}

	@Override
	public AreaManager buildAreaManager() {
		TileSet set = GameFactory.buildTileset();
		AreaManager manager = GameFactory.buildAreaManager(set);
		manager.setCurrentArea(area);
		return manager;
	}

	@Override
	public void execute(Runnable task) {
		service.execute(task);
	}

}
