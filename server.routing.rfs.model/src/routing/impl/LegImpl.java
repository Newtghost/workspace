/**
 */
package routing.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import routing.Leg;
import routing.RoutingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Leg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link routing.impl.LegImpl#getDepartureId <em>Departure Id</em>}</li>
 *   <li>{@link routing.impl.LegImpl#getArrivalId <em>Arrival Id</em>}</li>
 *   <li>{@link routing.impl.LegImpl#getTripId <em>Trip Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LegImpl extends MinimalEObjectImpl.Container implements Leg {
	/**
	 * The default value of the '{@link #getDepartureId() <em>Departure Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartureId()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPARTURE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDepartureId() <em>Departure Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartureId()
	 * @generated
	 * @ordered
	 */
	protected String departureId = DEPARTURE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getArrivalId() <em>Arrival Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalId()
	 * @generated
	 * @ordered
	 */
	protected static final String ARRIVAL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArrivalId() <em>Arrival Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalId()
	 * @generated
	 * @ordered
	 */
	protected String arrivalId = ARRIVAL_ID_EDEFAULT;

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
		return RoutingPackage.Literals.LEG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepartureId() {
		return departureId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartureId(String newDepartureId) {
		String oldDepartureId = departureId;
		departureId = newDepartureId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.LEG__DEPARTURE_ID, oldDepartureId, departureId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArrivalId() {
		return arrivalId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrivalId(String newArrivalId) {
		String oldArrivalId = arrivalId;
		arrivalId = newArrivalId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.LEG__ARRIVAL_ID, oldArrivalId, arrivalId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.LEG__TRIP_ID, oldTripId, tripId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RoutingPackage.LEG__DEPARTURE_ID:
				return getDepartureId();
			case RoutingPackage.LEG__ARRIVAL_ID:
				return getArrivalId();
			case RoutingPackage.LEG__TRIP_ID:
				return getTripId();
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
			case RoutingPackage.LEG__DEPARTURE_ID:
				setDepartureId((String)newValue);
				return;
			case RoutingPackage.LEG__ARRIVAL_ID:
				setArrivalId((String)newValue);
				return;
			case RoutingPackage.LEG__TRIP_ID:
				setTripId((String)newValue);
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
			case RoutingPackage.LEG__DEPARTURE_ID:
				setDepartureId(DEPARTURE_ID_EDEFAULT);
				return;
			case RoutingPackage.LEG__ARRIVAL_ID:
				setArrivalId(ARRIVAL_ID_EDEFAULT);
				return;
			case RoutingPackage.LEG__TRIP_ID:
				setTripId(TRIP_ID_EDEFAULT);
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
			case RoutingPackage.LEG__DEPARTURE_ID:
				return DEPARTURE_ID_EDEFAULT == null ? departureId != null : !DEPARTURE_ID_EDEFAULT.equals(departureId);
			case RoutingPackage.LEG__ARRIVAL_ID:
				return ARRIVAL_ID_EDEFAULT == null ? arrivalId != null : !ARRIVAL_ID_EDEFAULT.equals(arrivalId);
			case RoutingPackage.LEG__TRIP_ID:
				return TRIP_ID_EDEFAULT == null ? tripId != null : !TRIP_ID_EDEFAULT.equals(tripId);
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
		result.append(" (departureId: ");
		result.append(departureId);
		result.append(", arrivalId: ");
		result.append(arrivalId);
		result.append(", tripId: ");
		result.append(tripId);
		result.append(')');
		return result.toString();
	}

} //LegImpl
