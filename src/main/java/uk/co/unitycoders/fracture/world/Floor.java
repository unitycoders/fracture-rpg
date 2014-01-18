package uk.co.unitycoders.fracture.world;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by webpigeon on 28/12/13.
 */
@Entity
public class Floor{
    @Id
    private int typeID;

    public Floor(){

    }

    public Floor(int typeID) {
        this.typeID = typeID;
    }

    public int getType() {
        return typeID;
    }
}
