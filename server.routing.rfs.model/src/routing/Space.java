/**
 */
package routing;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link routing.Space#getConnections <em>Connections</em>}</li>
 *   <li>{@link routing.Space#getFootpaths <em>Footpaths</em>}</li>
 *   <li>{@link routing.Space#getStops <em>Stops</em>}</li>
 * </ul>
 * </p>
 *
 * @see routing.RoutingPackage#getSpace()
 * @model
 * @generated
 */
public interface Space extends EObject {
	/**
	 * Returns the value of the '<em><b>Connections</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type list of {@link routing.Connection},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' map.
	 * @see routing.RoutingPackage#getSpace_Connections()
	 * @model mapType="routing.StringToConnectionMap<org.eclipse.emf.ecore.EString, routing.Connection>"
	 * @generated
	 */
	EMap<String, EList<Connection>> getConnections();

	/**
	 * Returns the value of the '<em><b>Footpaths</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type list of {@link routing.Footpath},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footpaths</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Footpaths</em>' map.
	 * @see routing.RoutingPackage#getSpace_Footpaths()
	 * @model mapType="routing.StringToFootpathMap<org.eclipse.emf.ecore.EString, routing.Footpath>"
	 * @generated
	 */
	EMap<String, EList<Footpath>> getFootpaths();

	/**
	 * Returns the value of the '<em><b>Stops</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link routing.StopPoint},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stops</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stops</em>' map.
	 * @see routing.RoutingPackage#getSpace_Stops()
	 * @model mapType="routing.StringToStopPointMap<org.eclipse.emf.ecore.EString, routing.StopPoint>"
	 * @generated
	 */
	EMap<String, StopPoint> getStops();

} // Space
