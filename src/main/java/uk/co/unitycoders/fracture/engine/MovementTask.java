package uk.co.unitycoders.fracture.engine;

import uk.co.unitycoders.fracture.world.*;

import javax.persistence.EntityManager;
import java.awt.*;

/**
 * Created by webpigeon on 18/01/14.
 */
public class MovementTask implements Task {
    private Avatar avatar;
    private WorldModel model;
    private Point delta;
    private EntityManager manager;

    public MovementTask(Avatar avatar, WorldModel model, Point point) {
        this.avatar = avatar;
        this.model = model;
        this.delta = point;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        System.out.println("move by: "+delta);

        Point currentPos = avatar.getPoint();
        Point newPoint = new Point(currentPos.x + delta.x, currentPos.y + delta.y);

        Floor floor = model.getFloorAt(newPoint.x, newPoint.y);
        Item item = model.getItemAt(newPoint.x, newPoint.y);

        if (item == null || item.hasAttribute(Attribute.WALKABLE)) {
            model.setAvatarAt(currentPos.x, currentPos.y, null);
            model.setAvatarAt(newPoint.x, newPoint.y, avatar);
        }
    }


}
