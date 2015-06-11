/**
 */
package common.impl;

import common.CommonPackage;
import common.Request;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link common.impl.RequestImpl#getTime <em>Time</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getDate <em>Date</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getFromStopId <em>From Stop Id</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getToStopId <em>To Stop Id</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getFromLat <em>From Lat</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getFromLon <em>From Lon</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getToLat <em>To Lat</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getToLon <em>To Lon</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getMaxWalkDistance <em>Max Walk Distance</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getTimezone <em>Timezone</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequestImpl extends MinimalEObjectImpl.Container implements Request {
	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final String TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected String time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected String date = DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromStopId() <em>From Stop Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromStopId()
	 * @generated
	 * @ordered
	 */
	protected static final String FROM_STOP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFromStopId() <em>From Stop Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromStopId()
	 * @generated
	 * @ordered
	 */
	protected String fromStopId = FROM_STOP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getToStopId() <em>To Stop Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToStopId()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_STOP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToStopId() <em>To Stop Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToStopId()
	 * @generated
	 * @ordered
	 */
	protected String toStopId = TO_STOP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromLat() <em>From Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromLat()
	 * @generated
	 * @ordered
	 */
	protected static final double FROM_LAT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFromLat() <em>From Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromLat()
	 * @generated
	 * @ordered
	 */
	protected double fromLat = FROM_LAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFromLon() <em>From Lon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromLon()
	 * @generated
	 * @ordered
	 */
	protected static final double FROM_LON_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFromLon() <em>From Lon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromLon()
	 * @generated
	 * @ordered
	 */
	protected double fromLon = FROM_LON_EDEFAULT;

	/**
	 * The default value of the '{@link #getToLat() <em>To Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToLat()
	 * @generated
	 * @ordered
	 */
	protected static final double TO_LAT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getToLat() <em>To Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToLat()
	 * @generated
	 * @ordered
	 */
	protected double toLat = TO_LAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getToLon() <em>To Lon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToLon()
	 * @generated
	 * @ordered
	 */
	protected static final double TO_LON_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getToLon() <em>To Lon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToLon()
	 * @generated
	 * @ordered
	 */
	protected double toLon = TO_LON_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxWalkDistance() <em>Max Walk Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxWalkDistance()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_WALK_DISTANCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxWalkDistance() <em>Max Walk Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxWalkDistance()
	 * @generated
	 * @ordered
	 */
	protected int maxWalkDistance = MAX_WALK_DISTANCE_EDEFAULT;

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
	protected RequestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.REQUEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(String newTime) {
		String oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(String newDate) {
		String oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFromStopId() {
		return fromStopId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromStopId(String newFromStopId) {
		String oldFromStopId = fromStopId;
		fromStopId = newFromStopId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__FROM_STOP_ID, oldFromStopId, fromStopId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToStopId() {
		return toStopId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToStopId(String newToStopId) {
		String oldToStopId = toStopId;
		toStopId = newToStopId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__TO_STOP_ID, oldToStopId, toStopId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFromLat() {
		return fromLat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromLat(double newFromLat) {
		double oldFromLat = fromLat;
		fromLat = newFromLat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__FROM_LAT, oldFromLat, fromLat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFromLon() {
		return fromLon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromLon(double newFromLon) {
		double oldFromLon = fromLon;
		fromLon = newFromLon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__FROM_LON, oldFromLon, fromLon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getToLat() {
		return toLat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToLat(double newToLat) {
		double oldToLat = toLat;
		toLat = newToLat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__TO_LAT, oldToLat, toLat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getToLon() {
		return toLon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToLon(double newToLon) {
		double oldToLon = toLon;
		toLon = newToLon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__TO_LON, oldToLon, toLon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxWalkDistance() {
		return maxWalkDistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxWalkDistance(int newMaxWalkDistance) {
		int oldMaxWalkDistance = maxWalkDistance;
		maxWalkDistance = newMaxWalkDistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__MAX_WALK_DISTANCE, oldMaxWalkDistance, maxWalkDistance));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__TIMEZONE, oldTimezone, timezone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.REQUEST__TIME:
				return getTime();
			case CommonPackage.REQUEST__DATE:
				return getDate();
			case CommonPackage.REQUEST__FROM_STOP_ID:
				return getFromStopId();
			case CommonPackage.REQUEST__TO_STOP_ID:
				return getToStopId();
			case CommonPackage.REQUEST__FROM_LAT:
				return getFromLat();
			case CommonPackage.REQUEST__FROM_LON:
				return getFromLon();
			case CommonPackage.REQUEST__TO_LAT:
				return getToLat();
			case CommonPackage.REQUEST__TO_LON:
				return getToLon();
			case CommonPackage.REQUEST__MAX_WALK_DISTANCE:
				return getMaxWalkDistance();
			case CommonPackage.REQUEST__TIMEZONE:
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
			case CommonPackage.REQUEST__TIME:
				setTime((String)newValue);
				return;
			case CommonPackage.REQUEST__DATE:
				setDate((String)newValue);
				return;
			case CommonPackage.REQUEST__FROM_STOP_ID:
				setFromStopId((String)newValue);
				return;
			case CommonPackage.REQUEST__TO_STOP_ID:
				setToStopId((String)newValue);
				return;
			case CommonPackage.REQUEST__FROM_LAT:
				setFromLat((Double)newValue);
				return;
			case CommonPackage.REQUEST__FROM_LON:
				setFromLon((Double)newValue);
				return;
			case CommonPackage.REQUEST__TO_LAT:
				setToLat((Double)newValue);
				return;
			case CommonPackage.REQUEST__TO_LON:
				setToLon((Double)newValue);
				return;
			case CommonPackage.REQUEST__MAX_WALK_DISTANCE:
				setMaxWalkDistance((Integer)newValue);
				return;
			case CommonPackage.REQUEST__TIMEZONE:
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
			case CommonPackage.REQUEST__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case CommonPackage.REQUEST__DATE:
				setDate(DATE_EDEFAULT);
				return;
			case CommonPackage.REQUEST__FROM_STOP_ID:
				setFromStopId(FROM_STOP_ID_EDEFAULT);
				return;
			case CommonPackage.REQUEST__TO_STOP_ID:
				setToStopId(TO_STOP_ID_EDEFAULT);
				return;
			case CommonPackage.REQUEST__FROM_LAT:
				setFromLat(FROM_LAT_EDEFAULT);
				return;
			case CommonPackage.REQUEST__FROM_LON:
				setFromLon(FROM_LON_EDEFAULT);
				return;
			case CommonPackage.REQUEST__TO_LAT:
				setToLat(TO_LAT_EDEFAULT);
				return;
			case CommonPackage.REQUEST__TO_LON:
				setToLon(TO_LON_EDEFAULT);
				return;
			case CommonPackage.REQUEST__MAX_WALK_DISTANCE:
				setMaxWalkDistance(MAX_WALK_DISTANCE_EDEFAULT);
				return;
			case CommonPackage.REQUEST__TIMEZONE:
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
			case CommonPackage.REQUEST__TIME:
				return TIME_EDEFAULT == null ? time != null : !TIME_EDEFAULT.equals(time);
			case CommonPackage.REQUEST__DATE:
				return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals(date);
			case CommonPackage.REQUEST__FROM_STOP_ID:
				return FROM_STOP_ID_EDEFAULT == null ? fromStopId != null : !FROM_STOP_ID_EDEFAULT.equals(fromStopId);
			case CommonPackage.REQUEST__TO_STOP_ID:
				return TO_STOP_ID_EDEFAULT == null ? toStopId != null : !TO_STOP_ID_EDEFAULT.equals(toStopId);
			case CommonPackage.REQUEST__FROM_LAT:
				return fromLat != FROM_LAT_EDEFAULT;
			case CommonPackage.REQUEST__FROM_LON:
				return fromLon != FROM_LON_EDEFAULT;
			case CommonPackage.REQUEST__TO_LAT:
				return toLat != TO_LAT_EDEFAULT;
			case CommonPackage.REQUEST__TO_LON:
				return toLon != TO_LON_EDEFAULT;
			case CommonPackage.REQUEST__MAX_WALK_DISTANCE:
				return maxWalkDistance != MAX_WALK_DISTANCE_EDEFAULT;
			case CommonPackage.REQUEST__TIMEZONE:
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
		result.append(" (time: ");
		result.append(time);
		result.append(", date: ");
		result.append(date);
		result.append(", fromStopId: ");
		result.append(fromStopId);
		result.append(", toStopId: ");
		result.append(toStopId);
		result.append(", fromLat: ");
		result.append(fromLat);
		result.append(", fromLon: ");
		result.append(fromLon);
		result.append(", toLat: ");
		result.append(toLat);
		result.append(", toLon: ");
		result.append(toLon);
		result.append(", maxWalkDistance: ");
		result.append(maxWalkDistance);
		result.append(", timezone: ");
		result.append(timezone);
		result.append(')');
		return result.toString();
	}

} //RequestImpl
