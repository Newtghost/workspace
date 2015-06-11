/**
 */
package tracking;

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
 * @see tracking.TrackingFactory
 * @model kind="package"
 * @generated
 */
public interface TrackingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tracking";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/tracking";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tracking";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TrackingPackage eINSTANCE = tracking.impl.TrackingPackageImpl.init();

	/**
	 * The meta object id for the '{@link tracking.impl.ItineraryImpl <em>Itinerary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tracking.impl.ItineraryImpl
	 * @see tracking.impl.TrackingPackageImpl#getItinerary()
	 * @generated
	 */
	int ITINERARY = 0;

	/**
	 * The feature id for the '<em><b>Legs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY__LEGS = 0;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY__DEPRECATED = 1;

	/**
	 * The number of structural features of the '<em>Itinerary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Itinerary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITINERARY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link tracking.impl.LegImpl <em>Leg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tracking.impl.LegImpl
	 * @see tracking.impl.TrackingPackageImpl#getLeg()
	 * @generated
	 */
	int LEG = 1;

	/**
	 * The feature id for the '<em><b>Trip Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__TRIP_ID = 0;

	/**
	 * The feature id for the '<em><b>Agency Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__AGENCY_ID = 1;

	/**
	 * The feature id for the '<em><b>Route Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__ROUTE_ID = 2;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__FROM = 3;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__TO = 4;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__MODE = 5;

	/**
	 * The feature id for the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__DISTANCE = 6;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__START_TIME = 7;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__END_TIME = 8;

	/**
	 * The feature id for the '<em><b>Arrival Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__ARRIVAL_DELAY = 9;

	/**
	 * The feature id for the '<em><b>Departure Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__DEPARTURE_DELAY = 10;

	/**
	 * The feature id for the '<em><b>From Stop Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__FROM_STOP_SEQUENCE = 11;

	/**
	 * The feature id for the '<em><b>To Stop Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__TO_STOP_SEQUENCE = 12;

	/**
	 * The feature id for the '<em><b>Timezone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__TIMEZONE = 13;

	/**
	 * The number of structural features of the '<em>Leg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_FEATURE_COUNT = 14;

	/**
	 * The number of operations of the '<em>Leg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link tracking.Itinerary <em>Itinerary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Itinerary</em>'.
	 * @see tracking.Itinerary
	 * @generated
	 */
	EClass getItinerary();

	/**
	 * Returns the meta object for the containment reference list '{@link tracking.Itinerary#getLegs <em>Legs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Legs</em>'.
	 * @see tracking.Itinerary#getLegs()
	 * @see #getItinerary()
	 * @generated
	 */
	EReference getItinerary_Legs();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Itinerary#isDeprecated <em>Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecated</em>'.
	 * @see tracking.Itinerary#isDeprecated()
	 * @see #getItinerary()
	 * @generated
	 */
	EAttribute getItinerary_Deprecated();

	/**
	 * Returns the meta object for class '{@link tracking.Leg <em>Leg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leg</em>'.
	 * @see tracking.Leg
	 * @generated
	 */
	EClass getLeg();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getTripId <em>Trip Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trip Id</em>'.
	 * @see tracking.Leg#getTripId()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_TripId();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getAgencyId <em>Agency Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Agency Id</em>'.
	 * @see tracking.Leg#getAgencyId()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_AgencyId();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getRouteId <em>Route Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Route Id</em>'.
	 * @see tracking.Leg#getRouteId()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_RouteId();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see tracking.Leg#getFrom()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_From();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see tracking.Leg#getTo()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_To();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getMode <em>Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mode</em>'.
	 * @see tracking.Leg#getMode()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_Mode();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getDistance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distance</em>'.
	 * @see tracking.Leg#getDistance()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_Distance();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see tracking.Leg#getStartTime()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see tracking.Leg#getEndTime()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getArrivalDelay <em>Arrival Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Arrival Delay</em>'.
	 * @see tracking.Leg#getArrivalDelay()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_ArrivalDelay();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getDepartureDelay <em>Departure Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Departure Delay</em>'.
	 * @see tracking.Leg#getDepartureDelay()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_DepartureDelay();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getFromStopSequence <em>From Stop Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Stop Sequence</em>'.
	 * @see tracking.Leg#getFromStopSequence()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_FromStopSequence();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getToStopSequence <em>To Stop Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Stop Sequence</em>'.
	 * @see tracking.Leg#getToStopSequence()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_ToStopSequence();

	/**
	 * Returns the meta object for the attribute '{@link tracking.Leg#getTimezone <em>Timezone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timezone</em>'.
	 * @see tracking.Leg#getTimezone()
	 * @see #getLeg()
	 * @generated
	 */
	EAttribute getLeg_Timezone();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TrackingFactory getTrackingFactory();

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
		 * The meta object literal for the '{@link tracking.impl.ItineraryImpl <em>Itinerary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tracking.impl.ItineraryImpl
		 * @see tracking.impl.TrackingPackageImpl#getItinerary()
		 * @generated
		 */
		EClass ITINERARY = eINSTANCE.getItinerary();

		/**
		 * The meta object literal for the '<em><b>Legs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITINERARY__LEGS = eINSTANCE.getItinerary_Legs();

		/**
		 * The meta object literal for the '<em><b>Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITINERARY__DEPRECATED = eINSTANCE.getItinerary_Deprecated();

		/**
		 * The meta object literal for the '{@link tracking.impl.LegImpl <em>Leg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tracking.impl.LegImpl
		 * @see tracking.impl.TrackingPackageImpl#getLeg()
		 * @generated
		 */
		EClass LEG = eINSTANCE.getLeg();

		/**
		 * The meta object literal for the '<em><b>Trip Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__TRIP_ID = eINSTANCE.getLeg_TripId();

		/**
		 * The meta object literal for the '<em><b>Agency Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__AGENCY_ID = eINSTANCE.getLeg_AgencyId();

		/**
		 * The meta object literal for the '<em><b>Route Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__ROUTE_ID = eINSTANCE.getLeg_RouteId();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__FROM = eINSTANCE.getLeg_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__TO = eINSTANCE.getLeg_To();

		/**
		 * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__MODE = eINSTANCE.getLeg_Mode();

		/**
		 * The meta object literal for the '<em><b>Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__DISTANCE = eINSTANCE.getLeg_Distance();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__START_TIME = eINSTANCE.getLeg_StartTime();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__END_TIME = eINSTANCE.getLeg_EndTime();

		/**
		 * The meta object literal for the '<em><b>Arrival Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__ARRIVAL_DELAY = eINSTANCE.getLeg_ArrivalDelay();

		/**
		 * The meta object literal for the '<em><b>Departure Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__DEPARTURE_DELAY = eINSTANCE.getLeg_DepartureDelay();

		/**
		 * The meta object literal for the '<em><b>From Stop Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__FROM_STOP_SEQUENCE = eINSTANCE.getLeg_FromStopSequence();

		/**
		 * The meta object literal for the '<em><b>To Stop Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__TO_STOP_SEQUENCE = eINSTANCE.getLeg_ToStopSequence();

		/**
		 * The meta object literal for the '<em><b>Timezone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEG__TIMEZONE = eINSTANCE.getLeg_Timezone();

	}

} //TrackingPackage
