/**
 */
package common.impl;

import common.CommonPackage;
import common.Request;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link common.impl.RequestImpl#getTime <em>Time</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getDate <em>Date</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getFromStopId <em>From Stop Id</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getToStopId <em>To Stop Id</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getFromLat <em>From Lat</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getFromLon <em>From Lon</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getToLat <em>To Lat</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getToLon <em>To Lon</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getBannedRoutes <em>Banned Routes</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getMaximumWalk <em>Maximum Walk</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getMaximumWait <em>Maximum Wait</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getSignificantGapWalk <em>Significant Gap Walk</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getSignificantGapDuration <em>Significant Gap Duration</em>}</li>
 *   <li>{@link common.impl.RequestImpl#getSignificantGapDeparture <em>Significant Gap Departure</em>}</li>
 * </ul>
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
	 * The cached value of the '{@link #getBannedRoutes() <em>Banned Routes</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBannedRoutes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> bannedRoutes;

	/**
	 * The default value of the '{@link #getMaximumWalk() <em>Maximum Walk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumWalk()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXIMUM_WALK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaximumWalk() <em>Maximum Walk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumWalk()
	 * @generated
	 * @ordered
	 */
	protected int maximumWalk = MAXIMUM_WALK_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumWait() <em>Maximum Wait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumWait()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXIMUM_WAIT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaximumWait() <em>Maximum Wait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumWait()
	 * @generated
	 * @ordered
	 */
	protected int maximumWait = MAXIMUM_WAIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignificantGapWalk() <em>Significant Gap Walk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignificantGapWalk()
	 * @generated
	 * @ordered
	 */
	protected static final int SIGNIFICANT_GAP_WALK_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSignificantGapWalk() <em>Significant Gap Walk</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignificantGapWalk()
	 * @generated
	 * @ordered
	 */
	protected int significantGapWalk = SIGNIFICANT_GAP_WALK_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignificantGapDuration() <em>Significant Gap Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignificantGapDuration()
	 * @generated
	 * @ordered
	 */
	protected static final int SIGNIFICANT_GAP_DURATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSignificantGapDuration() <em>Significant Gap Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignificantGapDuration()
	 * @generated
	 * @ordered
	 */
	protected int significantGapDuration = SIGNIFICANT_GAP_DURATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignificantGapDeparture() <em>Significant Gap Departure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignificantGapDeparture()
	 * @generated
	 * @ordered
	 */
	protected static final int SIGNIFICANT_GAP_DEPARTURE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSignificantGapDeparture() <em>Significant Gap Departure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignificantGapDeparture()
	 * @generated
	 * @ordered
	 */
	protected int significantGapDeparture = SIGNIFICANT_GAP_DEPARTURE_EDEFAULT;

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
	public EList<String> getBannedRoutes() {
		if (bannedRoutes == null) {
			bannedRoutes = new EDataTypeUniqueEList<String>(String.class, this, CommonPackage.REQUEST__BANNED_ROUTES);
		}
		return bannedRoutes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaximumWalk() {
		return maximumWalk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumWalk(int newMaximumWalk) {
		int oldMaximumWalk = maximumWalk;
		maximumWalk = newMaximumWalk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__MAXIMUM_WALK, oldMaximumWalk, maximumWalk));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaximumWait() {
		return maximumWait;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumWait(int newMaximumWait) {
		int oldMaximumWait = maximumWait;
		maximumWait = newMaximumWait;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__MAXIMUM_WAIT, oldMaximumWait, maximumWait));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSignificantGapWalk() {
		return significantGapWalk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignificantGapWalk(int newSignificantGapWalk) {
		int oldSignificantGapWalk = significantGapWalk;
		significantGapWalk = newSignificantGapWalk;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__SIGNIFICANT_GAP_WALK, oldSignificantGapWalk, significantGapWalk));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSignificantGapDuration() {
		return significantGapDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignificantGapDuration(int newSignificantGapDuration) {
		int oldSignificantGapDuration = significantGapDuration;
		significantGapDuration = newSignificantGapDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__SIGNIFICANT_GAP_DURATION, oldSignificantGapDuration, significantGapDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSignificantGapDeparture() {
		return significantGapDeparture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignificantGapDeparture(int newSignificantGapDeparture) {
		int oldSignificantGapDeparture = significantGapDeparture;
		significantGapDeparture = newSignificantGapDeparture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.REQUEST__SIGNIFICANT_GAP_DEPARTURE, oldSignificantGapDeparture, significantGapDeparture));
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
			case CommonPackage.REQUEST__BANNED_ROUTES:
				return getBannedRoutes();
			case CommonPackage.REQUEST__MAXIMUM_WALK:
				return getMaximumWalk();
			case CommonPackage.REQUEST__MAXIMUM_WAIT:
				return getMaximumWait();
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_WALK:
				return getSignificantGapWalk();
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_DURATION:
				return getSignificantGapDuration();
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_DEPARTURE:
				return getSignificantGapDeparture();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
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
			case CommonPackage.REQUEST__BANNED_ROUTES:
				getBannedRoutes().clear();
				getBannedRoutes().addAll((Collection<? extends String>)newValue);
				return;
			case CommonPackage.REQUEST__MAXIMUM_WALK:
				setMaximumWalk((Integer)newValue);
				return;
			case CommonPackage.REQUEST__MAXIMUM_WAIT:
				setMaximumWait((Integer)newValue);
				return;
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_WALK:
				setSignificantGapWalk((Integer)newValue);
				return;
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_DURATION:
				setSignificantGapDuration((Integer)newValue);
				return;
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_DEPARTURE:
				setSignificantGapDeparture((Integer)newValue);
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
			case CommonPackage.REQUEST__BANNED_ROUTES:
				getBannedRoutes().clear();
				return;
			case CommonPackage.REQUEST__MAXIMUM_WALK:
				setMaximumWalk(MAXIMUM_WALK_EDEFAULT);
				return;
			case CommonPackage.REQUEST__MAXIMUM_WAIT:
				setMaximumWait(MAXIMUM_WAIT_EDEFAULT);
				return;
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_WALK:
				setSignificantGapWalk(SIGNIFICANT_GAP_WALK_EDEFAULT);
				return;
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_DURATION:
				setSignificantGapDuration(SIGNIFICANT_GAP_DURATION_EDEFAULT);
				return;
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_DEPARTURE:
				setSignificantGapDeparture(SIGNIFICANT_GAP_DEPARTURE_EDEFAULT);
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
			case CommonPackage.REQUEST__BANNED_ROUTES:
				return bannedRoutes != null && !bannedRoutes.isEmpty();
			case CommonPackage.REQUEST__MAXIMUM_WALK:
				return maximumWalk != MAXIMUM_WALK_EDEFAULT;
			case CommonPackage.REQUEST__MAXIMUM_WAIT:
				return maximumWait != MAXIMUM_WAIT_EDEFAULT;
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_WALK:
				return significantGapWalk != SIGNIFICANT_GAP_WALK_EDEFAULT;
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_DURATION:
				return significantGapDuration != SIGNIFICANT_GAP_DURATION_EDEFAULT;
			case CommonPackage.REQUEST__SIGNIFICANT_GAP_DEPARTURE:
				return significantGapDeparture != SIGNIFICANT_GAP_DEPARTURE_EDEFAULT;
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
		result.append(", bannedRoutes: ");
		result.append(bannedRoutes);
		result.append(", maximumWalk: ");
		result.append(maximumWalk);
		result.append(", maximumWait: ");
		result.append(maximumWait);
		result.append(", significantGapWalk: ");
		result.append(significantGapWalk);
		result.append(", significantGapDuration: ");
		result.append(significantGapDuration);
		result.append(", significantGapDeparture: ");
		result.append(significantGapDeparture);
		result.append(')');
		return result.toString();
	}

	@Override
	public boolean hasStopsId() {
		return toStopId != TO_STOP_ID_EDEFAULT && fromStopId != FROM_STOP_ID_EDEFAULT;
	}

} //RequestImpl
