package uk.co.unitycoders.fracture;

import uk.co.unitycoders.fracture.engine.PlayerSession;
import uk.co.unitycoders.fracture.engine.PlayerSessionIpl;
import uk.co.unitycoders.fracture.storage.JPAFactory;
import uk.co.unitycoders.fracture.world.*;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by webpigeon on 28/12/13.
 */
public class FractureLauncher {

    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = JPAFactory.buildFactory();
        EntityManager em = emf.createEntityManager();

        WorldModel model = WorldFactory.buildWorldModel(50, 50);

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

        ArtSet art = new ArtSet(itemImg, floorImg, avatarImg);

        Floor floor = new Floor(0);
        Item wrench = new Item(0, true);
        Item wall = new Item(1, false);
        Item wall2 = new Item(2, false);
        Avatar avatar = new Avatar(0);

        for (int j=6; j>=0; j--) {
            model.setItemAt(6, j, wall2);
            model.setItemAt(j, 6, wall);
            model.setItemAt(j, 0, wall);
            model.setItemAt(0, j, wall2);
        }

        for (int i=0; i<50; i++) {
            for (int j=0; j<50; j++) {
                model.setFloorAt(i, j, floor);
            }
        }
        model.setItemAt(7, 7, wrench);
        model.setAvatarAt(3, 3, avatar);

        JFrame frame = SwingFactory.buildFrame();

        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(210, 600));
        frame.add(sidePanel, BorderLayout.WEST);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 125));
        frame.add(bottomPanel, BorderLayout.SOUTH);

        WorldComponent component = new WorldComponent(model, art);
        component.setFocusable(true);
        frame.add(component);

        PlayerSession session = new PlayerSessionIpl(model, avatar);
        PlayerKeyboardController controller = new PlayerKeyboardController(session, component);
        component.addKeyListener(controller);

        frame.pack();
        frame.setVisible(true);
    }
}
