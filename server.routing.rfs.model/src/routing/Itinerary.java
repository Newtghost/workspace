/**
 */
package routing;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Itinerary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link routing.Itinerary#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see routing.RoutingPackage#getItinerary()
 * @model
 * @generated
 */
public interface Itinerary extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' reference list.
	 * The list contents are of type {@link routing.Leg}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' reference list.
	 * @see routing.RoutingPackage#getItinerary_Path()
	 * @model
	 * @generated
	 */
	EList<Leg> getPath();

} // Itinerary
