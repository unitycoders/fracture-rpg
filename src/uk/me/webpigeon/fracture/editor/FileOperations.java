package uk.me.webpigeon.fracture.editor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;

import uk.me.webpigeon.fracture.game.Area;
import uk.me.webpigeon.fracture.game.FloorTile;
import uk.me.webpigeon.fracture.game.Tile;
import uk.me.webpigeon.fracture.game.TileSet;
import uk.me.webpigeon.fracture.game.TileType;

public class FileOperations {

	public static Area buildArea(ObjectInputStream ois, TileSet set) {

		try {
			int width = ois.readInt();
			int height = ois.readInt();

			Area area = new Area(width, height);
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					int typeID = ois.readInt();
					TileType type = set.getType(typeID);

					area.add(x, y, new FloorTile(type));
				}
			}

			return area;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public static void writeArea(ObjectOutputStream ois, Area area) {

		try {
			int width = area.getCols();
			int height = area.getRows();
			ois.writeInt(width);
			ois.writeInt(height);

			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					Collection<Tile> tiles = area.getTilesAt(x, y);
					Iterator<Tile> tileItr = tiles.iterator();

					if (tileItr.hasNext()) {
						Tile t = tileItr.next();
						ois.writeInt(t.getType().getID());
					} else {
						ois.writeInt(0);
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
