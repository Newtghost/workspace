package client.tracking.gui;

import java.util.ArrayList;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import routing.Itinerary;

public class OTPView extends ViewPart {

	public static OTPView instance = null ; // Singleton

	private TreeViewer viewer;

	@Override
	public void createPartControl(Composite parent) {
		instance = this ;
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());

		Main.startRefresh();
	}

	public void update (ArrayList<Itinerary> list) {
		viewer.setInput(list);
	}

	@Override
	public void setFocus() {
	}

}
