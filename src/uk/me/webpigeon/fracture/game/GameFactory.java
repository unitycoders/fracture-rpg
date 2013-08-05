package uk.me.webpigeon.fracture.game;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JComponent;

import uk.me.webpigeon.fracture.launcher.CommonFactory;

public class GameFactory {
	public static final String RESOURCE_PATH = "/home/webpigeon/workspace/fracture-rpg/src/";
	public static final String DEFAULT_TILESET = RESOURCE_PATH + "tiles.ftsx";
	public static final String DEFAULT_TILESHEET = RESOURCE_PATH + "tiles.png";

	@Deprecated
	public static TileSet buildTileSetDebug() {
		try {
			BufferedImage tileSheet = CommonFactory
					.loadImage(DEFAULT_TILESHEET);
			BufferedImage[] tileSprites = CommonFactory.cutImage(tileSheet, 32,
					32);

			TileType[] types = new TileType[] {
					new TileType("Blank Area", tileSprites[0]),
					new TileType("Door (Locked)", tileSprites[1]),
					new TileType("Water", tileSprites[2]),
					new TileType("Door (Open)", tileSprites[3]),
					new TileType("Spawn Area", tileSprites[4]),
					new TileType("Placeholder", tileSprites[5]),
					new TileType("Window", tileSprites[6]),
					new TileType("Metal Floor", tileSprites[7]),
					new TileType("Wall (Weak)", tileSprites[8]),
					new TileType("Wall (Strong)", tileSprites[9]),
					new TileType("ForceField", tileSprites[10]) };

			return new TileSet(types);
		} catch (IOException ex) {
			ex.printStackTrace();
			return new TileSet(new TileType[0]);
		}
	}

	public static TileSet buildTileset() {
		try {
			FileInputStream fos = new FileInputStream(DEFAULT_TILESET);
			ObjectInputStream ios = new ObjectInputStream(fos);

			int version = ios.readInt();
			int tileCount = ios.readInt();

			BufferedImage sheet = CommonFactory.loadImage(DEFAULT_TILESHEET);
			BufferedImage[] sprites = CommonFactory.cutImage(sheet, 32, 32);

			TileType[] types = new TileType[tileCount];
			for (int i = 0; i < tileCount; i++) {
				String name = ios.readUTF();
				int spriteID = ios.readInt();
				types[i] = new TileType(name, sprites[spriteID]);
			}

			ios.close();

			return new TileSet(types);
		} catch (IOException ex) {
			ex.printStackTrace();
			return new TileSet(new TileType[0]);
		}

	}

	public static void GenerateTileset(TileSet set) {
		try {
			FileOutputStream fos = new FileOutputStream(DEFAULT_TILESET);
			ObjectOutputStream ios = new ObjectOutputStream(fos);

			ios.writeInt(1);
			int count = set.getSize();
			ios.writeInt(count);

			BufferedImage sheet = CommonFactory.loadImage(DEFAULT_TILESHEET);
			BufferedImage[] sprites = CommonFactory.cutImage(sheet, 32, 32);

			for (int i = 0; i < count; i++) {
				TileType type = set.getType(i);

				ios.writeUTF(type.getName());
				ios.writeInt(i);
			}

			ios.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public static AreaManager buildAreaManager(TileSet set) {
		return new BasicAreaManager(set, null);
	}

	/**
	 * Build an AreaComponent which allows in place editing of the area.
	 * 
	 * @return an editable area component
	 */
	public static JComponent buildAreaComponent(AreaManager manager) {
		AreaComponent areaComponent = new AreaComponent(manager);

		return areaComponent;
	}

}
