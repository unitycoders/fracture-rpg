package uk.co.unitycoders.fracture;

import uk.co.unitycoders.fracture.engine.PlayerSession;
import uk.co.unitycoders.fracture.engine.PlayerSessionIpl;
import uk.co.unitycoders.fracture.world.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by webpigeon on 28/12/13.
 */
public class FractureLauncher {

    public static void main(String[] args) throws IOException {
        WorldModel model = WorldFactory.buildWorldModel(50, 50);

        ClassLoader loader = FractureLauncher.class.getClassLoader();
        Floor floor = new Floor(ImageIO.read(loader.getResourceAsStream("floor.png")));
        Item wrench = new Item(ImageIO.read(loader.getResourceAsStream("wrench.png")));
        Item wall = new Item(ImageIO.read(loader.getResourceAsStream("wall.png")));
        Avatar avatar = new Avatar(ImageIO.read(loader.getResourceAsStream("avatar.png")));


        for (int i=0; i<50; i++) {
            model.setItemAt(i,5,wall);
            for (int j=0; j<50; j++) {
                model.setFloorAt(i, j, floor);
            }
        }
        model.setItemAt(5, 6, wrench);
        model.setAvatarAt(5, 5, avatar);

        JFrame frame = SwingFactory.buildFrame();

        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(210, 600));
        frame.add(sidePanel, BorderLayout.WEST);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 125));
        frame.add(bottomPanel, BorderLayout.SOUTH);

        WorldComponent component = new WorldComponent(model);
        component.setFocusable(true);
        frame.add(component);

        PlayerSession session = new PlayerSessionIpl(model, avatar);
        PlayerKeyboardController controller = new PlayerKeyboardController(session, component);
        component.addKeyListener(controller);

        frame.pack();
        frame.setVisible(true);
    }
}
