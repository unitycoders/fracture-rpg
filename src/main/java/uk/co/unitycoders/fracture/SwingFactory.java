package uk.co.unitycoders.fracture;

import uk.co.unitycoders.fracture.world.ArtSet;
import uk.co.unitycoders.fracture.world.WorldComponent;
import uk.co.unitycoders.fracture.world.WorldModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by webpigeon on 28/12/13.
 */
public class SwingFactory {

    public static JFrame buildFrame() {
        JFrame frame = new JFrame("Fracture RPG");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }

    public static ArtSet buildDemoArt() throws IOException {
        ClassLoader loader = FractureLauncher.class.getClassLoader();
        BufferedImage[] floorImg = new BufferedImage[]{
                ImageIO.read(loader.getResourceAsStream("floor.png"))
        };

        BufferedImage[] itemImg = new BufferedImage[]{
                ImageIO.read(loader.getResourceAsStream("wrench.png")),
                ImageIO.read(loader.getResourceAsStream("wall.png")),
                ImageIO.read(loader.getResourceAsStream("wall_top.png"))
        };

        BufferedImage[] avatarImg = new BufferedImage[]{
                ImageIO.read(loader.getResourceAsStream("avatar.png"))
        };

        return new ArtSet(itemImg, floorImg, avatarImg);
    }

    public static JComponent buildSidePanel() {
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(210, 600));
        return sidePanel;
    }

    public static JComponent buildBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 125));
        return bottomPanel;
    }

    public static JComponent buildView(WorldModel model, ArtSet set) {
        //create the "real" world component
        WorldComponent comp = new WorldComponent(model, set);

        //create the viewport for the player
        JViewport viewport = new JViewport();
        viewport.setView(comp);
        viewport.addKeyListener(new ViewportScroller(viewport));

        return viewport;
    }

}
