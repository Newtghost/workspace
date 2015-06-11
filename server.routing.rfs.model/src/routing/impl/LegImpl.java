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
 * <ul>
 *   <li>{@link routing.impl.LegImpl#getDepartureId <em>Departure Id</em>}</li>
 *   <li>{@link routing.impl.LegImpl#getArrivalId <em>Arrival Id</em>}</li>
 *   <li>{@link routing.impl.LegImpl#getTimezone <em>Timezone</em>}</li>
 * </ul>
 * </p>
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
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.LEG__TIMEZONE, oldTimezone, timezone));
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
			case RoutingPackage.LEG__TIMEZONE:
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
			case RoutingPackage.LEG__DEPARTURE_ID:
				setDepartureId((String)newValue);
				return;
			case RoutingPackage.LEG__ARRIVAL_ID:
				setArrivalId((String)newValue);
				return;
			case RoutingPackage.LEG__TIMEZONE:
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
			case RoutingPackage.LEG__DEPARTURE_ID:
				setDepartureId(DEPARTURE_ID_EDEFAULT);
				return;
			case RoutingPackage.LEG__ARRIVAL_ID:
				setArrivalId(ARRIVAL_ID_EDEFAULT);
				return;
			case RoutingPackage.LEG__TIMEZONE:
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
			case RoutingPackage.LEG__DEPARTURE_ID:
				return DEPARTURE_ID_EDEFAULT == null ? departureId != null : !DEPARTURE_ID_EDEFAULT.equals(departureId);
			case RoutingPackage.LEG__ARRIVAL_ID:
				return ARRIVAL_ID_EDEFAULT == null ? arrivalId != null : !ARRIVAL_ID_EDEFAULT.equals(arrivalId);
			case RoutingPackage.LEG__TIMEZONE:
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
		result.append(" (departureId: ");
		result.append(departureId);
		result.append(", arrivalId: ");
		result.append(arrivalId);
		result.append(", timezone: ");
		result.append(timezone);
		result.append(')');
		return result.toString();
	}

} //LegImpl
