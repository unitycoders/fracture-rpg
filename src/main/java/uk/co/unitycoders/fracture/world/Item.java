package uk.co.unitycoders.fracture.world;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by webpigeon on 28/12/13.
 */
@Entity
public class Item {
    @Id
    private int typeID;
    private Set<Attribute> attributes;

    public Item() {

    }

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
