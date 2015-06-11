package client.tracking.gui;

import java.util.Date;

import tracking.Itinerary;
import tracking.Leg;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;


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
			Date dep, arr ;
			String dep2s, arr2s ;
			
			/* TODO : propager la timezone via la request */
			long tz = 9 * 3600 ; // OTP 
			
			if (le.getMode().equals("WALK")) {
				dep = new Date((le.getStartTime() - tz + le.getDepartureDelay()) * 1000);
				arr = new Date((le.getEndTime() - tz + le.getArrivalDelay()) * 1000);
				dep2s = dep.toString() ; arr2s = arr.toString() ; 
				cell.setText(dep2s + " - FROM " + le.getFrom() + " TO " + le.getTo() + " by WALK - " + arr2s);
			} else {
				dep = new Date((le.getStartTime() - tz) * 1000);
				arr = new Date((le.getEndTime() - tz) * 1000);
				dep2s = dep.toString() ; arr2s = arr.toString() ; 
				if (le.getDepartureDelay() > 0) 
					dep2s +=  " (delayed of " + le.getDepartureDelay() + ")" ;
				if (le.getArrivalDelay() > 0) 
					arr2s +=  " (delayed of " + le.getArrivalDelay() + ")" ;
				cell.setText(dep2s + " - FROM " + le.getFrom() + " TO " + le.getTo() + " by " + le.getRouteId() + ", " + le.getTripId() + " - " + arr2s);
			}
		} else {
			cell.setText(element.toString());
		}
		super.update(cell);
	}

}


