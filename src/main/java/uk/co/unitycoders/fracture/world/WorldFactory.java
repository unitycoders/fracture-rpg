package uk.co.unitycoders.fracture.world;

import java.lang.reflect.Type;

/**
 * Created by webpigeon on 28/12/13.
 */
public class WorldFactory {

    public static WorldModel buildWorldModel(int rows, int cols) {
        return new WorldModelIpl(rows, cols);
    }

    public static TypeRegistry buildRegistry() {
        TypeRegistry registry = new TypeRegistry();

        Floor floor = new Floor(0);
        registry.setFloor(0, floor);

        Item wrench = new Item(0, true, true);
        registry.addItem(0, wrench);

        Item wall = new Item(1, false, false);
        registry.addItem(1, wall);

        Item wall2 = new Item(2, false, false);
        registry.addItem(2, wall2);

        return registry;
    }
}
