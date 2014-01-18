package uk.co.unitycoders.fracture.world;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by webpigeon on 18/01/14.
 */
public class TypeRegistry {
    private final Map<Integer, Item> items;
    private final Map<Integer, Floor> floors;
    private final Map<Integer, Avatar> avatars;

    public TypeRegistry() {
        this.items = new TreeMap<Integer, Item>();
        this.floors = new TreeMap<Integer, Floor>();
        this.avatars = new TreeMap<Integer, Avatar>();
    }

    public void addItem(int id, Item item) {
        items.put(id, item);
    }

    public Item getItem(int id) {
        return items.get(id);
    }

    public void setFloor(int id, Floor floor) {
        floors.put(id, floor);
    }

    public Floor getFloor(int id) {
        return floors.get(id);
    }

}
