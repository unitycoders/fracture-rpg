package uk.co.unitycoders.fracture.world;

import java.awt.image.BufferedImage;

/**
 * Created by webpigeon on 12/01/14.
 */
public class ArtSet {
    private BufferedImage[] items;
    private BufferedImage[] floor;
    private BufferedImage[] avatar;

    public ArtSet(BufferedImage[] items, BufferedImage[] floor, BufferedImage[] avatar) {
        this.items = items;
        this.floor = floor;
        this.avatar = avatar;
    }

    public BufferedImage getItem(int id) {
        return items[id];
    }

    public BufferedImage getFloor(int id) {
        return floor[id];
    }

    public BufferedImage getAvatar(int id) {
        return avatar[id];
    }
}
