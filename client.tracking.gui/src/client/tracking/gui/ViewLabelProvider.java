package client.tracking.gui;

import java.util.Date;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;

import common.util.DateUtils;

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
			Date dep, arr ;
			String dep2s, arr2s ;
			
			long tz = Main.JET_LAG ;
			
			if (le instanceof Footpath) {
				Footpath f = (Footpath) le ;
				cell.setText("Walking for " + f.getDuration() + "s on " + ((int) f.getDistance()) + "m from " + f.getDepartureId() + " to " + f.getArrivalId());
			} else {
				Connection c = (Connection) le ;
				dep = new Date((c.getDepartureTime() - tz) * 1000);
				arr = new Date((c.getArrivalTime() - tz) * 1000);
				dep2s = DateUtils.hour2String(dep) ;
				arr2s = DateUtils.hour2String(arr) ;
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


