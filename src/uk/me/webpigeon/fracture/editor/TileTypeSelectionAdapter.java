package uk.me.webpigeon.fracture.editor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TileTypeSelectionAdapter extends MouseAdapter {
	private final TypeSelectorModel model;
	private final TileTypeChooser view;

	public TileTypeSelectionAdapter(TypeSelectorModel model,
			TileTypeChooser view) {
		this.model = model;
		this.view = view;
		model.addSelectionListener(view);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int id = view.getTypeAtPoint(e.getPoint());
		model.setSelected(id);
	}

}
