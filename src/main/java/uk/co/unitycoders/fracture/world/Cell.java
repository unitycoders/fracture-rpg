package uk.co.unitycoders.fracture.world;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by webpigeon on 18/01/14.
 */
@Entity
public class Cell {
    @Id
    public WorldPoint point;
    public Floor floor;
    public Item item;

}
