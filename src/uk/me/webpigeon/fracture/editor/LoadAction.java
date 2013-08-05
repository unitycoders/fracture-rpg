package uk.me.webpigeon.fracture.editor;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import uk.me.webpigeon.fracture.game.Area;
import uk.me.webpigeon.fracture.game.AreaManager;

public class LoadAction implements Action, Runnable {
	private final AreaManager manager;

	public LoadAction(AreaManager manager) {
		this.manager = manager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		run();
	}

	@Override
	public Object getValue(String key) {
		switch (key) {

		case Action.NAME:
			return "Open";

		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Testing Fracture Area Template", "tfat");
		chooser.setFileFilter(filter);

		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: "
					+ chooser.getSelectedFile().getName());

			try {
				FileInputStream fos = new FileInputStream(
						chooser.getSelectedFile());
				ObjectInputStream ios = new ObjectInputStream(fos);

				Area loaded = FileOperations.buildArea(ios,
						manager.getTileset());
				manager.setCurrentArea(loaded);

				ios.close();
				fos.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}

	}

}
