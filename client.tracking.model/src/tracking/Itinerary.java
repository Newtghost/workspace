/**
 */
package tracking;

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
 *   <li>{@link tracking.Itinerary#getLegs <em>Legs</em>}</li>
 *   <li>{@link tracking.Itinerary#isDeprecated <em>Deprecated</em>}</li>
 * </ul>
 * </p>
 *
 * @see tracking.TrackingPackage#getItinerary()
 * @model
 * @generated
 */
public interface Itinerary extends EObject {
	/**
	 * Returns the value of the '<em><b>Legs</b></em>' containment reference list.
	 * The list contents are of type {@link tracking.Leg}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Legs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Legs</em>' containment reference list.
	 * @see tracking.TrackingPackage#getItinerary_Legs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Leg> getLegs();

	/**
	 * Returns the value of the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deprecated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deprecated</em>' attribute.
	 * @see #setDeprecated(boolean)
	 * @see tracking.TrackingPackage#getItinerary_Deprecated()
	 * @model
	 * @generated
	 */
	boolean isDeprecated();

	/**
	 * Sets the value of the '{@link tracking.Itinerary#isDeprecated <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deprecated</em>' attribute.
	 * @see #isDeprecated()
	 * @generated
	 */
	void setDeprecated(boolean value);

} // Itinerary
