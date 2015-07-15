package client.tracking.gui;

import java.time.Instant;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;

import routing.Connection;
import routing.Footpath;
import routing.Itinerary;
import routing.Leg;


public class ViewLabelProvider extends StyledCellLabelProvider {

	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();
		if (element instanceof Itinerary) {
			Itinerary it = (Itinerary) element;
			if (it.isDeprecated()) {
				cell.setText("(Dep) Itinerary");
			} else {
				cell.setText("Itinerary");
			}
		} else if (element instanceof Leg) {
			Leg le = (Leg) element;
			Instant dep, arr ;
			String dep2s, arr2s ;
			
			long tzOffset = le.getAgencyTimeZoneOffset() / 1000 ;  // in seconds
			
			if (le instanceof Footpath) {
				Footpath f = (Footpath) le ;
				cell.setText("Walking for " + f.getDuration() + "s on " + ((int) f.getDistance()) + "m from " + f.getDepartureId() + " to " + f.getArrivalId());
			} else {
				Connection c = (Connection) le ;
				dep = Instant.ofEpochSecond(c.getDepartureTime() + tzOffset) ;
				arr = Instant.ofEpochSecond(c.getArrivalTime() + tzOffset) ;
				dep2s = dep.toString().substring(11, 19) ; /* We just extract the date of this complete format */
				arr2s = arr.toString().substring(11, 19) ; /* We just extract the date of this complete format */
				if (c.getDepartureDelay() > 0) 
					dep2s +=  " delayed of " + c.getDepartureDelay() + "s" ;
				if (c.getArrivalDelay() > 0) 
					arr2s +=  " delayed of " + c.getArrivalDelay() + "s" ;
				cell.setText("Transit with route " + c.getRouteId() + " (" + c.getTripId() + ") from "+ c.getDepartureId() + " (" + dep2s + ") to " + c.getArrivalId() + " (" + arr2s + ")");
			}
		} else {
			cell.setText(element.toString());
		}
		super.update(cell);
	}

}


