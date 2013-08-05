package uk.me.webpigeon.fracture.editor;

import java.util.ArrayList;
import java.util.List;

import uk.me.webpigeon.fracture.game.TileSet;
import uk.me.webpigeon.fracture.game.TileType;

public class TypeSelectorModel {
	private Integer selected;
	private final TileSet set;
	private final List<SelectionListener> listeners;

	public TypeSelectorModel(TileSet set) {
		this.set = set;
		this.listeners = new ArrayList<>();
	}

	public void setSelected(Integer id) {
		if (id < set.getSize()) {
			this.selected = id;
		} else {
			selected = null;
		}
		fireSelectionChanged();
	}

	public Integer getSelected() {
		return selected;
	}

	public boolean isSelected() {
		return selected == null;
	}

	public void clearSelection() {
		selected = null;
	}

	public int getSize() {
		return set.getSize();
	}

	public void addSelectionListener(SelectionListener listener) {
		listeners.add(listener);
	}

	public void removeSelectionLisener(SelectionListener listener) {
		listeners.remove(listener);
	}

	protected void fireSelectionChanged() {
		for (SelectionListener listener : listeners) {
			listener.onSelectionChanged();
		}
	}

	public TileType getSelectedType() {
		if (selected != null) {
			return set.getType(selected);
		} else {
			return null;
		}
	}

}
