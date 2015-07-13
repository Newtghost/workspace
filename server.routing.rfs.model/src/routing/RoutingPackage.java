/**
 */
package routing;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see routing.RoutingFactory
 * @model kind="package"
 * @generated
 */
public interface RoutingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "routing";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/routing";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "routing";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RoutingPackage eINSTANCE = routing.impl.RoutingPackageImpl.init();

	/**
	 * The meta object id for the '{@link routing.impl.SpaceImpl <em>Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see routing.impl.SpaceImpl
	 * @see routing.impl.RoutingPackageImpl#getSpace()
	 * @generated
	 */
	int SPACE = 0;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE__CONNECTIONS = 0;

	/**
	 * The feature id for the '<em><b>Footpaths</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE__FOOTPATHS = 1;

	/**
	 * The feature id for the '<em><b>Stops</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE__STOPS = 2;

	/**
	 * The feature id for the '<em><b>Calendar</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE__CALENDAR = 3;

	/**
	 * The feature id for the '<em><b>Timezone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE__TIMEZONE = 4;

	/**
	 * The number of structural features of the '<em>Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link routing.impl.LegImpl <em>Leg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see routing.impl.LegImpl
	 * @see routing.impl.RoutingPackageImpl#getLeg()
	 * @generated
	 */
	int LEG = 1;

	/**
	 * The feature id for the '<em><b>Departure Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__DEPARTURE_ID = 0;

	/**
	 * The feature id for the '<em><b>Arrival Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__ARRIVAL_ID = 1;

	/**
	 * The feature id for the '<em><b>Trip Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__TRIP_ID = 2;

	/**
	 * The number of structural features of the '<em>Leg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Leg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link routing.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see routing.impl.ConnectionImpl
	 * @see routing.impl.RoutingPackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 2;

	/**
	 * The feature id for the '<em><b>Departure Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DEPARTURE_ID = LEG__DEPARTURE_ID;

	/**
	 * The feature id for the '<em><b>Arrival Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ARRIVAL_ID = LEG__ARRIVAL_ID;

	/**
	 * The feature id for the '<em><b>Trip Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__TRIP_ID = LEG__TRIP_ID;

	/**
	 * The feature id for the '<em><b>Service Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SERVICE_ID = LEG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Route Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ROUTE_ID = LEG_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dep Stop Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DEP_STOP_SEQUENCE = LEG_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Departure Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DEPARTURE_TIME = LEG_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Arr Stop Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ARR_STOP_SEQUENCE = LEG_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Arrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ARRIVAL_TIME = LEG_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Departure Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__DEPARTURE_DELAY = LEG_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Arrival Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ARRIVAL_DELAY = LEG_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Relaxed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__RELAXED = LEG_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Prev C</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__PREV_C = LEG_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = LEG_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_OPERATION_COUNT = LEG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link routing.impl.FootpathImpl <em>Footpath</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see routing.impl.FootpathImpl
	 * @see routing.impl.RoutingPackageImpl#getFootpath()
	 * @generated
	 */
	int FOOTPATH = 3;

	/**
	 * The feature id for the '<em><b>Departure Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTPATH__DEPARTURE_ID = LEG__DEPARTURE_ID;

	/**
	 * The feature id for the '<em><b>Arrival Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTPATH__ARRIVAL_ID = LEG__ARRIVAL_ID;

	/**
	 * The feature id for the '<em><b>Trip Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTPATH__TRIP_ID = LEG__TRIP_ID;

	/**
	 * The feature id for the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTPATH__DISTANCE = LEG_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTPATH__DURATION = LEG_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Footpath</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTPATH_FEATURE_COUNT = LEG_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Footpath</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTPATH_OPERATION_COUNT = LEG_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link routing.impl.StopPointImpl <em>Stop Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see routing.impl.StopPointImpl
	 * @see routing.impl.RoutingPackageImpl#getStopPoint()
	 * @generated
	 */
	int STOP_POINT = 4;

	/**
	 * The feature id for the '<em><b>Stop Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_POINT__STOP_ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_POINT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Minimal Connection Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_POINT__MINIMAL_CONNECTION_TIME = 2;

	/**
	 * The feature id for the '<em><b>Best Journeys</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_POINT__BEST_JOURNEYS = 3;

	/**
	 * The feature id for the '<em><b>Routes Id</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_POINT__ROUTES_ID = 4;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_POINT__LATITUDE = 5;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_POINT__LONGITUDE = 6;

	/**
	 * The number of structural features of the '<em>Stop Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_POINT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Stop Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOP_POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link routing.impl.ItineraryImpl <em>Itinerary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see routing.impl.ItineraryImpl
	 * @see routing.impl.RoutingPackageImpl#getItinerary()
	 * @generated
	 */
	int ITINERARY = 5;

	/**
	 * The feature id for the '<em><b>Path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY__PATH = 0;

	/**
	 * The feature id for the '<em><b>Last Trip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY__LAST_TRIP = 1;

	/**
	 * The feature id for the '<em><b>Departure Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY__DEPARTURE_TIME = 2;

	/**
	 * The feature id for the '<em><b>Arrival Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY__ARRIVAL_TIME = 3;

	/**
	 * The feature id for the '<em><b>Nb Transfers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY__NB_TRANSFERS = 4;

	/**
	 * The feature id for the '<em><b>Walking Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY__WALKING_DISTANCE = 5;

	/**
	 * The feature id for the '<em><b>Is On Right Way</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY__IS_ON_RIGHT_WAY = 6;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY__DEPRECATED = 7;

	/**
	 * The number of structural features of the '<em>Itinerary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Itinerary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link routing.impl.StringToFootpathMapImpl <em>String To Footpath Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see routing.impl.StringToFootpathMapImpl
	 * @see routing.impl.RoutingPackageImpl#getStringToFootpathMap()
	 * @generated
	 */
	int STRING_TO_FOOTPATH_MAP = 6;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_FOOTPATH_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_FOOTPATH_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Footpath Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_FOOTPATH_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Footpath Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_FOOTPATH_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link routing.impl.StringToStopPointMapImpl <em>String To Stop Point Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see routing.impl.StringToStopPointMapImpl
	 * @see routing.impl.RoutingPackageImpl#getStringToStopPointMap()
	 * @generated
	 */
	int STRING_TO_STOP_POINT_MAP = 7;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STOP_POINT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STOP_POINT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Stop Point Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STOP_POINT_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Stop Point Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_STOP_POINT_MAP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link routing.impl.StringToConnectionMapImpl <em>String To Connection Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see routing.impl.StringToConnectionMapImpl
	 * @see routing.impl.RoutingPackageImpl#getStringToConnectionMap()
	 * @generated
	 */
	int STRING_TO_CONNECTION_MAP = 8;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_CONNECTION_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_CONNECTION_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>String To Connection Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_CONNECTION_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>String To Connection Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TO_CONNECTION_MAP_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link routing.impl.DateToStringMapImpl <em>Date To String Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see routing.impl.DateToStringMapImpl
	 * @see routing.impl.RoutingPackageImpl#getDateToStringMap()
	 * @generated
	 */
	int DATE_TO_STRING_MAP = 9;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TO_STRING_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TO_STRING_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Date To String Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TO_STRING_MAP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Date To String Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TO_STRING_MAP_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link routing.Space <em>Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Space</em>'.
	 * @see routing.Space
	 * @generated
	 */
	EClass getSpace();

	/**
	 * Returns the meta object for the map '{@link routing.Space#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Connections</em>'.
	 * @see routing.Space#getConnections()
	 * @see #getSpace()
	 * @generated
	 */
	EReference getSpace_Connections();

	/**
	 * Returns the meta object for the map '{@link routing.Space#getFootpaths <em>Footpaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Footpaths</em>'.
	 * @see routing.Space#getFootpaths()
	 * @see #getSpace()
	 * @generated
	 */
	EReference getSpace_Footpaths();

	/**
	 * Returns the meta object for the map '{@link routing.Space#getStops <em>Stops</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Stops</em>'.
	 * @see routing.Space#getStops()
	 * @see #getSpace()
	 * @generated
	 */
	EReference getSpace_Stops();

	/**
	 * Returns the meta object for the map '{@link routing.Space#getCalendar <em>Calendar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Calendar</em>'.
	 * @see routing.Space#getCalendar()
	 * @see #getSpace()
	 * @generated
	 */
	EReference getSpace_Calendar();

	/**
	 * Returns the meta object for the attribute '{@link routing.Space#getTimezone <em>Timezone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timezone</em>'.
	 * @see routing.Space#getTimezone()
	 * @see #getSpace()
	 * @generated
	 */
	EAttribute getSpace_Timezone();

	/**
	 * Returns the meta object for class '{@link routing.Leg <em>Leg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leg</em>'.
	 * @see routing.Leg
	 * @generated
	 */
	EClass getLeg();

	/**
	 * Returns the meta object for the attribute '{@link routing.Leg#getDepartureId <em>Departure Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Departure Id</em>'.
	 * @see routing.Leg#getDepartureId()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_DepartureId();

	/**
	 * Returns the meta object for the attribute '{@link routing.Leg#getArrivalId <em>Arrival Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arrival Id</em>'.
	 * @see routing.Leg#getArrivalId()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_ArrivalId();

	/**
	 * Returns the meta object for the attribute '{@link routing.Leg#getTripId <em>Trip Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trip Id</em>'.
	 * @see routing.Leg#getTripId()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_TripId();

	/**
	 * Returns the meta object for class '{@link routing.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see routing.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the attribute '{@link routing.Connection#getServiceId <em>Service Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Id</em>'.
	 * @see routing.Connection#getServiceId()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ServiceId();

	/**
	 * Returns the meta object for the attribute '{@link routing.Connection#getRouteId <em>Route Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Route Id</em>'.
	 * @see routing.Connection#getRouteId()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_RouteId();

	/**
	 * Returns the meta object for the attribute '{@link routing.Connection#getDepStopSequence <em>Dep Stop Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dep Stop Sequence</em>'.
	 * @see routing.Connection#getDepStopSequence()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_DepStopSequence();

	/**
	 * Returns the meta object for the attribute '{@link routing.Connection#getDepartureTime <em>Departure Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Departure Time</em>'.
	 * @see routing.Connection#getDepartureTime()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_DepartureTime();

	/**
	 * Returns the meta object for the attribute '{@link routing.Connection#getArrStopSequence <em>Arr Stop Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arr Stop Sequence</em>'.
	 * @see routing.Connection#getArrStopSequence()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ArrStopSequence();

	/**
	 * Returns the meta object for the attribute '{@link routing.Connection#getArrivalTime <em>Arrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arrival Time</em>'.
	 * @see routing.Connection#getArrivalTime()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ArrivalTime();

	/**
	 * Returns the meta object for the attribute '{@link routing.Connection#getDepartureDelay <em>Departure Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Departure Delay</em>'.
	 * @see routing.Connection#getDepartureDelay()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_DepartureDelay();

	/**
	 * Returns the meta object for the attribute '{@link routing.Connection#getArrivalDelay <em>Arrival Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arrival Delay</em>'.
	 * @see routing.Connection#getArrivalDelay()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_ArrivalDelay();

	/**
	 * Returns the meta object for the attribute '{@link routing.Connection#isRelaxed <em>Relaxed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relaxed</em>'.
	 * @see routing.Connection#isRelaxed()
	 * @see #getConnection()
	 * @generated
	 */
	EAttribute getConnection_Relaxed();

	/**
	 * Returns the meta object for the reference '{@link routing.Connection#getPrevC <em>Prev C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prev C</em>'.
	 * @see routing.Connection#getPrevC()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_PrevC();

	/**
	 * Returns the meta object for class '{@link routing.Footpath <em>Footpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Footpath</em>'.
	 * @see routing.Footpath
	 * @generated
	 */
	EClass getFootpath();

	/**
	 * Returns the meta object for the attribute '{@link routing.Footpath#getDistance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distance</em>'.
	 * @see routing.Footpath#getDistance()
	 * @see #getFootpath()
	 * @generated
	 */
	EAttribute getFootpath_Distance();

	/**
	 * Returns the meta object for the attribute '{@link routing.Footpath#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see routing.Footpath#getDuration()
	 * @see #getFootpath()
	 * @generated
	 */
	EAttribute getFootpath_Duration();

	/**
	 * Returns the meta object for class '{@link routing.StopPoint <em>Stop Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stop Point</em>'.
	 * @see routing.StopPoint
	 * @generated
	 */
	EClass getStopPoint();

	/**
	 * Returns the meta object for the attribute '{@link routing.StopPoint#getStopId <em>Stop Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Id</em>'.
	 * @see routing.StopPoint#getStopId()
	 * @see #getStopPoint()
	 * @generated
	 */
	EAttribute getStopPoint_StopId();

	/**
	 * Returns the meta object for the attribute '{@link routing.StopPoint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see routing.StopPoint#getName()
	 * @see #getStopPoint()
	 * @generated
	 */
	EAttribute getStopPoint_Name();

	/**
	 * Returns the meta object for the attribute '{@link routing.StopPoint#getMinimalConnectionTime <em>Minimal Connection Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minimal Connection Time</em>'.
	 * @see routing.StopPoint#getMinimalConnectionTime()
	 * @see #getStopPoint()
	 * @generated
	 */
	EAttribute getStopPoint_MinimalConnectionTime();

	/**
	 * Returns the meta object for the reference list '{@link routing.StopPoint#getBestJourneys <em>Best Journeys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Best Journeys</em>'.
	 * @see routing.StopPoint#getBestJourneys()
	 * @see #getStopPoint()
	 * @generated
	 */
	EReference getStopPoint_BestJourneys();

	/**
	 * Returns the meta object for the attribute list '{@link routing.StopPoint#getRoutesId <em>Routes Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Routes Id</em>'.
	 * @see routing.StopPoint#getRoutesId()
	 * @see #getStopPoint()
	 * @generated
	 */
	EAttribute getStopPoint_RoutesId();

	/**
	 * Returns the meta object for the attribute '{@link routing.StopPoint#getLatitude <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latitude</em>'.
	 * @see routing.StopPoint#getLatitude()
	 * @see #getStopPoint()
	 * @generated
	 */
	EAttribute getStopPoint_Latitude();

	/**
	 * Returns the meta object for the attribute '{@link routing.StopPoint#getLongitude <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Longitude</em>'.
	 * @see routing.StopPoint#getLongitude()
	 * @see #getStopPoint()
	 * @generated
	 */
	EAttribute getStopPoint_Longitude();

	/**
	 * Returns the meta object for class '{@link routing.Itinerary <em>Itinerary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Itinerary</em>'.
	 * @see routing.Itinerary
	 * @generated
	 */
	EClass getItinerary();

	/**
	 * Returns the meta object for the reference list '{@link routing.Itinerary#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Path</em>'.
	 * @see routing.Itinerary#getPath()
	 * @see #getItinerary()
	 * @generated
	 */
	EReference getItinerary_Path();

	/**
	 * Returns the meta object for the attribute '{@link routing.Itinerary#getArrivalTime <em>Arrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arrival Time</em>'.
	 * @see routing.Itinerary#getArrivalTime()
	 * @see #getItinerary()
	 * @generated
	 */
	EAttribute getItinerary_ArrivalTime();

	/**
	 * Returns the meta object for the attribute '{@link routing.Itinerary#getNbTransfers <em>Nb Transfers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nb Transfers</em>'.
	 * @see routing.Itinerary#getNbTransfers()
	 * @see #getItinerary()
	 * @generated
	 */
	EAttribute getItinerary_NbTransfers();

	/**
	 * Returns the meta object for the attribute '{@link routing.Itinerary#getLastTrip <em>Last Trip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Trip</em>'.
	 * @see routing.Itinerary#getLastTrip()
	 * @see #getItinerary()
	 * @generated
	 */
	EAttribute getItinerary_LastTrip();

	/**
	 * Returns the meta object for the attribute '{@link routing.Itinerary#getDepartureTime <em>Departure Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Departure Time</em>'.
	 * @see routing.Itinerary#getDepartureTime()
	 * @see #getItinerary()
	 * @generated
	 */
	EAttribute getItinerary_DepartureTime();

	/**
	 * Returns the meta object for the attribute '{@link routing.Itinerary#getWalkingDistance <em>Walking Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Walking Distance</em>'.
	 * @see routing.Itinerary#getWalkingDistance()
	 * @see #getItinerary()
	 * @generated
	 */
	EAttribute getItinerary_WalkingDistance();

	/**
	 * Returns the meta object for the attribute '{@link routing.Itinerary#isIsOnRightWay <em>Is On Right Way</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is On Right Way</em>'.
	 * @see routing.Itinerary#isIsOnRightWay()
	 * @see #getItinerary()
	 * @generated
	 */
	EAttribute getItinerary_IsOnRightWay();

	/**
	 * Returns the meta object for the attribute '{@link routing.Itinerary#isDeprecated <em>Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecated</em>'.
	 * @see routing.Itinerary#isDeprecated()
	 * @see #getItinerary()
	 * @generated
	 */
	EAttribute getItinerary_Deprecated();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Footpath Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Footpath Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="routing.Footpath" valueContainment="true" valueMany="true"
	 * @generated
	 */
	EClass getStringToFootpathMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToFootpathMap()
	 * @generated
	 */
	EAttribute getStringToFootpathMap_Key();

	/**
	 * Returns the meta object for the containment reference list '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToFootpathMap()
	 * @generated
	 */
	EReference getStringToFootpathMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Stop Point Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Stop Point Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="routing.StopPoint" valueContainment="true"
	 * @generated
	 */
	EClass getStringToStopPointMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStopPointMap()
	 * @generated
	 */
	EAttribute getStringToStopPointMap_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToStopPointMap()
	 * @generated
	 */
	EReference getStringToStopPointMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>String To Connection Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String To Connection Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="routing.Connection" valueContainment="true" valueMany="true"
	 * @generated
	 */
	EClass getStringToConnectionMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToConnectionMap()
	 * @generated
	 */
	EAttribute getStringToConnectionMap_Key();

	/**
	 * Returns the meta object for the containment reference list '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStringToConnectionMap()
	 * @generated
	 */
	EReference getStringToConnectionMap_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Date To String Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date To String Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EString" valueMany="true"
	 * @generated
	 */
	EClass getDateToStringMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getDateToStringMap()
	 * @generated
	 */
	EAttribute getDateToStringMap_Key();

	/**
	 * Returns the meta object for the attribute list '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getDateToStringMap()
	 * @generated
	 */
	EAttribute getDateToStringMap_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RoutingFactory getRoutingFactory();

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
		 * The meta object literal for the '{@link routing.impl.SpaceImpl <em>Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see routing.impl.SpaceImpl
		 * @see routing.impl.RoutingPackageImpl#getSpace()
		 * @generated
		 */
		EClass SPACE = eINSTANCE.getSpace();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE__CONNECTIONS = eINSTANCE.getSpace_Connections();

		/**
		 * The meta object literal for the '<em><b>Footpaths</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE__FOOTPATHS = eINSTANCE.getSpace_Footpaths();

		/**
		 * The meta object literal for the '<em><b>Stops</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE__STOPS = eINSTANCE.getSpace_Stops();

		/**
		 * The meta object literal for the '<em><b>Calendar</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPACE__CALENDAR = eINSTANCE.getSpace_Calendar();

		/**
		 * The meta object literal for the '<em><b>Timezone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPACE__TIMEZONE = eINSTANCE.getSpace_Timezone();

		/**
		 * The meta object literal for the '{@link routing.impl.LegImpl <em>Leg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see routing.impl.LegImpl
		 * @see routing.impl.RoutingPackageImpl#getLeg()
		 * @generated
		 */
		EClass LEG = eINSTANCE.getLeg();

		/**
		 * The meta object literal for the '<em><b>Departure Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__DEPARTURE_ID = eINSTANCE.getLeg_DepartureId();

		/**
		 * The meta object literal for the '<em><b>Arrival Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__ARRIVAL_ID = eINSTANCE.getLeg_ArrivalId();

		/**
		 * The meta object literal for the '<em><b>Trip Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__TRIP_ID = eINSTANCE.getLeg_TripId();

		/**
		 * The meta object literal for the '{@link routing.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see routing.impl.ConnectionImpl
		 * @see routing.impl.RoutingPackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Service Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__SERVICE_ID = eINSTANCE.getConnection_ServiceId();

		/**
		 * The meta object literal for the '<em><b>Route Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__ROUTE_ID = eINSTANCE.getConnection_RouteId();

		/**
		 * The meta object literal for the '<em><b>Dep Stop Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DEP_STOP_SEQUENCE = eINSTANCE.getConnection_DepStopSequence();

		/**
		 * The meta object literal for the '<em><b>Departure Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DEPARTURE_TIME = eINSTANCE.getConnection_DepartureTime();

		/**
		 * The meta object literal for the '<em><b>Arr Stop Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__ARR_STOP_SEQUENCE = eINSTANCE.getConnection_ArrStopSequence();

		/**
		 * The meta object literal for the '<em><b>Arrival Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__ARRIVAL_TIME = eINSTANCE.getConnection_ArrivalTime();

		/**
		 * The meta object literal for the '<em><b>Departure Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__DEPARTURE_DELAY = eINSTANCE.getConnection_DepartureDelay();

		/**
		 * The meta object literal for the '<em><b>Arrival Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__ARRIVAL_DELAY = eINSTANCE.getConnection_ArrivalDelay();

		/**
		 * The meta object literal for the '<em><b>Relaxed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION__RELAXED = eINSTANCE.getConnection_Relaxed();

		/**
		 * The meta object literal for the '<em><b>Prev C</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__PREV_C = eINSTANCE.getConnection_PrevC();

		/**
		 * The meta object literal for the '{@link routing.impl.FootpathImpl <em>Footpath</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see routing.impl.FootpathImpl
		 * @see routing.impl.RoutingPackageImpl#getFootpath()
		 * @generated
		 */
		EClass FOOTPATH = eINSTANCE.getFootpath();

		/**
		 * The meta object literal for the '<em><b>Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOOTPATH__DISTANCE = eINSTANCE.getFootpath_Distance();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOOTPATH__DURATION = eINSTANCE.getFootpath_Duration();

		/**
		 * The meta object literal for the '{@link routing.impl.StopPointImpl <em>Stop Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see routing.impl.StopPointImpl
		 * @see routing.impl.RoutingPackageImpl#getStopPoint()
		 * @generated
		 */
		EClass STOP_POINT = eINSTANCE.getStopPoint();

		/**
		 * The meta object literal for the '<em><b>Stop Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOP_POINT__STOP_ID = eINSTANCE.getStopPoint_StopId();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOP_POINT__NAME = eINSTANCE.getStopPoint_Name();

		/**
		 * The meta object literal for the '<em><b>Minimal Connection Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOP_POINT__MINIMAL_CONNECTION_TIME = eINSTANCE.getStopPoint_MinimalConnectionTime();

		/**
		 * The meta object literal for the '<em><b>Best Journeys</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STOP_POINT__BEST_JOURNEYS = eINSTANCE.getStopPoint_BestJourneys();

		/**
		 * The meta object literal for the '<em><b>Routes Id</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOP_POINT__ROUTES_ID = eINSTANCE.getStopPoint_RoutesId();

		/**
		 * The meta object literal for the '<em><b>Latitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOP_POINT__LATITUDE = eINSTANCE.getStopPoint_Latitude();

		/**
		 * The meta object literal for the '<em><b>Longitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOP_POINT__LONGITUDE = eINSTANCE.getStopPoint_Longitude();

		/**
		 * The meta object literal for the '{@link routing.impl.ItineraryImpl <em>Itinerary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see routing.impl.ItineraryImpl
		 * @see routing.impl.RoutingPackageImpl#getItinerary()
		 * @generated
		 */
		EClass ITINERARY = eINSTANCE.getItinerary();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITINERARY__PATH = eINSTANCE.getItinerary_Path();

		/**
		 * The meta object literal for the '<em><b>Arrival Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITINERARY__ARRIVAL_TIME = eINSTANCE.getItinerary_ArrivalTime();

		/**
		 * The meta object literal for the '<em><b>Nb Transfers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITINERARY__NB_TRANSFERS = eINSTANCE.getItinerary_NbTransfers();

		/**
		 * The meta object literal for the '<em><b>Last Trip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITINERARY__LAST_TRIP = eINSTANCE.getItinerary_LastTrip();

		/**
		 * The meta object literal for the '<em><b>Departure Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITINERARY__DEPARTURE_TIME = eINSTANCE.getItinerary_DepartureTime();

		/**
		 * The meta object literal for the '<em><b>Walking Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITINERARY__WALKING_DISTANCE = eINSTANCE.getItinerary_WalkingDistance();

		/**
		 * The meta object literal for the '<em><b>Is On Right Way</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITINERARY__IS_ON_RIGHT_WAY = eINSTANCE.getItinerary_IsOnRightWay();

		/**
		 * The meta object literal for the '<em><b>Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITINERARY__DEPRECATED = eINSTANCE.getItinerary_Deprecated();

		/**
		 * The meta object literal for the '{@link routing.impl.StringToFootpathMapImpl <em>String To Footpath Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see routing.impl.StringToFootpathMapImpl
		 * @see routing.impl.RoutingPackageImpl#getStringToFootpathMap()
		 * @generated
		 */
		EClass STRING_TO_FOOTPATH_MAP = eINSTANCE.getStringToFootpathMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_FOOTPATH_MAP__KEY = eINSTANCE.getStringToFootpathMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_FOOTPATH_MAP__VALUE = eINSTANCE.getStringToFootpathMap_Value();

		/**
		 * The meta object literal for the '{@link routing.impl.StringToStopPointMapImpl <em>String To Stop Point Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see routing.impl.StringToStopPointMapImpl
		 * @see routing.impl.RoutingPackageImpl#getStringToStopPointMap()
		 * @generated
		 */
		EClass STRING_TO_STOP_POINT_MAP = eINSTANCE.getStringToStopPointMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_STOP_POINT_MAP__KEY = eINSTANCE.getStringToStopPointMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_STOP_POINT_MAP__VALUE = eINSTANCE.getStringToStopPointMap_Value();

		/**
		 * The meta object literal for the '{@link routing.impl.StringToConnectionMapImpl <em>String To Connection Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see routing.impl.StringToConnectionMapImpl
		 * @see routing.impl.RoutingPackageImpl#getStringToConnectionMap()
		 * @generated
		 */
		EClass STRING_TO_CONNECTION_MAP = eINSTANCE.getStringToConnectionMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TO_CONNECTION_MAP__KEY = eINSTANCE.getStringToConnectionMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TO_CONNECTION_MAP__VALUE = eINSTANCE.getStringToConnectionMap_Value();

		/**
		 * The meta object literal for the '{@link routing.impl.DateToStringMapImpl <em>Date To String Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see routing.impl.DateToStringMapImpl
		 * @see routing.impl.RoutingPackageImpl#getDateToStringMap()
		 * @generated
		 */
		EClass DATE_TO_STRING_MAP = eINSTANCE.getDateToStringMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_TO_STRING_MAP__KEY = eINSTANCE.getDateToStringMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_TO_STRING_MAP__VALUE = eINSTANCE.getDateToStringMap_Value();

	}

} //RoutingPackage
