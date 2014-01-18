package uk.co.unitycoders.fracture.world;

/**
 * Created by webpigeon on 18/01/14.
 */
public class MathUtils {

    public static WorldPoint cellToPos(int id, int width) {
        return new WorldPoint(id / width, id % width);
    }

    public static int PosToCell(WorldPoint p, int width) {
        return p.y * width + p.x;
    }

}
