/**
 */
package tracking;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Leg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tracking.Leg#getTripId <em>Trip Id</em>}</li>
 *   <li>{@link tracking.Leg#getAgencyId <em>Agency Id</em>}</li>
 *   <li>{@link tracking.Leg#getRouteId <em>Route Id</em>}</li>
 *   <li>{@link tracking.Leg#getFrom <em>From</em>}</li>
 *   <li>{@link tracking.Leg#getTo <em>To</em>}</li>
 *   <li>{@link tracking.Leg#getMode <em>Mode</em>}</li>
 *   <li>{@link tracking.Leg#getDistance <em>Distance</em>}</li>
 *   <li>{@link tracking.Leg#getStartTime <em>Start Time</em>}</li>
 *   <li>{@link tracking.Leg#getEndTime <em>End Time</em>}</li>
 *   <li>{@link tracking.Leg#getArrivalDelay <em>Arrival Delay</em>}</li>
 *   <li>{@link tracking.Leg#getDepartureDelay <em>Departure Delay</em>}</li>
 *   <li>{@link tracking.Leg#getFromStopSequence <em>From Stop Sequence</em>}</li>
 *   <li>{@link tracking.Leg#getToStopSequence <em>To Stop Sequence</em>}</li>
 *   <li>{@link tracking.Leg#getTimezone <em>Timezone</em>}</li>
 * </ul>
 * </p>
 *
 * @see tracking.TrackingPackage#getLeg()
 * @model
 * @generated
 */
public interface Leg extends EObject {
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
	 * @see tracking.TrackingPackage#getLeg_TripId()
	 * @model
	 * @generated
	 */
	String getTripId();

	/**
	 * Sets the value of the '{@link tracking.Leg#getTripId <em>Trip Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trip Id</em>' attribute.
	 * @see #getTripId()
	 * @generated
	 */
	void setTripId(String value);

	/**
	 * Returns the value of the '<em><b>Agency Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agency Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agency Id</em>' attribute.
	 * @see #setAgencyId(String)
	 * @see tracking.TrackingPackage#getLeg_AgencyId()
	 * @model
	 * @generated
	 */
	String getAgencyId();

	/**
	 * Sets the value of the '{@link tracking.Leg#getAgencyId <em>Agency Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agency Id</em>' attribute.
	 * @see #getAgencyId()
	 * @generated
	 */
	void setAgencyId(String value);

	/**
	 * Returns the value of the '<em><b>Route Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Route Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Route Id</em>' attribute.
	 * @see #setRouteId(String)
	 * @see tracking.TrackingPackage#getLeg_RouteId()
	 * @model
	 * @generated
	 */
	String getRouteId();

	/**
	 * Sets the value of the '{@link tracking.Leg#getRouteId <em>Route Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Route Id</em>' attribute.
	 * @see #getRouteId()
	 * @generated
	 */
	void setRouteId(String value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' attribute.
	 * @see #setFrom(String)
	 * @see tracking.TrackingPackage#getLeg_From()
	 * @model
	 * @generated
	 */
	String getFrom();

	/**
	 * Sets the value of the '{@link tracking.Leg#getFrom <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' attribute.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(String value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' attribute.
	 * @see #setTo(String)
	 * @see tracking.TrackingPackage#getLeg_To()
	 * @model
	 * @generated
	 */
	String getTo();

	/**
	 * Sets the value of the '{@link tracking.Leg#getTo <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' attribute.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(String value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see tracking.TrackingPackage#getLeg_Mode()
	 * @model
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link tracking.Leg#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

	/**
	 * Returns the value of the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distance</em>' attribute.
	 * @see #setDistance(double)
	 * @see tracking.TrackingPackage#getLeg_Distance()
	 * @model
	 * @generated
	 */
	double getDistance();

	/**
	 * Sets the value of the '{@link tracking.Leg#getDistance <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distance</em>' attribute.
	 * @see #getDistance()
	 * @generated
	 */
	void setDistance(double value);

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(long)
	 * @see tracking.TrackingPackage#getLeg_StartTime()
	 * @model
	 * @generated
	 */
	long getStartTime();

	/**
	 * Sets the value of the '{@link tracking.Leg#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(long value);

	/**
	 * Returns the value of the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Time</em>' attribute.
	 * @see #setEndTime(long)
	 * @see tracking.TrackingPackage#getLeg_EndTime()
	 * @model
	 * @generated
	 */
	long getEndTime();

	/**
	 * Sets the value of the '{@link tracking.Leg#getEndTime <em>End Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Time</em>' attribute.
	 * @see #getEndTime()
	 * @generated
	 */
	void setEndTime(long value);

	/**
	 * Returns the value of the '<em><b>Arrival Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arrival Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arrival Delay</em>' attribute.
	 * @see #setArrivalDelay(int)
	 * @see tracking.TrackingPackage#getLeg_ArrivalDelay()
	 * @model
	 * @generated
	 */
	int getArrivalDelay();

	/**
	 * Sets the value of the '{@link tracking.Leg#getArrivalDelay <em>Arrival Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arrival Delay</em>' attribute.
	 * @see #getArrivalDelay()
	 * @generated
	 */
	void setArrivalDelay(int value);

	/**
	 * Returns the value of the '<em><b>Departure Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Departure Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Departure Delay</em>' attribute.
	 * @see #setDepartureDelay(int)
	 * @see tracking.TrackingPackage#getLeg_DepartureDelay()
	 * @model
	 * @generated
	 */
	int getDepartureDelay();

	/**
	 * Sets the value of the '{@link tracking.Leg#getDepartureDelay <em>Departure Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Departure Delay</em>' attribute.
	 * @see #getDepartureDelay()
	 * @generated
	 */
	void setDepartureDelay(int value);

	/**
	 * Returns the value of the '<em><b>From Stop Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Stop Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Stop Sequence</em>' attribute.
	 * @see #setFromStopSequence(int)
	 * @see tracking.TrackingPackage#getLeg_FromStopSequence()
	 * @model
	 * @generated
	 */
	int getFromStopSequence();

	/**
	 * Sets the value of the '{@link tracking.Leg#getFromStopSequence <em>From Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Stop Sequence</em>' attribute.
	 * @see #getFromStopSequence()
	 * @generated
	 */
	void setFromStopSequence(int value);

	/**
	 * Returns the value of the '<em><b>To Stop Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Stop Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Stop Sequence</em>' attribute.
	 * @see #setToStopSequence(int)
	 * @see tracking.TrackingPackage#getLeg_ToStopSequence()
	 * @model
	 * @generated
	 */
	int getToStopSequence();

	/**
	 * Sets the value of the '{@link tracking.Leg#getToStopSequence <em>To Stop Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Stop Sequence</em>' attribute.
	 * @see #getToStopSequence()
	 * @generated
	 */
	void setToStopSequence(int value);

	/**
	 * Returns the value of the '<em><b>Timezone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timezone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timezone</em>' attribute.
	 * @see #setTimezone(String)
	 * @see tracking.TrackingPackage#getLeg_Timezone()
	 * @model
	 * @generated
	 */
	String getTimezone();

	/**
	 * Sets the value of the '{@link tracking.Leg#getTimezone <em>Timezone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timezone</em>' attribute.
	 * @see #getTimezone()
	 * @generated
	 */
	void setTimezone(String value);

} // Leg
