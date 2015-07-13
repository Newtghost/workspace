/**
 */
package routing.impl;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import routing.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RoutingFactoryImpl extends EFactoryImpl implements RoutingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RoutingFactory init() {
		try {
			RoutingFactory theRoutingFactory = (RoutingFactory)EPackage.Registry.INSTANCE.getEFactory(RoutingPackage.eNS_URI);
			if (theRoutingFactory != null) {
				return theRoutingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RoutingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoutingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RoutingPackage.SPACE: return createSpace();
			case RoutingPackage.LEG: return createLeg();
			case RoutingPackage.CONNECTION: return createConnection();
			case RoutingPackage.FOOTPATH: return createFootpath();
			case RoutingPackage.STOP_POINT: return createStopPoint();
			case RoutingPackage.ITINERARY: return createItinerary();
			case RoutingPackage.STRING_TO_FOOTPATH_MAP: return (EObject)createStringToFootpathMap();
			case RoutingPackage.STRING_TO_STOP_POINT_MAP: return (EObject)createStringToStopPointMap();
			case RoutingPackage.STRING_TO_CONNECTION_MAP: return (EObject)createStringToConnectionMap();
			case RoutingPackage.DATE_TO_STRING_MAP: return (EObject)createDateToStringMap();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Space createSpace() {
		SpaceImpl space = new SpaceImpl();
		return space;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Leg createLeg() {
		LegImpl leg = new LegImpl();
		return leg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Footpath createFootpath() {
		FootpathImpl footpath = new FootpathImpl();
		return footpath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StopPoint createStopPoint() {
		StopPointImpl stopPoint = new StopPointImpl();
		return stopPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Itinerary createItinerary() {
		ItineraryImpl itinerary = new ItineraryImpl();
		return itinerary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EList<Footpath>> createStringToFootpathMap() {
		StringToFootpathMapImpl stringToFootpathMap = new StringToFootpathMapImpl();
		return stringToFootpathMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, StopPoint> createStringToStopPointMap() {
		StringToStopPointMapImpl stringToStopPointMap = new StringToStopPointMapImpl();
		return stringToStopPointMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EList<Connection>> createStringToConnectionMap() {
		StringToConnectionMapImpl stringToConnectionMap = new StringToConnectionMapImpl();
		return stringToConnectionMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EList<String>> createDateToStringMap() {
		DateToStringMapImpl dateToStringMap = new DateToStringMapImpl();
		return dateToStringMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoutingPackage getRoutingPackage() {
		return (RoutingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RoutingPackage getPackage() {
		return RoutingPackage.eINSTANCE;
	}

} //RoutingFactoryImpl
