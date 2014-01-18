package uk.co.unitycoders.fracture.engine;

import uk.co.unitycoders.fracture.world.*;

import java.awt.*;

/**
 * Created by webpigeon on 28/12/13.
 */
public class PlayerSessionIpl implements PlayerSession {
    private WorldModel model;
    private Avatar avatar;
    private TaskManager manager;

    public PlayerSessionIpl(TaskManager manager, WorldModel model, Avatar avatar) {
        this.manager = manager;
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
        manager.addTask(new MovementTask(avatar, model, new Point(dx, dy)));
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
