/**
 */
package routing.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import routing.Leg;
import routing.RoutingPackage;
import routing.StopPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stop Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link routing.impl.StopPointImpl#getStopId <em>Stop Id</em>}</li>
 *   <li>{@link routing.impl.StopPointImpl#getName <em>Name</em>}</li>
 *   <li>{@link routing.impl.StopPointImpl#getMinimalConnectionTime <em>Minimal Connection Time</em>}</li>
 *   <li>{@link routing.impl.StopPointImpl#getBestArrivalTime <em>Best Arrival Time</em>}</li>
 *   <li>{@link routing.impl.StopPointImpl#getBestArrivalLeg <em>Best Arrival Leg</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StopPointImpl extends MinimalEObjectImpl.Container implements StopPoint {
	/**
	 * The default value of the '{@link #getStopId() <em>Stop Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopId()
	 * @generated
	 * @ordered
	 */
	protected static final String STOP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStopId() <em>Stop Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopId()
	 * @generated
	 * @ordered
	 */
	protected String stopId = STOP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimalConnectionTime() <em>Minimal Connection Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimalConnectionTime()
	 * @generated
	 * @ordered
	 */
	protected static final int MINIMAL_CONNECTION_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinimalConnectionTime() <em>Minimal Connection Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimalConnectionTime()
	 * @generated
	 * @ordered
	 */
	protected int minimalConnectionTime = MINIMAL_CONNECTION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBestArrivalTime() <em>Best Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBestArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected static final long BEST_ARRIVAL_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getBestArrivalTime() <em>Best Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBestArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected long bestArrivalTime = BEST_ARRIVAL_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBestArrivalLeg() <em>Best Arrival Leg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBestArrivalLeg()
	 * @generated
	 * @ordered
	 */
	protected Leg bestArrivalLeg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StopPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RoutingPackage.Literals.STOP_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStopId() {
		return stopId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopId(String newStopId) {
		String oldStopId = stopId;
		stopId = newStopId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.STOP_POINT__STOP_ID, oldStopId, stopId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.STOP_POINT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinimalConnectionTime() {
		return minimalConnectionTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimalConnectionTime(int newMinimalConnectionTime) {
		int oldMinimalConnectionTime = minimalConnectionTime;
		minimalConnectionTime = newMinimalConnectionTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.STOP_POINT__MINIMAL_CONNECTION_TIME, oldMinimalConnectionTime, minimalConnectionTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getBestArrivalTime() {
		return bestArrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBestArrivalTime(long newBestArrivalTime) {
		long oldBestArrivalTime = bestArrivalTime;
		bestArrivalTime = newBestArrivalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.STOP_POINT__BEST_ARRIVAL_TIME, oldBestArrivalTime, bestArrivalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leg getBestArrivalLeg() {
		if (bestArrivalLeg != null && bestArrivalLeg.eIsProxy()) {
			InternalEObject oldBestArrivalLeg = (InternalEObject)bestArrivalLeg;
			bestArrivalLeg = (Leg)eResolveProxy(oldBestArrivalLeg);
			if (bestArrivalLeg != oldBestArrivalLeg) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RoutingPackage.STOP_POINT__BEST_ARRIVAL_LEG, oldBestArrivalLeg, bestArrivalLeg));
			}
		}
		return bestArrivalLeg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leg basicGetBestArrivalLeg() {
		return bestArrivalLeg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBestArrivalLeg(Leg newBestArrivalLeg) {
		Leg oldBestArrivalLeg = bestArrivalLeg;
		bestArrivalLeg = newBestArrivalLeg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.STOP_POINT__BEST_ARRIVAL_LEG, oldBestArrivalLeg, bestArrivalLeg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RoutingPackage.STOP_POINT__STOP_ID:
				return getStopId();
			case RoutingPackage.STOP_POINT__NAME:
				return getName();
			case RoutingPackage.STOP_POINT__MINIMAL_CONNECTION_TIME:
				return getMinimalConnectionTime();
			case RoutingPackage.STOP_POINT__BEST_ARRIVAL_TIME:
				return getBestArrivalTime();
			case RoutingPackage.STOP_POINT__BEST_ARRIVAL_LEG:
				if (resolve) return getBestArrivalLeg();
				return basicGetBestArrivalLeg();
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
			case RoutingPackage.STOP_POINT__STOP_ID:
				setStopId((String)newValue);
				return;
			case RoutingPackage.STOP_POINT__NAME:
				setName((String)newValue);
				return;
			case RoutingPackage.STOP_POINT__MINIMAL_CONNECTION_TIME:
				setMinimalConnectionTime((Integer)newValue);
				return;
			case RoutingPackage.STOP_POINT__BEST_ARRIVAL_TIME:
				setBestArrivalTime((Long)newValue);
				return;
			case RoutingPackage.STOP_POINT__BEST_ARRIVAL_LEG:
				setBestArrivalLeg((Leg)newValue);
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
			case RoutingPackage.STOP_POINT__STOP_ID:
				setStopId(STOP_ID_EDEFAULT);
				return;
			case RoutingPackage.STOP_POINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RoutingPackage.STOP_POINT__MINIMAL_CONNECTION_TIME:
				setMinimalConnectionTime(MINIMAL_CONNECTION_TIME_EDEFAULT);
				return;
			case RoutingPackage.STOP_POINT__BEST_ARRIVAL_TIME:
				setBestArrivalTime(BEST_ARRIVAL_TIME_EDEFAULT);
				return;
			case RoutingPackage.STOP_POINT__BEST_ARRIVAL_LEG:
				setBestArrivalLeg((Leg)null);
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
			case RoutingPackage.STOP_POINT__STOP_ID:
				return STOP_ID_EDEFAULT == null ? stopId != null : !STOP_ID_EDEFAULT.equals(stopId);
			case RoutingPackage.STOP_POINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RoutingPackage.STOP_POINT__MINIMAL_CONNECTION_TIME:
				return minimalConnectionTime != MINIMAL_CONNECTION_TIME_EDEFAULT;
			case RoutingPackage.STOP_POINT__BEST_ARRIVAL_TIME:
				return bestArrivalTime != BEST_ARRIVAL_TIME_EDEFAULT;
			case RoutingPackage.STOP_POINT__BEST_ARRIVAL_LEG:
				return bestArrivalLeg != null;
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
		result.append(" (stopId: ");
		result.append(stopId);
		result.append(", name: ");
		result.append(name);
		result.append(", minimalConnectionTime: ");
		result.append(minimalConnectionTime);
		result.append(", bestArrivalTime: ");
		result.append(bestArrivalTime);
		result.append(')');
		return result.toString();
	}

} //StopPointImpl
