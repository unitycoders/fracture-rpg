package uk.co.unitycoders.fracture.world;

import javax.persistence.Entity;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Created by webpigeon on 28/12/13.
 */
public class Floor{
    private BufferedImage sprite;

    public Floor(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public void render(Graphics g) {
        g.drawImage(sprite, 0, 0, null);
    }
}
