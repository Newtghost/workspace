/**
 */
package routing.util;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import routing.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see routing.RoutingPackage
 * @generated
 */
public class RoutingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RoutingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoutingSwitch() {
		if (modelPackage == null) {
			modelPackage = RoutingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RoutingPackage.SPACE: {
				Space space = (Space)theEObject;
				T result = caseSpace(space);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoutingPackage.LEG: {
				Leg leg = (Leg)theEObject;
				T result = caseLeg(leg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoutingPackage.CONNECTION: {
				Connection connection = (Connection)theEObject;
				T result = caseConnection(connection);
				if (result == null) result = caseLeg(connection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoutingPackage.FOOTPATH: {
				Footpath footpath = (Footpath)theEObject;
				T result = caseFootpath(footpath);
				if (result == null) result = caseLeg(footpath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoutingPackage.STOP_POINT: {
				StopPoint stopPoint = (StopPoint)theEObject;
				T result = caseStopPoint(stopPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoutingPackage.ITINERARY: {
				Itinerary itinerary = (Itinerary)theEObject;
				T result = caseItinerary(itinerary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoutingPackage.STRING_TO_FOOTPATH_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, EList<Footpath>> stringToFootpathMap = (Map.Entry<String, EList<Footpath>>)theEObject;
				T result = caseStringToFootpathMap(stringToFootpathMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoutingPackage.STRING_TO_STOP_POINT_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, StopPoint> stringToStopPointMap = (Map.Entry<String, StopPoint>)theEObject;
				T result = caseStringToStopPointMap(stringToStopPointMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoutingPackage.STRING_TO_CONNECTION_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, EList<Connection>> stringToConnectionMap = (Map.Entry<String, EList<Connection>>)theEObject;
				T result = caseStringToConnectionMap(stringToConnectionMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RoutingPackage.DATE_TO_STRING_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, EList<String>> dateToStringMap = (Map.Entry<String, EList<String>>)theEObject;
				T result = caseDateToStringMap(dateToStringMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpace(Space object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeg(Leg object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnection(Connection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Footpath</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Footpath</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFootpath(Footpath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stop Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stop Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStopPoint(StopPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Itinerary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Itinerary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItinerary(Itinerary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Footpath Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Footpath Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToFootpathMap(Map.Entry<String, EList<Footpath>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Stop Point Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Stop Point Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToStopPointMap(Map.Entry<String, StopPoint> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Connection Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Connection Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToConnectionMap(Map.Entry<String, EList<Connection>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Date To String Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Date To String Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDateToStringMap(Map.Entry<String, EList<String>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //RoutingSwitch
