/**
 */
package routing.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import routing.Itinerary;
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
 *   <li>{@link routing.impl.StopPointImpl#getBestJourneys <em>Best Journeys</em>}</li>
 *   <li>{@link routing.impl.StopPointImpl#getRoutesId <em>Routes Id</em>}</li>
 *   <li>{@link routing.impl.StopPointImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link routing.impl.StopPointImpl#getLongitude <em>Longitude</em>}</li>
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
	 * The cached value of the '{@link #getBestJourneys() <em>Best Journeys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBestJourneys()
	 * @generated
	 * @ordered
	 */
	protected EList<Itinerary> bestJourneys;

	/**
	 * The cached value of the '{@link #getRoutesId() <em>Routes Id</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutesId()
	 * @generated
	 * @ordered
	 */
	protected EList<String> routesId;

	/**
	 * The default value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LATITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected double latitude = LATITUDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LONGITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected double longitude = LONGITUDE_EDEFAULT;

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
	public EList<Itinerary> getBestJourneys() {
		if (bestJourneys == null) {
			bestJourneys = new EObjectResolvingEList<Itinerary>(Itinerary.class, this, RoutingPackage.STOP_POINT__BEST_JOURNEYS);
		}
		return bestJourneys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRoutesId() {
		if (routesId == null) {
			routesId = new EDataTypeUniqueEList<String>(String.class, this, RoutingPackage.STOP_POINT__ROUTES_ID);
		}
		return routesId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatitude(double newLatitude) {
		double oldLatitude = latitude;
		latitude = newLatitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.STOP_POINT__LATITUDE, oldLatitude, latitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitude(double newLongitude) {
		double oldLongitude = longitude;
		longitude = newLongitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.STOP_POINT__LONGITUDE, oldLongitude, longitude));
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
			case RoutingPackage.STOP_POINT__BEST_JOURNEYS:
				return getBestJourneys();
			case RoutingPackage.STOP_POINT__ROUTES_ID:
				return getRoutesId();
			case RoutingPackage.STOP_POINT__LATITUDE:
				return getLatitude();
			case RoutingPackage.STOP_POINT__LONGITUDE:
				return getLongitude();
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
			case RoutingPackage.STOP_POINT__STOP_ID:
				setStopId((String)newValue);
				return;
			case RoutingPackage.STOP_POINT__NAME:
				setName((String)newValue);
				return;
			case RoutingPackage.STOP_POINT__MINIMAL_CONNECTION_TIME:
				setMinimalConnectionTime((Integer)newValue);
				return;
			case RoutingPackage.STOP_POINT__BEST_JOURNEYS:
				getBestJourneys().clear();
				getBestJourneys().addAll((Collection<? extends Itinerary>)newValue);
				return;
			case RoutingPackage.STOP_POINT__ROUTES_ID:
				getRoutesId().clear();
				getRoutesId().addAll((Collection<? extends String>)newValue);
				return;
			case RoutingPackage.STOP_POINT__LATITUDE:
				setLatitude((Double)newValue);
				return;
			case RoutingPackage.STOP_POINT__LONGITUDE:
				setLongitude((Double)newValue);
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
			case RoutingPackage.STOP_POINT__BEST_JOURNEYS:
				getBestJourneys().clear();
				return;
			case RoutingPackage.STOP_POINT__ROUTES_ID:
				getRoutesId().clear();
				return;
			case RoutingPackage.STOP_POINT__LATITUDE:
				setLatitude(LATITUDE_EDEFAULT);
				return;
			case RoutingPackage.STOP_POINT__LONGITUDE:
				setLongitude(LONGITUDE_EDEFAULT);
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
			case RoutingPackage.STOP_POINT__BEST_JOURNEYS:
				return bestJourneys != null && !bestJourneys.isEmpty();
			case RoutingPackage.STOP_POINT__ROUTES_ID:
				return routesId != null && !routesId.isEmpty();
			case RoutingPackage.STOP_POINT__LATITUDE:
				return latitude != LATITUDE_EDEFAULT;
			case RoutingPackage.STOP_POINT__LONGITUDE:
				return longitude != LONGITUDE_EDEFAULT;
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
		result.append(", routesId: ");
		result.append(routesId);
		result.append(", latitude: ");
		result.append(latitude);
		result.append(", longitude: ");
		result.append(longitude);
		result.append(')');
		return result.toString();
	}

	@Override
	public long getBestArrivalTime() {
		long time = Integer.MAX_VALUE ;
		if (bestJourneys.size() <= 0) return time ;
		for (Itinerary it : bestJourneys) {
			if (it.getArrivalTime() < time) time = it.getArrivalTime() ;
		}
		return time;
	}

} //StopPointImpl
