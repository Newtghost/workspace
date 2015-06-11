/**
 */
package routing.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RoutingPackage.SPACE__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
			case RoutingPackage.SPACE__FOOTPATHS:
				return ((InternalEList<?>)getFootpaths()).basicRemove(otherEnd, msgs);
			case RoutingPackage.SPACE__STOPS:
				return ((InternalEList<?>)getStops()).basicRemove(otherEnd, msgs);
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
		}
		return super.eIsSet(featureID);
	}

} //SpaceImpl
