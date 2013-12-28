package uk.co.unitycoders.fracture;

import javax.swing.*;
import java.awt.*;

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

}
