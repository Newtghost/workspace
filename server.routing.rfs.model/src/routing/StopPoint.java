/**
 */
package routing;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stop Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link routing.StopPoint#getStopId <em>Stop Id</em>}</li>
 *   <li>{@link routing.StopPoint#getName <em>Name</em>}</li>
 *   <li>{@link routing.StopPoint#getMinimalConnectionTime <em>Minimal Connection Time</em>}</li>
 *   <li>{@link routing.StopPoint#getBestArrivalTime <em>Best Arrival Time</em>}</li>
 *   <li>{@link routing.StopPoint#getBestArrivalLeg <em>Best Arrival Leg</em>}</li>
 * </ul>
 * </p>
 *
 * @see routing.RoutingPackage#getStopPoint()
 * @model
 * @generated
 */
public interface StopPoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Stop Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Id</em>' attribute.
	 * @see #setStopId(String)
	 * @see routing.RoutingPackage#getStopPoint_StopId()
	 * @model
	 * @generated
	 */
	String getStopId();

	/**
	 * Sets the value of the '{@link routing.StopPoint#getStopId <em>Stop Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Id</em>' attribute.
	 * @see #getStopId()
	 * @generated
	 */
	void setStopId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see routing.RoutingPackage#getStopPoint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link routing.StopPoint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Minimal Connection Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimal Connection Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimal Connection Time</em>' attribute.
	 * @see #setMinimalConnectionTime(int)
	 * @see routing.RoutingPackage#getStopPoint_MinimalConnectionTime()
	 * @model
	 * @generated
	 */
	int getMinimalConnectionTime();

	/**
	 * Sets the value of the '{@link routing.StopPoint#getMinimalConnectionTime <em>Minimal Connection Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimal Connection Time</em>' attribute.
	 * @see #getMinimalConnectionTime()
	 * @generated
	 */
	void setMinimalConnectionTime(int value);

	/**
	 * Returns the value of the '<em><b>Best Arrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Best Arrival Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Best Arrival Time</em>' attribute.
	 * @see #setBestArrivalTime(long)
	 * @see routing.RoutingPackage#getStopPoint_BestArrivalTime()
	 * @model
	 * @generated
	 */
	long getBestArrivalTime();

	/**
	 * Sets the value of the '{@link routing.StopPoint#getBestArrivalTime <em>Best Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Best Arrival Time</em>' attribute.
	 * @see #getBestArrivalTime()
	 * @generated
	 */
	void setBestArrivalTime(long value);

	/**
	 * Returns the value of the '<em><b>Best Arrival Leg</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Best Arrival Leg</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Best Arrival Leg</em>' reference.
	 * @see #setBestArrivalLeg(Leg)
	 * @see routing.RoutingPackage#getStopPoint_BestArrivalLeg()
	 * @model
	 * @generated
	 */
	Leg getBestArrivalLeg();

	/**
	 * Sets the value of the '{@link routing.StopPoint#getBestArrivalLeg <em>Best Arrival Leg</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Best Arrival Leg</em>' reference.
	 * @see #getBestArrivalLeg()
	 * @generated
	 */
	void setBestArrivalLeg(Leg value);

} // StopPoint
