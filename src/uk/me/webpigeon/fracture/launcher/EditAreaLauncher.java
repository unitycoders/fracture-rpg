package uk.me.webpigeon.fracture.launcher;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JViewport;

import uk.me.webpigeon.fracture.editor.EditorFactory;
import uk.me.webpigeon.fracture.game.AreaComponent;
import uk.me.webpigeon.fracture.game.AreaManager;
import uk.me.webpigeon.fracture.game.GameFactory;
import uk.me.webpigeon.fracture.game.TileSet;

public class EditAreaLauncher {

	public static void main(String[] args) {

		System.out.println("Building world...");
		TileSet set = GameFactory.buildTileset();

		if (set.getSize() == 0) {
			System.out.println("could not load tileset!");

			System.out
					.println("as we don't have a proper tileset editor yet, i will generate a debug set for you.");
			set = GameFactory.buildTileSetDebug();
			GameFactory.GenerateTileset(set);
			System.exit(1);
		}

		System.out.println("Building viewport...");
		JViewport viewport = new JViewport();
		viewport.setBackground(Color.BLACK);

		AreaManager manager = GameFactory.buildAreaManager(set);
		AreaComponent areaComponent = EditorFactory.buildAreaComponent(manager,
				viewport);

		JComponent tilePallet = EditorFactory.makeEditable(areaComponent, set,
				manager);

		// Build the game panel
		JPanel gamePanel = new JPanel(new BorderLayout());
		gamePanel.add(viewport, BorderLayout.CENTER);
		gamePanel.add(tilePallet, BorderLayout.EAST);
		gamePanel.add(EditorFactory.buildToolbar(manager), BorderLayout.NORTH);
		CommonFactory.buildFrame("Fracture Area Editor", gamePanel);
	}
}
