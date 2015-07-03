/**
 */
package routing;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Leg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link routing.Leg#getDepartureId <em>Departure Id</em>}</li>
 *   <li>{@link routing.Leg#getArrivalId <em>Arrival Id</em>}</li>
 *   <li>{@link routing.Leg#getTripId <em>Trip Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see routing.RoutingPackage#getLeg()
 * @model
 * @generated
 */
public interface Leg extends EObject {
	/**
	 * Returns the value of the '<em><b>Departure Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Departure Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Departure Id</em>' attribute.
	 * @see #setDepartureId(String)
	 * @see routing.RoutingPackage#getLeg_DepartureId()
	 * @model
	 * @generated
	 */
	String getDepartureId();

	/**
	 * Sets the value of the '{@link routing.Leg#getDepartureId <em>Departure Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Departure Id</em>' attribute.
	 * @see #getDepartureId()
	 * @generated
	 */
	void setDepartureId(String value);

	/**
	 * Returns the value of the '<em><b>Arrival Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrival Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrival Id</em>' attribute.
	 * @see #setArrivalId(String)
	 * @see routing.RoutingPackage#getLeg_ArrivalId()
	 * @model
	 * @generated
	 */
	String getArrivalId();

	/**
	 * Sets the value of the '{@link routing.Leg#getArrivalId <em>Arrival Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrival Id</em>' attribute.
	 * @see #getArrivalId()
	 * @generated
	 */
	void setArrivalId(String value);

	/**
	 * Returns the value of the '<em><b>Trip Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trip Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trip Id</em>' attribute.
	 * @see #setTripId(String)
	 * @see routing.RoutingPackage#getLeg_TripId()
	 * @model
	 * @generated
	 */
	String getTripId();

	/**
	 * Sets the value of the '{@link routing.Leg#getTripId <em>Trip Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trip Id</em>' attribute.
	 * @see #getTripId()
	 * @generated
	 */
	void setTripId(String value);

} // Leg
