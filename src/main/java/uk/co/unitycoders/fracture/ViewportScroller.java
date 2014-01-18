package uk.co.unitycoders.fracture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by webpigeon on 18/01/14.
 */
//TODO integrate with game's event listener system
public class ViewportScroller implements KeyListener {
    private JViewport viewport;
    private static final long KEY_COOLDOWN = 100;
    private long lastPress;

    public ViewportScroller(JViewport viewport) {
        this.viewport = viewport;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        long now = System.currentTimeMillis();
        if (now > (lastPress + KEY_COOLDOWN) ) {
            lastPress = now;
        }

        Point currentOffset = viewport.getViewPosition();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_KP_UP:
                currentOffset.y -= 32;
                break;

            case KeyEvent.VK_KP_DOWN:
                currentOffset.y += 32;
                break;

            case KeyEvent.VK_KP_LEFT:
                currentOffset.x -= 32;
                break;

            case KeyEvent.VK_KP_RIGHT:
                currentOffset.x += 32;
                break;
        }

        //Don't let the offsets be less than zero
        currentOffset.x = Math.max(0, currentOffset.x);
        currentOffset.y = Math.max(0, currentOffset.y);

        viewport.setViewPosition(currentOffset);
        viewport.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
