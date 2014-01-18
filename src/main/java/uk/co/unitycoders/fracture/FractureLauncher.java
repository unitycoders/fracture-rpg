package uk.co.unitycoders.fracture;

import uk.co.unitycoders.fracture.engine.PlayerSession;
import uk.co.unitycoders.fracture.engine.PlayerSessionIpl;
import uk.co.unitycoders.fracture.engine.TaskManager;
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

        TaskManager manager = new TaskManager(emf);
        WorldModel model = WorldFactory.buildWorldModel(50, 50);

        ArtSet art = SwingFactory.buildDemoArt();
        TypeRegistry registry = WorldFactory.buildRegistry();

        Avatar avatar = new Avatar(0);

        for (int j=6; j>=0; j--) {
            model.setItemAt(6, j, registry.getItem(2));
            model.setItemAt(j, 6, registry.getItem(1));
            model.setItemAt(j, 0, registry.getItem(1));
            model.setItemAt(0, j, registry.getItem(2));
        }

        for (int i=0; i<50; i++) {
            for (int j=0; j<50; j++) {
                model.setFloorAt(i, j, registry.getFloor(0));
            }
        }

        model.setItemAt(3, 6, null);
        model.setItemAt(7, 7, registry.getItem(0));
        model.setAvatarAt(3, 3, avatar);

        JFrame frame = SwingFactory.buildFrame();
        frame.add(SwingFactory.buildSidePanel(), BorderLayout.WEST);
        frame.add(SwingFactory.buildBottomPanel(), BorderLayout.SOUTH);

        JComponent component = SwingFactory.buildView(model, art);
        component.setFocusable(true);
        frame.add(component);

        PlayerSession session = new PlayerSessionIpl(manager, model, avatar);
        PlayerKeyboardController controller = new PlayerKeyboardController(session, component);
        component.addKeyListener(controller);

        frame.pack();
        frame.setVisible(true);
    }
}
