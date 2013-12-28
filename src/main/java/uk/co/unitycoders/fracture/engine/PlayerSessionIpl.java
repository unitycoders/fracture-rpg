package uk.co.unitycoders.fracture.engine;

import uk.co.unitycoders.fracture.world.Avatar;
import uk.co.unitycoders.fracture.world.Item;
import uk.co.unitycoders.fracture.world.WorldModel;

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
        model.setAvatarAt(currentPos.x, currentPos.y, null);
        model.setAvatarAt(currentPos.x + dx, currentPos.y + dy, avatar);
    }

    @Override
    public void pickUp() {
        Point currentPos = avatar.getPoint();
        Item item = model.getItemAt(currentPos.x, currentPos.y);
        if (item != null) {
            System.out.println("picked up item at: "+item);
            model.setItemAt(currentPos.x, currentPos.y, null);
        }
    }

    @Override
    public void use() {

    }
}
