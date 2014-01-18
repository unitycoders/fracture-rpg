package uk.co.unitycoders.fracture.world;

import java.io.Serializable;

/**
 * Created by webpigeon on 18/01/14.
 */
public class WorldPoint implements Serializable {
    public int x;
    public int y;

    public WorldPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
