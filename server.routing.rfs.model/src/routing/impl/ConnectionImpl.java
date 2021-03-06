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
 * </p>
 * <ul>
 *   <li>{@link routing.impl.ConnectionImpl#getAgencyName <em>Agency Name</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getServiceId <em>Service Id</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getRouteId <em>Route Id</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getDepStopSequence <em>Dep Stop Sequence</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getDepartureTime <em>Departure Time</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getArrStopSequence <em>Arr Stop Sequence</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getArrivalTime <em>Arrival Time</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getDepartureDelay <em>Departure Delay</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getArrivalDelay <em>Arrival Delay</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#isRelaxed <em>Relaxed</em>}</li>
 *   <li>{@link routing.impl.ConnectionImpl#getPrevC <em>Prev C</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionImpl extends LegImpl implements Connection {
	/**
	 * The default value of the '{@link #getAgencyName() <em>Agency Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgencyName()
	 * @generated
	 * @ordered
	 */
	protected static final String AGENCY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAgencyName() <em>Agency Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgencyName()
	 * @generated
	 * @ordered
	 */
	protected String agencyName = AGENCY_NAME_EDEFAULT;

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
	public String getAgencyName() {
		return agencyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgencyName(String newAgencyName) {
		String oldAgencyName = agencyName;
		agencyName = newAgencyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__AGENCY_NAME, oldAgencyName, agencyName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__ROUTE_ID, oldRouteId, routeId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__DEPARTURE_DELAY, oldDepartureDelay, departureDelay));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.CONNECTION__ARRIVAL_DELAY, oldArrivalDelay, arrivalDelay));
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
			case RoutingPackage.CONNECTION__AGENCY_NAME:
				return getAgencyName();
			case RoutingPackage.CONNECTION__SERVICE_ID:
				return getServiceId();
			case RoutingPackage.CONNECTION__ROUTE_ID:
				return getRouteId();
			case RoutingPackage.CONNECTION__DEP_STOP_SEQUENCE:
				return getDepStopSequence();
			case RoutingPackage.CONNECTION__DEPARTURE_TIME:
				return getDepartureTime();
			case RoutingPackage.CONNECTION__ARR_STOP_SEQUENCE:
				return getArrStopSequence();
			case RoutingPackage.CONNECTION__ARRIVAL_TIME:
				return getArrivalTime();
			case RoutingPackage.CONNECTION__DEPARTURE_DELAY:
				return getDepartureDelay();
			case RoutingPackage.CONNECTION__ARRIVAL_DELAY:
				return getArrivalDelay();
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
			case RoutingPackage.CONNECTION__AGENCY_NAME:
				setAgencyName((String)newValue);
				return;
			case RoutingPackage.CONNECTION__SERVICE_ID:
				setServiceId((String)newValue);
				return;
			case RoutingPackage.CONNECTION__ROUTE_ID:
				setRouteId((String)newValue);
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
			case RoutingPackage.CONNECTION__DEPARTURE_DELAY:
				setDepartureDelay((Integer)newValue);
				return;
			case RoutingPackage.CONNECTION__ARRIVAL_DELAY:
				setArrivalDelay((Integer)newValue);
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
			case RoutingPackage.CONNECTION__AGENCY_NAME:
				setAgencyName(AGENCY_NAME_EDEFAULT);
				return;
			case RoutingPackage.CONNECTION__SERVICE_ID:
				setServiceId(SERVICE_ID_EDEFAULT);
				return;
			case RoutingPackage.CONNECTION__ROUTE_ID:
				setRouteId(ROUTE_ID_EDEFAULT);
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
			case RoutingPackage.CONNECTION__DEPARTURE_DELAY:
				setDepartureDelay(DEPARTURE_DELAY_EDEFAULT);
				return;
			case RoutingPackage.CONNECTION__ARRIVAL_DELAY:
				setArrivalDelay(ARRIVAL_DELAY_EDEFAULT);
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
			case RoutingPackage.CONNECTION__AGENCY_NAME:
				return AGENCY_NAME_EDEFAULT == null ? agencyName != null : !AGENCY_NAME_EDEFAULT.equals(agencyName);
			case RoutingPackage.CONNECTION__SERVICE_ID:
				return SERVICE_ID_EDEFAULT == null ? serviceId != null : !SERVICE_ID_EDEFAULT.equals(serviceId);
			case RoutingPackage.CONNECTION__ROUTE_ID:
				return ROUTE_ID_EDEFAULT == null ? routeId != null : !ROUTE_ID_EDEFAULT.equals(routeId);
			case RoutingPackage.CONNECTION__DEP_STOP_SEQUENCE:
				return depStopSequence != DEP_STOP_SEQUENCE_EDEFAULT;
			case RoutingPackage.CONNECTION__DEPARTURE_TIME:
				return departureTime != DEPARTURE_TIME_EDEFAULT;
			case RoutingPackage.CONNECTION__ARR_STOP_SEQUENCE:
				return arrStopSequence != ARR_STOP_SEQUENCE_EDEFAULT;
			case RoutingPackage.CONNECTION__ARRIVAL_TIME:
				return arrivalTime != ARRIVAL_TIME_EDEFAULT;
			case RoutingPackage.CONNECTION__DEPARTURE_DELAY:
				return departureDelay != DEPARTURE_DELAY_EDEFAULT;
			case RoutingPackage.CONNECTION__ARRIVAL_DELAY:
				return arrivalDelay != ARRIVAL_DELAY_EDEFAULT;
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
		result.append(" (agencyName: ");
		result.append(agencyName);
		result.append(", serviceId: ");
		result.append(serviceId);
		result.append(", routeId: ");
		result.append(routeId);
		result.append(", depStopSequence: ");
		result.append(depStopSequence);
		result.append(", departureTime: ");
		result.append(departureTime);
		result.append(", arrStopSequence: ");
		result.append(arrStopSequence);
		result.append(", arrivalTime: ");
		result.append(arrivalTime);
		result.append(", departureDelay: ");
		result.append(departureDelay);
		result.append(", arrivalDelay: ");
		result.append(arrivalDelay);
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
