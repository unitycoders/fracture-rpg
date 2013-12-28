package uk.co.unitycoders.fracture.world;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by webpigeon on 28/12/13.
 */
public class Avatar {
    private BufferedImage sprite;
    private Point point;

    public Avatar(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public void render(Graphics g) {
        g.drawImage(sprite, 0, 0, null);
    }

    public void notifyPlacement(int x, int y) {
        this.point = new Point(x, y);
    }

    public Point getPoint() {
        return point;
    }
}
