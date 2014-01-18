package uk.co.unitycoders.fracture.world;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by webpigeon on 28/12/13.
 */
public class WorldComponent extends JComponent {
    private final WorldModel model;
    private final ArtSet art;

    public WorldComponent(WorldModel model, ArtSet art) {
        super();
        this.model = model;
        this.art = art;
        this.setSize(model.getWidth() * 32, model.getHeight() * 32);
        this.setPreferredSize(new Dimension(model.getWidth() * 32, model.getHeight() * 32));
    }

    protected void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g2 = (Graphics2D)g1;

        g2.scale(1.5, 1.5);

        //TODO limit drawing to areas of the screen which we are asked to render
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        int width = model.getWidth();
        int height = model.getHeight();

        g2.setColor(Color.WHITE);
        for (int row = height-1; row >= 0; row--) {
            for (int col = 0; col < width; col++) {
                Graphics gTile = g2.create(row * 32, col * 32, 32, 32);

                Floor floor = model.getFloorAt(row, col);
                if (floor != null) {
                    int type = floor.getType();
                    BufferedImage typeImg = art.getFloor(type);
                    gTile.drawImage(typeImg, 0, 0, null);
                }

                Item item = model.getItemAt(row, col);
                if (item != null) {
                    int type = item.getType();
                    BufferedImage typeImg = art.getItem(type);


                    Dimension size = new Dimension(typeImg.getWidth(), typeImg.getHeight());

                    int offsetY = 32 - size.height;

                    Graphics gItem = g2.create(row * 32, col * 32 + offsetY, size.width, size.height);
                    gItem.drawImage(typeImg, 0, 0, null);
                }

                Avatar avatar = model.getAvatarAt(row, col);
                if (avatar != null) {
                    int type = avatar.getType();
                    BufferedImage typeImg = art.getAvatar(type);
                    gTile.drawImage(typeImg, 0, 0, null);
                }

                //g.drawRect(row * 32, col * 32, 32, 32);
            }
        }
    }

}
