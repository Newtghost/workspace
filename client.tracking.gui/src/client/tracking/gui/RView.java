package client.tracking.gui;

import common.CommonFactory;
import common.Request;
import common.util.DateUtils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class RView extends ViewPart {

	public static RView instance = null ; // Singleton	
	
	public Text time ;
	public Text date ;
	public Text latTo ;
	public Text lonTo ;
	public Text stopTo ;
	public Text latFrom ;
	public Text lonFrom ;
	public Text stopFrom ;
	public Text maxWalkDistance ;
	
	public RView() {

	}

	public void createPartControl(Composite parent) {

		instance = this ;

		/* Initialization of the viewer */
		GridLayout layout = new GridLayout(4, true) ;
		parent.setLayout(layout);
		
		Label timeLabel = new Label(parent, SWT.NONE);
		timeLabel.setText("Time : ");
		time = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.horizontalSpan = 3;
		time.setLayoutData(gridData);
		time.setText("1:20pm") ;
		
		Label dateLabel = new Label(parent, SWT.NONE);
		dateLabel.setText("Date : ");
		date = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.horizontalSpan = 3;
		date.setLayoutData(gridData);
		date.setText("07-01-2015") ;

		Label fromLabel = new Label(parent, SWT.NONE);
		fromLabel.setText("Lat / Lon (stop ID) - FROM place : ");

		latFrom = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		latFrom.setLayoutData(gridData);
		latFrom.setText("45.491215") ;

		lonFrom = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		lonFrom.setLayoutData(gridData);
		lonFrom.setText("-122.651461") ;

		stopFrom = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		stopFrom.setLayoutData(gridData);
		stopFrom.setText("3932") ;
		Label toLabel = new Label(parent, SWT.NONE);
		toLabel.setText("Lat / Lon (stop ID) - TO place : ");

		latTo = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		latTo.setLayoutData(gridData);
		latTo.setText("45.533555") ;

		lonTo = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		lonTo.setLayoutData(gridData);
		lonTo.setText("-122.5011") ;

		stopTo = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		stopTo.setLayoutData(gridData);
		stopTo.setText("2391") ;

		Label maxWDLabel = new Label(parent, SWT.NONE);
		maxWDLabel.setText("Max Walk Distance : ");
		maxWalkDistance = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.horizontalSpan = 3;
		maxWalkDistance.setLayoutData(gridData);
		maxWalkDistance.setText("1000") ;

	}
	
	public Request getRequest() {
		Request r = CommonFactory.eINSTANCE.createRequest() ;
		r.setTime(getTime());
		r.setDate(getDate()); 
		r.setToLat(getLatTo());
		r.setToLon(getLonTo());
		r.setToStopId(getStopTo());
		r.setFromLat(getLatFrom());
		r.setFromLon(getLonFrom());
		r.setFromStopId(getStopFrom());
		r.setMaxWalkDistance(getMaxWalkDistance()) ;
		return r ;
	}
	
	public String getTime() {
		return time.getText();
	}

	public String getDate() {
		return date.getText();
	}

	public long getStartTime() {
		return DateUtils.parseTimeD(time.getText());
	}

	public double getLatTo() {
		return Double.parseDouble(latTo.getText());
	}

	public double getLonTo() {
		return Double.parseDouble(lonTo.getText());
	}

	public String getStopTo() {
		return stopTo.getText();
	}

	public double getLatFrom() {
		return Double.parseDouble(latFrom.getText());
	}

	public double getLonFrom() {
		return Double.parseDouble(lonFrom.getText());
	}

	public String getStopFrom() {
		return stopFrom.getText();
	}

	public int getMaxWalkDistance() {
		return Integer.parseInt(maxWalkDistance.getText());
	}

	@Override
	public void setFocus() {

	}

}
