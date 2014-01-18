package uk.co.unitycoders.fracture.world;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.awt.*;

/**
 * Created by webpigeon on 28/12/13.
 */
@Entity
public class Avatar {
    @Id
    private int avatarID;
    private Point point;

    public Avatar() {

    }

    public Avatar(int avatarID) {
        this.avatarID = avatarID;
    }

    public void notifyPlacement(int x, int y) {
        this.point = new Point(x, y);
    }

    public Point getPoint() {
        return point;
    }

    public int getType() {
        return avatarID;
    }
}
