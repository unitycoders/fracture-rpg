package uk.co.unitycoders.fracture.world;

/**
 * Created by webpigeon on 28/12/13.
 */
public class Item {
    private int typeID;
    private boolean isGettable;

    public Item(int typeID, boolean gettable) {
        this.typeID = typeID;
        this.isGettable = gettable;
    }

    public boolean isGettable() {
        return isGettable;
    }

    public int getType() {
        return typeID;
    }
}
