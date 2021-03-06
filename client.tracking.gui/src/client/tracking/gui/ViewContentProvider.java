package client.tracking.gui;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import routing.Itinerary;
import routing.Leg;

public class ViewContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object inputElement) {
		return ((ArrayList<Itinerary>) inputElement).toArray();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Itinerary) {
			return ((Itinerary) parentElement).getPath().toArray();
		} else if (parentElement instanceof Leg) {
			return ((Leg) parentElement).eContents().toArray();
		}
		return null ;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof Itinerary) return true;
		return false;
	}

}