/**
 */
package common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "common";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/common";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "common";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CommonPackage eINSTANCE = common.impl.CommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link common.impl.RequestImpl <em>Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see common.impl.RequestImpl
	 * @see common.impl.CommonPackageImpl#getRequest()
	 * @generated
	 */
	int REQUEST = 0;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__TIME = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__DATE = 1;

	/**
	 * The feature id for the '<em><b>From Stop Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__FROM_STOP_ID = 2;

	/**
	 * The feature id for the '<em><b>To Stop Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__TO_STOP_ID = 3;

	/**
	 * The feature id for the '<em><b>From Lat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__FROM_LAT = 4;

	/**
	 * The feature id for the '<em><b>From Lon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__FROM_LON = 5;

	/**
	 * The feature id for the '<em><b>To Lat</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__TO_LAT = 6;

	/**
	 * The feature id for the '<em><b>To Lon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__TO_LON = 7;

	/**
	 * The feature id for the '<em><b>Banned Routes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__BANNED_ROUTES = 8;

	/**
	 * The feature id for the '<em><b>Maximum Walk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__MAXIMUM_WALK = 9;

	/**
	 * The feature id for the '<em><b>Maximum Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__MAXIMUM_WAIT = 10;

	/**
	 * The feature id for the '<em><b>Significant Gap Walk</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__SIGNIFICANT_GAP_WALK = 11;

	/**
	 * The feature id for the '<em><b>Significant Gap Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__SIGNIFICANT_GAP_WAIT = 12;

	/**
	 * The feature id for the '<em><b>Significant Gap Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__SIGNIFICANT_GAP_DURATION = 13;

	/**
	 * The feature id for the '<em><b>Significant Gap Departure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST__SIGNIFICANT_GAP_DEPARTURE = 14;

	/**
	 * The number of structural features of the '<em>Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_FEATURE_COUNT = 15;

	/**
	 * The number of operations of the '<em>Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link common.Request <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request</em>'.
	 * @see common.Request
	 * @generated
	 */
	EClass getRequest();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see common.Request#getTime()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_Time();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see common.Request#getDate()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_Date();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getFromStopId <em>From Stop Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Stop Id</em>'.
	 * @see common.Request#getFromStopId()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_FromStopId();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getToStopId <em>To Stop Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Stop Id</em>'.
	 * @see common.Request#getToStopId()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_ToStopId();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getFromLat <em>From Lat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Lat</em>'.
	 * @see common.Request#getFromLat()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_FromLat();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getFromLon <em>From Lon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Lon</em>'.
	 * @see common.Request#getFromLon()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_FromLon();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getToLat <em>To Lat</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Lat</em>'.
	 * @see common.Request#getToLat()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_ToLat();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getToLon <em>To Lon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Lon</em>'.
	 * @see common.Request#getToLon()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_ToLon();

	/**
	 * Returns the meta object for the attribute list '{@link common.Request#getBannedRoutes <em>Banned Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Banned Routes</em>'.
	 * @see common.Request#getBannedRoutes()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_BannedRoutes();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getMaximumWalk <em>Maximum Walk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Walk</em>'.
	 * @see common.Request#getMaximumWalk()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_MaximumWalk();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getMaximumWait <em>Maximum Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maximum Wait</em>'.
	 * @see common.Request#getMaximumWait()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_MaximumWait();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getSignificantGapWalk <em>Significant Gap Walk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Significant Gap Walk</em>'.
	 * @see common.Request#getSignificantGapWalk()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_SignificantGapWalk();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getSignificantGapWait <em>Significant Gap Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Significant Gap Wait</em>'.
	 * @see common.Request#getSignificantGapWait()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_SignificantGapWait();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getSignificantGapDuration <em>Significant Gap Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Significant Gap Duration</em>'.
	 * @see common.Request#getSignificantGapDuration()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_SignificantGapDuration();

	/**
	 * Returns the meta object for the attribute '{@link common.Request#getSignificantGapDeparture <em>Significant Gap Departure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Significant Gap Departure</em>'.
	 * @see common.Request#getSignificantGapDeparture()
	 * @see #getRequest()
	 * @generated
	 */
	EAttribute getRequest_SignificantGapDeparture();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CommonFactory getCommonFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link common.impl.RequestImpl <em>Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see common.impl.RequestImpl
		 * @see common.impl.CommonPackageImpl#getRequest()
		 * @generated
		 */
		EClass REQUEST = eINSTANCE.getRequest();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__TIME = eINSTANCE.getRequest_Time();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__DATE = eINSTANCE.getRequest_Date();

		/**
		 * The meta object literal for the '<em><b>From Stop Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__FROM_STOP_ID = eINSTANCE.getRequest_FromStopId();

		/**
		 * The meta object literal for the '<em><b>To Stop Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__TO_STOP_ID = eINSTANCE.getRequest_ToStopId();

		/**
		 * The meta object literal for the '<em><b>From Lat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__FROM_LAT = eINSTANCE.getRequest_FromLat();

		/**
		 * The meta object literal for the '<em><b>From Lon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__FROM_LON = eINSTANCE.getRequest_FromLon();

		/**
		 * The meta object literal for the '<em><b>To Lat</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__TO_LAT = eINSTANCE.getRequest_ToLat();

		/**
		 * The meta object literal for the '<em><b>To Lon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__TO_LON = eINSTANCE.getRequest_ToLon();

		/**
		 * The meta object literal for the '<em><b>Banned Routes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__BANNED_ROUTES = eINSTANCE.getRequest_BannedRoutes();

		/**
		 * The meta object literal for the '<em><b>Maximum Walk</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__MAXIMUM_WALK = eINSTANCE.getRequest_MaximumWalk();

		/**
		 * The meta object literal for the '<em><b>Maximum Wait</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__MAXIMUM_WAIT = eINSTANCE.getRequest_MaximumWait();

		/**
		 * The meta object literal for the '<em><b>Significant Gap Walk</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__SIGNIFICANT_GAP_WALK = eINSTANCE.getRequest_SignificantGapWalk();

		/**
		 * The meta object literal for the '<em><b>Significant Gap Wait</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__SIGNIFICANT_GAP_WAIT = eINSTANCE.getRequest_SignificantGapWait();

		/**
		 * The meta object literal for the '<em><b>Significant Gap Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__SIGNIFICANT_GAP_DURATION = eINSTANCE.getRequest_SignificantGapDuration();

		/**
		 * The meta object literal for the '<em><b>Significant Gap Departure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST__SIGNIFICANT_GAP_DEPARTURE = eINSTANCE.getRequest_SignificantGapDeparture();

	}

} //CommonPackage
