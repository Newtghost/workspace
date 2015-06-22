/**
 */
package routing;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link routing.Connection#getServiceId <em>Service Id</em>}</li>
 *   <li>{@link routing.Connection#getTripId <em>Trip Id</em>}</li>
 *   <li>{@link routing.Connection#getDepStopSequence <em>Dep Stop Sequence</em>}</li>
 *   <li>{@link routing.Connection#getDepartureTime <em>Departure Time</em>}</li>
 *   <li>{@link routing.Connection#getArrStopSequence <em>Arr Stop Sequence</em>}</li>
 *   <li>{@link routing.Connection#getArrivalTime <em>Arrival Time</em>}</li>
 *   <li>{@link routing.Connection#isRelaxed <em>Relaxed</em>}</li>
 *   <li>{@link routing.Connection#getPrevC <em>Prev C</em>}</li>
 * </ul>
 * </p>
 *
 * @see routing.RoutingPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends Leg, Comparable<Connection> {
	/**
	 * Returns the value of the '<em><b>Service Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Id</em>' attribute.
	 * @see #setServiceId(String)
	 * @see routing.RoutingPackage#getConnection_ServiceId()
	 * @model
	 * @generated
	 */
	String getServiceId();

	/**
	 * Sets the value of the '{@link routing.Connection#getServiceId <em>Service Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Id</em>' attribute.
	 * @see #getServiceId()
	 * @generated
	 */
	void setServiceId(String value);

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
	 * @see routing.RoutingPackage#getConnection_TripId()
	 * @model
	 * @generated
	 */
	String getTripId();

	/**
	 * Sets the value of the '{@link routing.Connection#getTripId <em>Trip Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trip Id</em>' attribute.
	 * @see #getTripId()
	 * @generated
	 */
	void setTripId(String value);

	/**
	 * Returns the value of the '<em><b>Dep Stop Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dep Stop Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dep Stop Sequence</em>' attribute.
	 * @see #setDepStopSequence(int)
	 * @see routing.RoutingPackage#getConnection_DepStopSequence()
	 * @model
	 * @generated
	 */
	int getDepStopSequence();

	/**
	 * Sets the value of the '{@link routing.Connection#getDepStopSequence <em>Dep Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dep Stop Sequence</em>' attribute.
	 * @see #getDepStopSequence()
	 * @generated
	 */
	void setDepStopSequence(int value);

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
	 * @see routing.RoutingPackage#getConnection_DepartureTime()
	 * @model
	 * @generated
	 */
	long getDepartureTime();

	/**
	 * Sets the value of the '{@link routing.Connection#getDepartureTime <em>Departure Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Departure Time</em>' attribute.
	 * @see #getDepartureTime()
	 * @generated
	 */
	void setDepartureTime(long value);

	/**
	 * Returns the value of the '<em><b>Arr Stop Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arr Stop Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arr Stop Sequence</em>' attribute.
	 * @see #setArrStopSequence(int)
	 * @see routing.RoutingPackage#getConnection_ArrStopSequence()
	 * @model
	 * @generated
	 */
	int getArrStopSequence();

	/**
	 * Sets the value of the '{@link routing.Connection#getArrStopSequence <em>Arr Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arr Stop Sequence</em>' attribute.
	 * @see #getArrStopSequence()
	 * @generated
	 */
	void setArrStopSequence(int value);

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
	 * @see routing.RoutingPackage#getConnection_ArrivalTime()
	 * @model
	 * @generated
	 */
	long getArrivalTime();

	/**
	 * Sets the value of the '{@link routing.Connection#getArrivalTime <em>Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrival Time</em>' attribute.
	 * @see #getArrivalTime()
	 * @generated
	 */
	void setArrivalTime(long value);

	/**
	 * Returns the value of the '<em><b>Relaxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relaxed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relaxed</em>' attribute.
	 * @see #setRelaxed(boolean)
	 * @see routing.RoutingPackage#getConnection_Relaxed()
	 * @model
	 * @generated
	 */
	boolean isRelaxed();

	/**
	 * Sets the value of the '{@link routing.Connection#isRelaxed <em>Relaxed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relaxed</em>' attribute.
	 * @see #isRelaxed()
	 * @generated
	 */
	void setRelaxed(boolean value);

	/**
	 * Returns the value of the '<em><b>Prev C</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prev C</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prev C</em>' reference.
	 * @see #setPrevC(Connection)
	 * @see routing.RoutingPackage#getConnection_PrevC()
	 * @model
	 * @generated
	 */
	Connection getPrevC();

	/**
	 * Sets the value of the '{@link routing.Connection#getPrevC <em>Prev C</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prev C</em>' reference.
	 * @see #getPrevC()
	 * @generated
	 */
	void setPrevC(Connection value);

} // Connection
