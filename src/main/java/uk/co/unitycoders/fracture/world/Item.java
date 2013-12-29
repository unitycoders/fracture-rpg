package uk.co.unitycoders.fracture.world;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by webpigeon on 28/12/13.
 */
public class Item {
    private BufferedImage sprite;

    public Item(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public Dimension getSize() {
        return new Dimension(sprite.getWidth(), sprite.getHeight());
    }

    public void render(Graphics g) {
        g.drawImage(sprite, 0, 0, null);
    }
}
