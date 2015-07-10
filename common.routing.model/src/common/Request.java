/**
 */
package common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link common.Request#getTime <em>Time</em>}</li>
 *   <li>{@link common.Request#getDate <em>Date</em>}</li>
 *   <li>{@link common.Request#getFromStopId <em>From Stop Id</em>}</li>
 *   <li>{@link common.Request#getToStopId <em>To Stop Id</em>}</li>
 *   <li>{@link common.Request#getFromLat <em>From Lat</em>}</li>
 *   <li>{@link common.Request#getFromLon <em>From Lon</em>}</li>
 *   <li>{@link common.Request#getToLat <em>To Lat</em>}</li>
 *   <li>{@link common.Request#getToLon <em>To Lon</em>}</li>
 *   <li>{@link common.Request#getMaxWalkDistance <em>Max Walk Distance</em>}</li>
 * </ul>
 * </p>
 *
 * @see common.CommonPackage#getRequest()
 * @model
 * @generated
 */
public interface Request extends EObject {
	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(String)
	 * @see common.CommonPackage#getRequest_Time()
	 * @model
	 * @generated
	 */
	String getTime();

	/**
	 * Sets the value of the '{@link common.Request#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(String)
	 * @see common.CommonPackage#getRequest_Date()
	 * @model
	 * @generated
	 */
	String getDate();

	/**
	 * Sets the value of the '{@link common.Request#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(String value);

	/**
	 * Returns the value of the '<em><b>From Stop Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Stop Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Stop Id</em>' attribute.
	 * @see #setFromStopId(String)
	 * @see common.CommonPackage#getRequest_FromStopId()
	 * @model
	 * @generated
	 */
	String getFromStopId();

	/**
	 * Sets the value of the '{@link common.Request#getFromStopId <em>From Stop Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Stop Id</em>' attribute.
	 * @see #getFromStopId()
	 * @generated
	 */
	void setFromStopId(String value);

	/**
	 * Returns the value of the '<em><b>To Stop Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Stop Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Stop Id</em>' attribute.
	 * @see #setToStopId(String)
	 * @see common.CommonPackage#getRequest_ToStopId()
	 * @model
	 * @generated
	 */
	String getToStopId();

	/**
	 * Sets the value of the '{@link common.Request#getToStopId <em>To Stop Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Stop Id</em>' attribute.
	 * @see #getToStopId()
	 * @generated
	 */
	void setToStopId(String value);

	/**
	 * Returns the value of the '<em><b>From Lat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Lat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Lat</em>' attribute.
	 * @see #setFromLat(double)
	 * @see common.CommonPackage#getRequest_FromLat()
	 * @model
	 * @generated
	 */
	double getFromLat();

	/**
	 * Sets the value of the '{@link common.Request#getFromLat <em>From Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Lat</em>' attribute.
	 * @see #getFromLat()
	 * @generated
	 */
	void setFromLat(double value);

	/**
	 * Returns the value of the '<em><b>From Lon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Lon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Lon</em>' attribute.
	 * @see #setFromLon(double)
	 * @see common.CommonPackage#getRequest_FromLon()
	 * @model
	 * @generated
	 */
	double getFromLon();

	/**
	 * Sets the value of the '{@link common.Request#getFromLon <em>From Lon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Lon</em>' attribute.
	 * @see #getFromLon()
	 * @generated
	 */
	void setFromLon(double value);

	/**
	 * Returns the value of the '<em><b>To Lat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Lat</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Lat</em>' attribute.
	 * @see #setToLat(double)
	 * @see common.CommonPackage#getRequest_ToLat()
	 * @model
	 * @generated
	 */
	double getToLat();

	/**
	 * Sets the value of the '{@link common.Request#getToLat <em>To Lat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Lat</em>' attribute.
	 * @see #getToLat()
	 * @generated
	 */
	void setToLat(double value);

	/**
	 * Returns the value of the '<em><b>To Lon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Lon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Lon</em>' attribute.
	 * @see #setToLon(double)
	 * @see common.CommonPackage#getRequest_ToLon()
	 * @model
	 * @generated
	 */
	double getToLon();

	/**
	 * Sets the value of the '{@link common.Request#getToLon <em>To Lon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Lon</em>' attribute.
	 * @see #getToLon()
	 * @generated
	 */
	void setToLon(double value);

	/**
	 * Returns the value of the '<em><b>Max Walk Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Walk Distance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Walk Distance</em>' attribute.
	 * @see #setMaxWalkDistance(int)
	 * @see common.CommonPackage#getRequest_MaxWalkDistance()
	 * @model
	 * @generated
	 */
	int getMaxWalkDistance();

	/**
	 * Sets the value of the '{@link common.Request#getMaxWalkDistance <em>Max Walk Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Walk Distance</em>' attribute.
	 * @see #getMaxWalkDistance()
	 * @generated
	 */
	void setMaxWalkDistance(int value);

	boolean hasStopsId();

} // Request
