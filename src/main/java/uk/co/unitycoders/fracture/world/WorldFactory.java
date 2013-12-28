package uk.co.unitycoders.fracture.world;

/**
 * Created by webpigeon on 28/12/13.
 */
public class WorldFactory {

    public static WorldModel buildWorldModel(int rows, int cols) {
        return new WorldModelIpl(rows, cols);
    }
}
