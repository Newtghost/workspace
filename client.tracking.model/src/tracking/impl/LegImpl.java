/**
 */
package tracking.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import tracking.Leg;
import tracking.TrackingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Leg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tracking.impl.LegImpl#getTripId <em>Trip Id</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getAgencyId <em>Agency Id</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getRouteId <em>Route Id</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getFrom <em>From</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getTo <em>To</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getDistance <em>Distance</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getEndTime <em>End Time</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getArrivalDelay <em>Arrival Delay</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getDepartureDelay <em>Departure Delay</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getFromStopSequence <em>From Stop Sequence</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getToStopSequence <em>To Stop Sequence</em>}</li>
 *   <li>{@link tracking.impl.LegImpl#getTimezone <em>Timezone</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LegImpl extends MinimalEObjectImpl.Container implements Leg {
	/**
	 * The default value of the '{@link #getTripId() <em>Trip Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTripId()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTripId() <em>Trip Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTripId()
	 * @generated
	 * @ordered
	 */
	protected String tripId = TRIP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getAgencyId() <em>Agency Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgencyId()
	 * @generated
	 * @ordered
	 */
	protected static final String AGENCY_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAgencyId() <em>Agency Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgencyId()
	 * @generated
	 * @ordered
	 */
	protected String agencyId = AGENCY_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getRouteId() <em>Route Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRouteId()
	 * @generated
	 * @ordered
	 */
	protected static final String ROUTE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRouteId() <em>Route Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRouteId()
	 * @generated
	 * @ordered
	 */
	protected String routeId = ROUTE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrom() <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected String from = FROM_EDEFAULT;

	/**
	 * The default value of the '{@link #getTo() <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected String to = TO_EDEFAULT;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final String MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected String mode = MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDistance() <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistance()
	 * @generated
	 * @ordered
	 */
	protected static final double DISTANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDistance() <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistance()
	 * @generated
	 * @ordered
	 */
	protected double distance = DISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final long START_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected long startTime = START_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected static final long END_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getEndTime() <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndTime()
	 * @generated
	 * @ordered
	 */
	protected long endTime = END_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getArrivalDelay() <em>Arrival Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalDelay()
	 * @generated
	 * @ordered
	 */
	protected static final int ARRIVAL_DELAY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getArrivalDelay() <em>Arrival Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalDelay()
	 * @generated
	 * @ordered
	 */
	protected int arrivalDelay = ARRIVAL_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getDepartureDelay() <em>Departure Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartureDelay()
	 * @generated
	 * @ordered
	 */
	protected static final int DEPARTURE_DELAY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDepartureDelay() <em>Departure Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartureDelay()
	 * @generated
	 * @ordered
	 */
	protected int departureDelay = DEPARTURE_DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromStopSequence() <em>From Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromStopSequence()
	 * @generated
	 * @ordered
	 */
	protected static final int FROM_STOP_SEQUENCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFromStopSequence() <em>From Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromStopSequence()
	 * @generated
	 * @ordered
	 */
	protected int fromStopSequence = FROM_STOP_SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getToStopSequence() <em>To Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToStopSequence()
	 * @generated
	 * @ordered
	 */
	protected static final int TO_STOP_SEQUENCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getToStopSequence() <em>To Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToStopSequence()
	 * @generated
	 * @ordered
	 */
	protected int toStopSequence = TO_STOP_SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimezone() <em>Timezone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimezone()
	 * @generated
	 * @ordered
	 */
	protected static final String TIMEZONE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimezone() <em>Timezone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimezone()
	 * @generated
	 * @ordered
	 */
	protected String timezone = TIMEZONE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LegImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TrackingPackage.Literals.LEG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTripId() {
		return tripId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTripId(String newTripId) {
		String oldTripId = tripId;
		tripId = newTripId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__TRIP_ID, oldTripId, tripId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAgencyId() {
		return agencyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgencyId(String newAgencyId) {
		String oldAgencyId = agencyId;
		agencyId = newAgencyId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__AGENCY_ID, oldAgencyId, agencyId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRouteId() {
		return routeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRouteId(String newRouteId) {
		String oldRouteId = routeId;
		routeId = newRouteId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__ROUTE_ID, oldRouteId, routeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(String newFrom) {
		String oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(String newTo) {
		String oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(String newMode) {
		String oldMode = mode;
		mode = newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistance(double newDistance) {
		double oldDistance = distance;
		distance = newDistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__DISTANCE, oldDistance, distance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(long newStartTime) {
		long oldStartTime = startTime;
		startTime = newStartTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__START_TIME, oldStartTime, startTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndTime(long newEndTime) {
		long oldEndTime = endTime;
		endTime = newEndTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__END_TIME, oldEndTime, endTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getArrivalDelay() {
		return arrivalDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrivalDelay(int newArrivalDelay) {
		int oldArrivalDelay = arrivalDelay;
		arrivalDelay = newArrivalDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__ARRIVAL_DELAY, oldArrivalDelay, arrivalDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDepartureDelay() {
		return departureDelay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartureDelay(int newDepartureDelay) {
		int oldDepartureDelay = departureDelay;
		departureDelay = newDepartureDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__DEPARTURE_DELAY, oldDepartureDelay, departureDelay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFromStopSequence() {
		return fromStopSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromStopSequence(int newFromStopSequence) {
		int oldFromStopSequence = fromStopSequence;
		fromStopSequence = newFromStopSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__FROM_STOP_SEQUENCE, oldFromStopSequence, fromStopSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getToStopSequence() {
		return toStopSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToStopSequence(int newToStopSequence) {
		int oldToStopSequence = toStopSequence;
		toStopSequence = newToStopSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__TO_STOP_SEQUENCE, oldToStopSequence, toStopSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimezone(String newTimezone) {
		String oldTimezone = timezone;
		timezone = newTimezone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrackingPackage.LEG__TIMEZONE, oldTimezone, timezone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TrackingPackage.LEG__TRIP_ID:
				return getTripId();
			case TrackingPackage.LEG__AGENCY_ID:
				return getAgencyId();
			case TrackingPackage.LEG__ROUTE_ID:
				return getRouteId();
			case TrackingPackage.LEG__FROM:
				return getFrom();
			case TrackingPackage.LEG__TO:
				return getTo();
			case TrackingPackage.LEG__MODE:
				return getMode();
			case TrackingPackage.LEG__DISTANCE:
				return getDistance();
			case TrackingPackage.LEG__START_TIME:
				return getStartTime();
			case TrackingPackage.LEG__END_TIME:
				return getEndTime();
			case TrackingPackage.LEG__ARRIVAL_DELAY:
				return getArrivalDelay();
			case TrackingPackage.LEG__DEPARTURE_DELAY:
				return getDepartureDelay();
			case TrackingPackage.LEG__FROM_STOP_SEQUENCE:
				return getFromStopSequence();
			case TrackingPackage.LEG__TO_STOP_SEQUENCE:
				return getToStopSequence();
			case TrackingPackage.LEG__TIMEZONE:
				return getTimezone();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TrackingPackage.LEG__TRIP_ID:
				setTripId((String)newValue);
				return;
			case TrackingPackage.LEG__AGENCY_ID:
				setAgencyId((String)newValue);
				return;
			case TrackingPackage.LEG__ROUTE_ID:
				setRouteId((String)newValue);
				return;
			case TrackingPackage.LEG__FROM:
				setFrom((String)newValue);
				return;
			case TrackingPackage.LEG__TO:
				setTo((String)newValue);
				return;
			case TrackingPackage.LEG__MODE:
				setMode((String)newValue);
				return;
			case TrackingPackage.LEG__DISTANCE:
				setDistance((Double)newValue);
				return;
			case TrackingPackage.LEG__START_TIME:
				setStartTime((Long)newValue);
				return;
			case TrackingPackage.LEG__END_TIME:
				setEndTime((Long)newValue);
				return;
			case TrackingPackage.LEG__ARRIVAL_DELAY:
				setArrivalDelay((Integer)newValue);
				return;
			case TrackingPackage.LEG__DEPARTURE_DELAY:
				setDepartureDelay((Integer)newValue);
				return;
			case TrackingPackage.LEG__FROM_STOP_SEQUENCE:
				setFromStopSequence((Integer)newValue);
				return;
			case TrackingPackage.LEG__TO_STOP_SEQUENCE:
				setToStopSequence((Integer)newValue);
				return;
			case TrackingPackage.LEG__TIMEZONE:
				setTimezone((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TrackingPackage.LEG__TRIP_ID:
				setTripId(TRIP_ID_EDEFAULT);
				return;
			case TrackingPackage.LEG__AGENCY_ID:
				setAgencyId(AGENCY_ID_EDEFAULT);
				return;
			case TrackingPackage.LEG__ROUTE_ID:
				setRouteId(ROUTE_ID_EDEFAULT);
				return;
			case TrackingPackage.LEG__FROM:
				setFrom(FROM_EDEFAULT);
				return;
			case TrackingPackage.LEG__TO:
				setTo(TO_EDEFAULT);
				return;
			case TrackingPackage.LEG__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case TrackingPackage.LEG__DISTANCE:
				setDistance(DISTANCE_EDEFAULT);
				return;
			case TrackingPackage.LEG__START_TIME:
				setStartTime(START_TIME_EDEFAULT);
				return;
			case TrackingPackage.LEG__END_TIME:
				setEndTime(END_TIME_EDEFAULT);
				return;
			case TrackingPackage.LEG__ARRIVAL_DELAY:
				setArrivalDelay(ARRIVAL_DELAY_EDEFAULT);
				return;
			case TrackingPackage.LEG__DEPARTURE_DELAY:
				setDepartureDelay(DEPARTURE_DELAY_EDEFAULT);
				return;
			case TrackingPackage.LEG__FROM_STOP_SEQUENCE:
				setFromStopSequence(FROM_STOP_SEQUENCE_EDEFAULT);
				return;
			case TrackingPackage.LEG__TO_STOP_SEQUENCE:
				setToStopSequence(TO_STOP_SEQUENCE_EDEFAULT);
				return;
			case TrackingPackage.LEG__TIMEZONE:
				setTimezone(TIMEZONE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TrackingPackage.LEG__TRIP_ID:
				return TRIP_ID_EDEFAULT == null ? tripId != null : !TRIP_ID_EDEFAULT.equals(tripId);
			case TrackingPackage.LEG__AGENCY_ID:
				return AGENCY_ID_EDEFAULT == null ? agencyId != null : !AGENCY_ID_EDEFAULT.equals(agencyId);
			case TrackingPackage.LEG__ROUTE_ID:
				return ROUTE_ID_EDEFAULT == null ? routeId != null : !ROUTE_ID_EDEFAULT.equals(routeId);
			case TrackingPackage.LEG__FROM:
				return FROM_EDEFAULT == null ? from != null : !FROM_EDEFAULT.equals(from);
			case TrackingPackage.LEG__TO:
				return TO_EDEFAULT == null ? to != null : !TO_EDEFAULT.equals(to);
			case TrackingPackage.LEG__MODE:
				return MODE_EDEFAULT == null ? mode != null : !MODE_EDEFAULT.equals(mode);
			case TrackingPackage.LEG__DISTANCE:
				return distance != DISTANCE_EDEFAULT;
			case TrackingPackage.LEG__START_TIME:
				return startTime != START_TIME_EDEFAULT;
			case TrackingPackage.LEG__END_TIME:
				return endTime != END_TIME_EDEFAULT;
			case TrackingPackage.LEG__ARRIVAL_DELAY:
				return arrivalDelay != ARRIVAL_DELAY_EDEFAULT;
			case TrackingPackage.LEG__DEPARTURE_DELAY:
				return departureDelay != DEPARTURE_DELAY_EDEFAULT;
			case TrackingPackage.LEG__FROM_STOP_SEQUENCE:
				return fromStopSequence != FROM_STOP_SEQUENCE_EDEFAULT;
			case TrackingPackage.LEG__TO_STOP_SEQUENCE:
				return toStopSequence != TO_STOP_SEQUENCE_EDEFAULT;
			case TrackingPackage.LEG__TIMEZONE:
				return TIMEZONE_EDEFAULT == null ? timezone != null : !TIMEZONE_EDEFAULT.equals(timezone);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (tripId: ");
		result.append(tripId);
		result.append(", agencyId: ");
		result.append(agencyId);
		result.append(", routeId: ");
		result.append(routeId);
		result.append(", from: ");
		result.append(from);
		result.append(", to: ");
		result.append(to);
		result.append(", mode: ");
		result.append(mode);
		result.append(", distance: ");
		result.append(distance);
		result.append(", startTime: ");
		result.append(startTime);
		result.append(", endTime: ");
		result.append(endTime);
		result.append(", arrivalDelay: ");
		result.append(arrivalDelay);
		result.append(", departureDelay: ");
		result.append(departureDelay);
		result.append(", fromStopSequence: ");
		result.append(fromStopSequence);
		result.append(", toStopSequence: ");
		result.append(toStopSequence);
		result.append(", timezone: ");
		result.append(timezone);
		result.append(')');
		return result.toString();
	}

} //LegImpl
