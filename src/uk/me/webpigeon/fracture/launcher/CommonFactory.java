package uk.me.webpigeon.fracture.launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class CommonFactory {

	public static void buildFrame(String name, JComponent comp) {
		JFrame frame = new JFrame(name);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(comp, BorderLayout.CENTER);

		frame.setVisible(true);
		frame.pack();
	}

	public static BufferedImage loadImage(String imgPath) throws IOException {
		ClassLoader loader = CommonFactory.class.getClassLoader();
		URL url = loader.getResource(imgPath);

		File loadMe = new File(imgPath);
		return ImageIO.read(loadMe);
	}

	public static BufferedImage[] cutImage(BufferedImage img, int w, int h) {

		int cols = img.getWidth() / w;
		int rows = img.getHeight() / h;

		BufferedImage[] tiles = new BufferedImage[cols * rows];
		for (int x = 0; x < cols; x++) {
			for (int y = 0; y < rows; y++) {
				tiles[x + y * cols] = img.getSubimage(x * w, y * h, w, h);
			}
		}

		return tiles;
	}
}
