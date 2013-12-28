package uk.co.unitycoders.fracture;

import uk.co.unitycoders.fracture.engine.PlayerSession;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by webpigeon on 28/12/13.
 */
public class PlayerKeyboardController extends KeyAdapter {
    private static final long KEY_COOLDOWN = 100;
    private long lastPress;
    private JComponent component;
    private PlayerSession session;

    public PlayerKeyboardController(PlayerSession session, JComponent component) {
        this.session = session;
        this.component = component;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        long now = System.currentTimeMillis();
        if (now > (lastPress + KEY_COOLDOWN) ) {
            lastPress = now;
        }

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                session.moveNorth();
                break;

            case KeyEvent.VK_S:
                session.moveSouth();
                break;

            case KeyEvent.VK_A:
                session.moveWest();
                break;

            case KeyEvent.VK_D:
                session.moveEast();
                break;

            case KeyEvent.VK_Q:
                session.pickUp();
                break;
        }

        component.repaint();
    }
}
