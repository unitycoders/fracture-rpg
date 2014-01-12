package uk.co.unitycoders.fracture.world;

import java.awt.*;

/**
 * Created by webpigeon on 28/12/13.
 */
public class Avatar {
    private int avatarID;
    private Point point;

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
