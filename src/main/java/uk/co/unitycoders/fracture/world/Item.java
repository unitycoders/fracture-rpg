package uk.co.unitycoders.fracture.world;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by webpigeon on 28/12/13.
 */
public class Item {
    private int typeID;
    private Set<Attribute> attributes;

    public Item(int typeID, Set<Attribute> attributeSet) {
        this.typeID = typeID;
        this.attributes = attributeSet;
    }

    public boolean hasAttribute(Attribute attr) {
        return attributes.contains(attr);
    }

    public boolean isGettable() {
        return attributes.contains(Attribute.GETTABLE);
    }

    public int getType() {
        return typeID;
    }
}
