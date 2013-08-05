package uk.me.webpigeon.fracture.game;

import java.awt.Graphics;
import java.io.Serializable;

public interface Entity extends Serializable {

	public void render(Graphics g);

}
