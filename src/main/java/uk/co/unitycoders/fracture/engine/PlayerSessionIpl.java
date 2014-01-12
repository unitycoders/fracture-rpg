package uk.co.unitycoders.fracture.engine;

import uk.co.unitycoders.fracture.world.*;

import java.awt.*;

/**
 * Created by webpigeon on 28/12/13.
 */
public class PlayerSessionIpl implements PlayerSession {
    private WorldModel model;
    private Avatar avatar;

    public PlayerSessionIpl(WorldModel model, Avatar avatar) {
        this.model = model;
        this.avatar = avatar;
    }

    @Override
    public void moveNorth() {
        move(0, -1);
    }

    @Override
    public void moveSouth() {
        move(0, 1);
    }

    @Override
    public void moveEast() {
        move(1, 0);
    }

    @Override
    public void moveWest() {
        move(-1, 0);
    }

    private void move(int dx, int dy) {
        System.out.println("move "+dx+","+dy);

        Point currentPos = avatar.getPoint();
        Point newPoint = new Point(currentPos.x + dx, currentPos.y + dy);

        Floor floor = model.getFloorAt(newPoint.x, newPoint.y);
        Item item = model.getItemAt(newPoint.x, newPoint.y);

        if (item == null || item.hasAttribute(Attribute.WALKABLE)) {
            model.setAvatarAt(currentPos.x, currentPos.y, null);
            model.setAvatarAt(newPoint.x, newPoint.y, avatar);
        }
    }

    @Override
    public void pickUp() {
        Point currentPos = avatar.getPoint();
        Item item = model.getItemAt(currentPos.x, currentPos.y);
        if (item != null) {
            if (item.isGettable()) {
                System.out.println("picked up item at: "+item);
                model.setItemAt(currentPos.x, currentPos.y, null);
            } else {
                System.out.println("asked to pick up item, but not gettable "+item);
            }
        }
    }

    @Override
    public void use() {

    }
}
