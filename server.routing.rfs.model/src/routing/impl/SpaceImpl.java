/**
 */
package routing.impl;

import java.util.Date;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import routing.Connection;
import routing.Footpath;
import routing.RoutingPackage;
import routing.Space;
import routing.StopPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link routing.impl.SpaceImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link routing.impl.SpaceImpl#getFootpaths <em>Footpaths</em>}</li>
 *   <li>{@link routing.impl.SpaceImpl#getStops <em>Stops</em>}</li>
 *   <li>{@link routing.impl.SpaceImpl#getCalendar <em>Calendar</em>}</li>
 *   <li>{@link routing.impl.SpaceImpl#getTimezone <em>Timezone</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpaceImpl extends MinimalEObjectImpl.Container implements Space {
	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EList<Connection>> connections;

	/**
	 * The cached value of the '{@link #getFootpaths() <em>Footpaths</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFootpaths()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, EList<Footpath>> footpaths;

	/**
	 * The cached value of the '{@link #getStops() <em>Stops</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStops()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, StopPoint> stops;

	/**
	 * The cached value of the '{@link #getCalendar() <em>Calendar</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalendar()
	 * @generated
	 * @ordered
	 */
	protected EMap<Date, EList<String>> calendar;

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
	protected SpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RoutingPackage.Literals.SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EList<Connection>> getConnections() {
		if (connections == null) {
			connections = new EcoreEMap<String,EList<Connection>>(RoutingPackage.Literals.STRING_TO_CONNECTION_MAP, StringToConnectionMapImpl.class, this, RoutingPackage.SPACE__CONNECTIONS);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, EList<Footpath>> getFootpaths() {
		if (footpaths == null) {
			footpaths = new EcoreEMap<String,EList<Footpath>>(RoutingPackage.Literals.STRING_TO_FOOTPATH_MAP, StringToFootpathMapImpl.class, this, RoutingPackage.SPACE__FOOTPATHS);
		}
		return footpaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, StopPoint> getStops() {
		if (stops == null) {
			stops = new EcoreEMap<String,StopPoint>(RoutingPackage.Literals.STRING_TO_STOP_POINT_MAP, StringToStopPointMapImpl.class, this, RoutingPackage.SPACE__STOPS);
		}
		return stops;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<Date, EList<String>> getCalendar() {
		if (calendar == null) {
			calendar = new EcoreEMap<Date,EList<String>>(RoutingPackage.Literals.DATE_TO_STRING_MAP, DateToStringMapImpl.class, this, RoutingPackage.SPACE__CALENDAR);
		}
		return calendar;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.SPACE__TIMEZONE, oldTimezone, timezone));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RoutingPackage.SPACE__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
			case RoutingPackage.SPACE__FOOTPATHS:
				return ((InternalEList<?>)getFootpaths()).basicRemove(otherEnd, msgs);
			case RoutingPackage.SPACE__STOPS:
				return ((InternalEList<?>)getStops()).basicRemove(otherEnd, msgs);
			case RoutingPackage.SPACE__CALENDAR:
				return ((InternalEList<?>)getCalendar()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RoutingPackage.SPACE__CONNECTIONS:
				if (coreType) return getConnections();
				else return getConnections().map();
			case RoutingPackage.SPACE__FOOTPATHS:
				if (coreType) return getFootpaths();
				else return getFootpaths().map();
			case RoutingPackage.SPACE__STOPS:
				if (coreType) return getStops();
				else return getStops().map();
			case RoutingPackage.SPACE__CALENDAR:
				if (coreType) return getCalendar();
				else return getCalendar().map();
			case RoutingPackage.SPACE__TIMEZONE:
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
			case RoutingPackage.SPACE__CONNECTIONS:
				((EStructuralFeature.Setting)getConnections()).set(newValue);
				return;
			case RoutingPackage.SPACE__FOOTPATHS:
				((EStructuralFeature.Setting)getFootpaths()).set(newValue);
				return;
			case RoutingPackage.SPACE__STOPS:
				((EStructuralFeature.Setting)getStops()).set(newValue);
				return;
			case RoutingPackage.SPACE__CALENDAR:
				((EStructuralFeature.Setting)getCalendar()).set(newValue);
				return;
			case RoutingPackage.SPACE__TIMEZONE:
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
			case RoutingPackage.SPACE__CONNECTIONS:
				getConnections().clear();
				return;
			case RoutingPackage.SPACE__FOOTPATHS:
				getFootpaths().clear();
				return;
			case RoutingPackage.SPACE__STOPS:
				getStops().clear();
				return;
			case RoutingPackage.SPACE__CALENDAR:
				getCalendar().clear();
				return;
			case RoutingPackage.SPACE__TIMEZONE:
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
			case RoutingPackage.SPACE__CONNECTIONS:
				return connections != null && !connections.isEmpty();
			case RoutingPackage.SPACE__FOOTPATHS:
				return footpaths != null && !footpaths.isEmpty();
			case RoutingPackage.SPACE__STOPS:
				return stops != null && !stops.isEmpty();
			case RoutingPackage.SPACE__CALENDAR:
				return calendar != null && !calendar.isEmpty();
			case RoutingPackage.SPACE__TIMEZONE:
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
		result.append(" (timezone: ");
		result.append(timezone);
		result.append(')');
		return result.toString();
	}

} //SpaceImpl
