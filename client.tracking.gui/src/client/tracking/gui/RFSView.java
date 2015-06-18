package client.tracking.gui;

import java.util.ArrayList;

import tracking.Itinerary;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class RFSView extends ViewPart {

	public static RFSView instance = null ; // Singleton
    
	private TreeViewer viewer;

	public void createPartControl(Composite parent) {
		instance = this ;
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
	}

	public void update (ArrayList<Itinerary> list) {
		viewer.setInput(list);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
}
