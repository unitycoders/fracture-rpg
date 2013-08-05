package uk.me.webpigeon.fracture.editor;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import uk.me.webpigeon.fracture.game.Area;
import uk.me.webpigeon.fracture.game.AreaManager;

public class NewAction implements Action {
	private final AreaManager manager;

	public NewAction(AreaManager manager) {
		this.manager = manager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object[] possibleValues = { new Dimension(20, 20),
				new Dimension(20, 40), new Dimension(40, 40),
				new Dimension(60, 60) };
		Object selectedValue = JOptionPane.showInputDialog(
				(Component) e.getSource(),

				"Choose one", "Input",

				JOptionPane.INFORMATION_MESSAGE, null,

				possibleValues, possibleValues[0]);

		if (selectedValue != null) {
			Dimension size = (Dimension) selectedValue;

			Area area = new Area(size.width, size.height);
			manager.setCurrentArea(area);
		}
	}

	@Override
	public Object getValue(String key) {
		switch (key) {

		case Action.NAME:
			return "New";

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

}
