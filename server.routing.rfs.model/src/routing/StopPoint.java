/**
 */
package routing;

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link routing.StopPoint#getBestJourneys <em>Best Journeys</em>}</li>
 *   <li>{@link routing.StopPoint#getRoutesId <em>Routes Id</em>}</li>
 *   <li>{@link routing.StopPoint#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link routing.StopPoint#getLongitude <em>Longitude</em>}</li>
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
	 * Returns the value of the '<em><b>Best Journeys</b></em>' reference list.
	 * The list contents are of type {@link routing.Itinerary}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Best Journeys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Best Journeys</em>' reference list.
	 * @see routing.RoutingPackage#getStopPoint_BestJourneys()
	 * @model
	 * @generated
	 */
	EList<Itinerary> getBestJourneys();

	/**
	 * Returns the value of the '<em><b>Routes Id</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routes Id</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routes Id</em>' attribute list.
	 * @see routing.RoutingPackage#getStopPoint_RoutesId()
	 * @model
	 * @generated
	 */
	EList<String> getRoutesId();

	/**
	 * Returns the value of the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude</em>' attribute.
	 * @see #setLatitude(double)
	 * @see routing.RoutingPackage#getStopPoint_Latitude()
	 * @model
	 * @generated
	 */
	double getLatitude();

	/**
	 * Sets the value of the '{@link routing.StopPoint#getLatitude <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude</em>' attribute.
	 * @see #getLatitude()
	 * @generated
	 */
	void setLatitude(double value);

	/**
	 * Returns the value of the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude</em>' attribute.
	 * @see #setLongitude(double)
	 * @see routing.RoutingPackage#getStopPoint_Longitude()
	 * @model
	 * @generated
	 */
	double getLongitude();

	/**
	 * Sets the value of the '{@link routing.StopPoint#getLongitude <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude</em>' attribute.
	 * @see #getLongitude()
	 * @generated
	 */
	void setLongitude(double value);

	long getBestArrivalTime();

} // StopPoint
