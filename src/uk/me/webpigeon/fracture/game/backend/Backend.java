package uk.me.webpigeon.fracture.game.backend;

import uk.me.webpigeon.fracture.game.AreaManager;

public interface Backend {

	public void execute(Runnable task);

	public AreaManager buildAreaManager();

}
