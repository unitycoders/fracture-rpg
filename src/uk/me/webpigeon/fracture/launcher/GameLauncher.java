package uk.me.webpigeon.fracture.launcher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JViewport;

import uk.me.webpigeon.fracture.editor.LoadAction;
import uk.me.webpigeon.fracture.game.AreaManager;
import uk.me.webpigeon.fracture.game.AreaMouseScroller;
import uk.me.webpigeon.fracture.game.GameFactory;
import uk.me.webpigeon.fracture.game.backend.Backend;
import uk.me.webpigeon.fracture.game.backend.SinglePlayerBackend;

public class GameLauncher {

	public static void main(String[] args) {

		System.out.println("Starting Game Backend...");
		Backend backend = new SinglePlayerBackend();

		System.out.println("Building world...");
		AreaManager manager = backend.buildAreaManager();
		backend.execute(new LoadAction(manager));
		JComponent areaComponent = GameFactory.buildAreaComponent(manager);

		System.out.println("Building viewport...");
		JViewport viewport = new JViewport();
		viewport.setBackground(Color.BLACK);
		viewport.setView(areaComponent);

		MouseAdapter aptr = new AreaMouseScroller(viewport);
		areaComponent.addMouseMotionListener(aptr);
		areaComponent.addMouseListener(aptr);

		// Build the game panel
		JPanel gamePanel = new JPanel(new BorderLayout());
		gamePanel.add(viewport, BorderLayout.CENTER);

		CommonFactory.buildFrame("Fracture RPG", gamePanel);

	}
}
