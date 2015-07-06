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
 *   <li>{@link routing.Itinerary#getLastTrip <em>Last Trip</em>}</li>
 *   <li>{@link routing.Itinerary#getDepartureTime <em>Departure Time</em>}</li>
 *   <li>{@link routing.Itinerary#getArrivalTime <em>Arrival Time</em>}</li>
 *   <li>{@link routing.Itinerary#getNbTransfers <em>Nb Transfers</em>}</li>
 *   <li>{@link routing.Itinerary#getWalkingDistance <em>Walking Distance</em>}</li>
 *   <li>{@link routing.Itinerary#isIsOnRightWay <em>Is On Right Way</em>}</li>
 *   <li>{@link routing.Itinerary#isDeprecated <em>Deprecated</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Arrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrival Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrival Time</em>' attribute.
	 * @see #setArrivalTime(long)
	 * @see routing.RoutingPackage#getItinerary_ArrivalTime()
	 * @model
	 * @generated
	 */
	long getArrivalTime();

	/**
	 * Sets the value of the '{@link routing.Itinerary#getArrivalTime <em>Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrival Time</em>' attribute.
	 * @see #getArrivalTime()
	 * @generated
	 */
	void setArrivalTime(long value);

	/**
	 * Returns the value of the '<em><b>Nb Transfers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nb Transfers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nb Transfers</em>' attribute.
	 * @see #setNbTransfers(int)
	 * @see routing.RoutingPackage#getItinerary_NbTransfers()
	 * @model
	 * @generated
	 */
	int getNbTransfers();

	/**
	 * Sets the value of the '{@link routing.Itinerary#getNbTransfers <em>Nb Transfers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nb Transfers</em>' attribute.
	 * @see #getNbTransfers()
	 * @generated
	 */
	void setNbTransfers(int value);

	/**
	 * Returns the value of the '<em><b>Last Trip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Trip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Trip</em>' attribute.
	 * @see #setLastTrip(String)
	 * @see routing.RoutingPackage#getItinerary_LastTrip()
	 * @model
	 * @generated
	 */
	String getLastTrip();

	/**
	 * Sets the value of the '{@link routing.Itinerary#getLastTrip <em>Last Trip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Trip</em>' attribute.
	 * @see #getLastTrip()
	 * @generated
	 */
	void setLastTrip(String value);
	
	/**
	 * Returns the value of the '<em><b>Departure Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Departure Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Departure Time</em>' attribute.
	 * @see #setDepartureTime(long)
	 * @see routing.RoutingPackage#getItinerary_DepartureTime()
	 * @model
	 * @generated
	 */
	long getDepartureTime();

	/**
	 * Sets the value of the '{@link routing.Itinerary#getDepartureTime <em>Departure Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Departure Time</em>' attribute.
	 * @see #getDepartureTime()
	 * @generated
	 */
	void setDepartureTime(long value);

	/**
	 * Returns the value of the '<em><b>Walking Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Walking Distance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Walking Distance</em>' attribute.
	 * @see #setWalkingDistance(double)
	 * @see routing.RoutingPackage#getItinerary_WalkingDistance()
	 * @model
	 * @generated
	 */
	double getWalkingDistance();

	/**
	 * Sets the value of the '{@link routing.Itinerary#getWalkingDistance <em>Walking Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Walking Distance</em>' attribute.
	 * @see #getWalkingDistance()
	 * @generated
	 */
	void setWalkingDistance(double value);

	/**
	 * Returns the value of the '<em><b>Is On Right Way</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is On Right Way</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is On Right Way</em>' attribute.
	 * @see #setIsOnRightWay(boolean)
	 * @see routing.RoutingPackage#getItinerary_IsOnRightWay()
	 * @model
	 * @generated
	 */
	boolean isIsOnRightWay();

	/**
	 * Sets the value of the '{@link routing.Itinerary#isIsOnRightWay <em>Is On Right Way</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is On Right Way</em>' attribute.
	 * @see #isIsOnRightWay()
	 * @generated
	 */
	void setIsOnRightWay(boolean value);

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
	 * @see routing.RoutingPackage#getItinerary_Deprecated()
	 * @model
	 * @generated
	 */
	boolean isDeprecated();

	/**
	 * Sets the value of the '{@link routing.Itinerary#isDeprecated <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deprecated</em>' attribute.
	 * @see #isDeprecated()
	 * @generated
	 */
	void setDeprecated(boolean value);

	public int isDominated (long time, int nbTransfers, double walkingDistance, boolean isTarget, boolean goodWay) ;

	public int compare (Itinerary itinerary);

	long getDuration();


	
} // Itinerary
