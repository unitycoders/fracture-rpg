package uk.co.unitycoders.fracture.world;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by webpigeon on 28/12/13.
 */
public class WorldFactory {

    public static WorldModel buildWorldModel(int rows, int cols) {
        return new WorldModelIpl(rows, cols);
    }

    public static TypeRegistry buildRegistry() throws IOException {
        ClassLoader loader = WorldFactory.class.getClassLoader();
        Map<Integer, Item> itemMap = TypeReader.readJsonStream(loader.getResourceAsStream("config/items.json"));

        TypeRegistry registry = new TypeRegistry(itemMap, new TreeMap<Integer, Floor>());

        Floor floor = new Floor(0);
        registry.setFloor(0, floor);


        return registry;
    }
}
