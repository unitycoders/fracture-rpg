package uk.co.unitycoders.fracture.world;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by webpigeon on 28/12/13.
 */
public class Item {
    private BufferedImage sprite;
    private boolean isGettable;

    public Item(BufferedImage sprite, boolean gettable) {
        this.sprite = sprite;
        this.isGettable = gettable;
    }

    public Dimension getSize() {
        return new Dimension(sprite.getWidth(), sprite.getHeight());
    }

    public boolean isGettable() {
        return isGettable;
    }

    public void render(Graphics g) {
        g.drawImage(sprite, 0, 0, null);
    }
}
