package uk.me.webpigeon.fracture.editor;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import uk.me.webpigeon.fracture.game.AreaManager;

public class Save2Action implements Action, Runnable {
	private final AreaManager manager;

	public Save2Action(AreaManager manager) {
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
			return "Save";

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
				"Testing Fracture Area Template", "fat");
		chooser.setFileFilter(filter);

		int returnVal = chooser.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to save this file: "
					+ chooser.getSelectedFile().getName());

			File selected = chooser.getSelectedFile();
			if (!selected.getName().endsWith(".tfat")) {
				selected = new File(selected.getPath() + ".tfat");
			}

			try {
				FileOutputStream fos = new FileOutputStream(selected);
				ObjectOutputStream ios = new ObjectOutputStream(fos);
				FileOperations.writeArea(ios, manager.getCurrentArea());

				ios.close();
				fos.close();
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
		}

	}

}
