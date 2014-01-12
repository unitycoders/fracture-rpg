package uk.co.unitycoders.fracture.world;

/**
 * Created by webpigeon on 28/12/13.
 */
public class Floor{
    private int typeID;

    public Floor(int typeID) {
        this.typeID = typeID;
    }

    public int getType() {
        return typeID;
    }
}
