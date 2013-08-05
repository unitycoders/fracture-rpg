package uk.me.webpigeon.fracture.editor;

import java.awt.event.MouseAdapter;

import javax.swing.JComponent;
import javax.swing.JToolBar;
import javax.swing.JViewport;

import uk.me.webpigeon.fracture.game.AreaComponent;
import uk.me.webpigeon.fracture.game.AreaManager;
import uk.me.webpigeon.fracture.game.AreaMouseScroller;
import uk.me.webpigeon.fracture.game.TileSet;

public class EditorFactory {

	public static TypeSelectorModel buildSelectorModel(TileSet set) {
		return new TypeSelectorModel(set);
	}

	public static JComponent buildSelector(TypeSelectorModel model, TileSet set) {
		TileTypeChooser selector = new TileTypeChooser(set, model);
		selector.addMouseListener(new TileTypeSelectionAdapter(model, selector));

		return selector;
	}

	public static JToolBar buildToolbar(AreaManager manager) {
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);

		toolbar.add(new NewAction(manager));
		toolbar.addSeparator();
		toolbar.add(new LoadAction(manager));
		toolbar.add(new Save2Action(manager));

		return toolbar;
	}

	/**
	 * Build an AreaComponent which allows in place editing of the area.
	 * 
	 * @return an editable area component
	 */
	public static AreaComponent buildAreaComponent(AreaManager manager,
			JViewport viewport) {
		AreaComponent areaComponent = new AreaComponent(manager);

		MouseAdapter aptr = new AreaMouseScroller(viewport);
		areaComponent.addMouseMotionListener(aptr);
		areaComponent.addMouseListener(aptr);

		viewport.setView(areaComponent);

		return areaComponent;
	}

	public static JComponent makeEditable(AreaComponent comp, TileSet set,
			AreaManager manager) {

		// build the selector component and model
		TypeSelectorModel selectorModel = EditorFactory.buildSelectorModel(set);
		JComponent selector = EditorFactory.buildSelector(selectorModel, set);

		// enable click and edit on the view
		MouseAdapter editor = new TilePainter(selectorModel, manager);
		comp.addMouseListener(editor);
		comp.addMouseMotionListener(editor);

		return selector;
	}

}
