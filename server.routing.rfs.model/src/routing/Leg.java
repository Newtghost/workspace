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
 * </p>
 * <ul>
 *   <li>{@link routing.Leg#getDepartureId <em>Departure Id</em>}</li>
 *   <li>{@link routing.Leg#getArrivalId <em>Arrival Id</em>}</li>
 *   <li>{@link routing.Leg#getTripId <em>Trip Id</em>}</li>
 *   <li>{@link routing.Leg#getAgencyTimeZoneOffset <em>Agency Time Zone Offset</em>}</li>
 * </ul>
 *
 * @see routing.RoutingPackage#getLeg()
 * @model
 * @generated
 */
public interface Leg extends EObject {

	public static final double WALKING_SPEED = 1.2; /* meter per second */
	public static final double CONNECTION_THRESHOLD = 500;

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

	/**
	 * Returns the value of the '<em><b>Agency Time Zone Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agency Time Zone Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agency Time Zone Offset</em>' attribute.
	 * @see #setAgencyTimeZoneOffset(long)
	 * @see routing.RoutingPackage#getLeg_AgencyTimeZoneOffset()
	 * @model
	 * @generated
	 */
	long getAgencyTimeZoneOffset();

	/**
	 * Sets the value of the '{@link routing.Leg#getAgencyTimeZoneOffset <em>Agency Time Zone Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agency Time Zone Offset</em>' attribute.
	 * @see #getAgencyTimeZoneOffset()
	 * @generated
	 */
	void setAgencyTimeZoneOffset(long value);
	
	public static double gps2m (double lat_a, double lng_a, double lat_b, double lng_b) {
	    double pk = 180 / Math.PI;

	    double a1 = lat_a / pk;
	    double a2 = lng_a / pk;
	    double b1 = lat_b / pk;
	    double b2 = lng_b / pk;

	    double t1 = Math.cos(a1)*Math.cos(a2)*Math.cos(b1)*Math.cos(b2);
	    double t2 = Math.cos(a1)*Math.sin(a2)*Math.cos(b1)*Math.sin(b2);
	    double t3 = Math.sin(a1)*Math.sin(b1);
	    double tt = Math.acos(t1 + t2 + t3);
	   
	    return 6366000 * tt;
	}
	
	public static boolean isConnectionPossible (double lat_a, double lon_a, double lat_b, double lon_b) {
		return gps2m(lat_a, lon_a, lat_b, lon_b) < CONNECTION_THRESHOLD ;
	}


} // Leg
