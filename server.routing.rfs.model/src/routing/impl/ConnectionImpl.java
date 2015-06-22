/**
 */
package routing.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import routing.Connection;
import routing.RoutingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link routing.impl.ConnectionImpl#getServiceId <em>Service Id</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getTripId <em>Trip Id</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getDepStopSequence <em>Dep Stop Sequence</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getDepartureTime <em>Departure Time</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getArrStopSequence <em>Arr Stop Sequence</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getArrivalTime <em>Arrival Time</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#isRelaxed <em>Relaxed</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getPrevC <em>Prev C</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionImpl extends LegImpl implements Connection {
	/**
	 * The default value of the '{@link #getServiceId() <em>Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceId()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceId() <em>Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceId()
	 * @generated
	 * @ordered
	 */
	protected String serviceId = SERVICE_ID_EDEFAULT;

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
	 * The default value of the '{@link #getDepStopSequence() <em>Dep Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepStopSequence()
	 * @generated
	 * @ordered
	 */
	protected static final int DEP_STOP_SEQUENCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDepStopSequence() <em>Dep Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepStopSequence()
	 * @generated
	 * @ordered
	 */
	protected int depStopSequence = DEP_STOP_SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDepartureTime() <em>Departure Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartureTime()
	 * @generated
	 * @ordered
	 */
	protected static final long DEPARTURE_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDepartureTime() <em>Departure Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartureTime()
	 * @generated
	 * @ordered
	 */
	protected long departureTime = DEPARTURE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getArrStopSequence() <em>Arr Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrStopSequence()
	 * @generated
	 * @ordered
	 */
	protected static final int ARR_STOP_SEQUENCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getArrStopSequence() <em>Arr Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrStopSequence()
	 * @generated
	 * @ordered
	 */
	protected int arrStopSequence = ARR_STOP_SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getArrivalTime() <em>Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected static final long ARRIVAL_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getArrivalTime() <em>Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected long arrivalTime = ARRIVAL_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #isRelaxed() <em>Relaxed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRelaxed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RELAXED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRelaxed() <em>Relaxed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRelaxed()
	 * @generated
	 * @ordered
	 */
	protected boolean relaxed = RELAXED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrevC() <em>Prev C</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrevC()
	 * @generated
	 * @ordered
	 */
	protected Connection prevC;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RoutingPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceId(String newServiceId) {
		String oldServiceId = serviceId;
		serviceId = newServiceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__SERVICE_ID, oldServiceId, serviceId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__TRIP_ID, oldTripId, tripId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDepStopSequence() {
		return depStopSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepStopSequence(int newDepStopSequence) {
		int oldDepStopSequence = depStopSequence;
		depStopSequence = newDepStopSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__DEP_STOP_SEQUENCE, oldDepStopSequence, depStopSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDepartureTime() {
		return departureTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartureTime(long newDepartureTime) {
		long oldDepartureTime = departureTime;
		departureTime = newDepartureTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__DEPARTURE_TIME, oldDepartureTime, departureTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getArrStopSequence() {
		return arrStopSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrStopSequence(int newArrStopSequence) {
		int oldArrStopSequence = arrStopSequence;
		arrStopSequence = newArrStopSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__ARR_STOP_SEQUENCE, oldArrStopSequence, arrStopSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrivalTime(long newArrivalTime) {
		long oldArrivalTime = arrivalTime;
		arrivalTime = newArrivalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__ARRIVAL_TIME, oldArrivalTime, arrivalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRelaxed() {
		return relaxed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelaxed(boolean newRelaxed) {
		boolean oldRelaxed = relaxed;
		relaxed = newRelaxed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__RELAXED, oldRelaxed, relaxed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection getPrevC() {
		if (prevC != null && prevC.eIsProxy()) {
			InternalEObject oldPrevC = (InternalEObject)prevC;
			prevC = (Connection)eResolveProxy(oldPrevC);
			if (prevC != oldPrevC) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoutingPackage.CONNECTION__PREV_C, oldPrevC, prevC));
			}
		}
		return prevC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection basicGetPrevC() {
		return prevC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrevC(Connection newPrevC) {
		Connection oldPrevC = prevC;
		prevC = newPrevC;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__PREV_C, oldPrevC, prevC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RoutingPackage.CONNECTION__SERVICE_ID:
				return getServiceId();
			case RoutingPackage.CONNECTION__TRIP_ID:
				return getTripId();
			case RoutingPackage.CONNECTION__DEP_STOP_SEQUENCE:
				return getDepStopSequence();
			case RoutingPackage.CONNECTION__DEPARTURE_TIME:
				return getDepartureTime();
			case RoutingPackage.CONNECTION__ARR_STOP_SEQUENCE:
				return getArrStopSequence();
			case RoutingPackage.CONNECTION__ARRIVAL_TIME:
				return getArrivalTime();
			case RoutingPackage.CONNECTION__RELAXED:
				return isRelaxed();
			case RoutingPackage.CONNECTION__PREV_C:
				if (resolve) return getPrevC();
				return basicGetPrevC();
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
			case RoutingPackage.CONNECTION__SERVICE_ID:
				setServiceId((String)newValue);
				return;
			case RoutingPackage.CONNECTION__TRIP_ID:
				setTripId((String)newValue);
				return;
			case RoutingPackage.CONNECTION__DEP_STOP_SEQUENCE:
				setDepStopSequence((Integer)newValue);
				return;
			case RoutingPackage.CONNECTION__DEPARTURE_TIME:
				setDepartureTime((Long)newValue);
				return;
			case RoutingPackage.CONNECTION__ARR_STOP_SEQUENCE:
				setArrStopSequence((Integer)newValue);
				return;
			case RoutingPackage.CONNECTION__ARRIVAL_TIME:
				setArrivalTime((Long)newValue);
				return;
			case RoutingPackage.CONNECTION__RELAXED:
				setRelaxed((Boolean)newValue);
				return;
			case RoutingPackage.CONNECTION__PREV_C:
				setPrevC((Connection)newValue);
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
			case RoutingPackage.CONNECTION__SERVICE_ID:
				setServiceId(SERVICE_ID_EDEFAULT);
				return;
			case RoutingPackage.CONNECTION__TRIP_ID:
				setTripId(TRIP_ID_EDEFAULT);
				return;
			case RoutingPackage.CONNECTION__DEP_STOP_SEQUENCE:
				setDepStopSequence(DEP_STOP_SEQUENCE_EDEFAULT);
				return;
			case RoutingPackage.CONNECTION__DEPARTURE_TIME:
				setDepartureTime(DEPARTURE_TIME_EDEFAULT);
				return;
			case RoutingPackage.CONNECTION__ARR_STOP_SEQUENCE:
				setArrStopSequence(ARR_STOP_SEQUENCE_EDEFAULT);
				return;
			case RoutingPackage.CONNECTION__ARRIVAL_TIME:
				setArrivalTime(ARRIVAL_TIME_EDEFAULT);
				return;
			case RoutingPackage.CONNECTION__RELAXED:
				setRelaxed(RELAXED_EDEFAULT);
				return;
			case RoutingPackage.CONNECTION__PREV_C:
				setPrevC((Connection)null);
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
			case RoutingPackage.CONNECTION__SERVICE_ID:
				return SERVICE_ID_EDEFAULT == null ? serviceId != null : !SERVICE_ID_EDEFAULT.equals(serviceId);
			case RoutingPackage.CONNECTION__TRIP_ID:
				return TRIP_ID_EDEFAULT == null ? tripId != null : !TRIP_ID_EDEFAULT.equals(tripId);
			case RoutingPackage.CONNECTION__DEP_STOP_SEQUENCE:
				return depStopSequence != DEP_STOP_SEQUENCE_EDEFAULT;
			case RoutingPackage.CONNECTION__DEPARTURE_TIME:
				return departureTime != DEPARTURE_TIME_EDEFAULT;
			case RoutingPackage.CONNECTION__ARR_STOP_SEQUENCE:
				return arrStopSequence != ARR_STOP_SEQUENCE_EDEFAULT;
			case RoutingPackage.CONNECTION__ARRIVAL_TIME:
				return arrivalTime != ARRIVAL_TIME_EDEFAULT;
			case RoutingPackage.CONNECTION__RELAXED:
				return relaxed != RELAXED_EDEFAULT;
			case RoutingPackage.CONNECTION__PREV_C:
				return prevC != null;
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
		result.append(" (serviceId: ");
		result.append(serviceId);
		result.append(", tripId: ");
		result.append(tripId);
		result.append(", depStopSequence: ");
		result.append(depStopSequence);
		result.append(", departureTime: ");
		result.append(departureTime);
		result.append(", arrStopSequence: ");
		result.append(arrStopSequence);
		result.append(", arrivalTime: ");
		result.append(arrivalTime);
		result.append(", relaxed: ");
		result.append(relaxed);
		result.append(')');
		return result.toString();
	}
	
	@Override
	public int compareTo(Connection arg0) {
		int aux = (int) (departureTime - arg0.getDepartureTime()) ;
		return aux;
	}

} //ConnectionImpl
