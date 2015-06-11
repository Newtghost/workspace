package gtfsrt.provider.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class Addview extends ViewPart {

	public Addview() {

	}

	@Override
	public void createPartControl(Composite parent) {

		FillLayout layout = new FillLayout() ;
		layout.type = SWT.VERTICAL ;
		parent.setLayout(layout);
		
		final Text tripId = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		tripId.setText("Trip Id ...");

		final Text nbSeq = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		nbSeq.setText("Number of sequences ...");

		final Text delay = new Text(parent, SWT.SINGLE | SWT.BORDER) ;
		delay.setText("Delay ...");

		Button add = new Button(parent, SWT.PUSH) ;
		add.setText("Add");
		add.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent e) {
				Trip trip = new Trip(tripId.getText(), Integer.parseInt(nbSeq.getText()), Integer.parseInt(delay.getText())) ;
				View.instance.getTrips_to_update().add(trip) ;
				View.instance.update();
			}
		});
	}

	@Override
	public void setFocus() {

	}

}
