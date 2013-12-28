package uk.co.unitycoders.fracture.world;

import javax.swing.*;
import java.awt.*;

/**
 * Created by webpigeon on 28/12/13.
 */
public class WorldComponent extends JComponent {
    private final WorldModel model;

    public WorldComponent(WorldModel model) {
        this.model = model;
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
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Graphics gTile = g2.create(row * 32, col * 32, 32, 32);

                Floor floor = model.getFloorAt(row, col);
                if (floor != null) {
                    floor.render(gTile);
                }

                Item item = model.getItemAt(row, col);
                if (item != null) {
                    item.render(gTile);
                }

                Avatar avatar = model.getAvatarAt(row, col);
                if (avatar != null) {
                    avatar.render(gTile);
                }

                //g.drawRect(row * 32, col * 32, 32, 32);
            }
        }
    }

}
