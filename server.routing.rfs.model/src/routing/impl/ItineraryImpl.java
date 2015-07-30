/**
 */
package routing.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import common.Request;
import routing.Itinerary;
import routing.Leg;
import routing.RoutingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Itinerary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link routing.impl.ItineraryImpl#getPath <em>Path</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getLastTrip <em>Last Trip</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getDepartureTime <em>Departure Time</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getArrivalTime <em>Arrival Time</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getNbTransfers <em>Nb Transfers</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#isIsOnRightWay <em>Is On Right Way</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getWalkingDistance <em>Walking Distance</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getWaitingTime <em>Waiting Time</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getTrips <em>Trips</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#isDeprecated <em>Deprecated</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItineraryImpl extends MinimalEObjectImpl.Container implements Itinerary {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<Leg> path;

	/**
	 * The default value of the '{@link #getLastTrip() <em>Last Trip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastTrip()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_TRIP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastTrip() <em>Last Trip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastTrip()
	 * @generated
	 * @ordered
	 */
	protected String lastTrip = LAST_TRIP_EDEFAULT;

	/**
	 * The default value of the '{@link #getDepartureTime() <em>Departure Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartureTime()
	 * @generated
	 * @ordered
	 */
	protected static final long DEPARTURE_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDepartureTime() <em>Departure Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepartureTime()
	 * @generated
	 * @ordered
	 */
	protected long departureTime = DEPARTURE_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getArrivalTime() <em>Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected static final long ARRIVAL_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getArrivalTime() <em>Arrival Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivalTime()
	 * @generated
	 * @ordered
	 */
	protected long arrivalTime = ARRIVAL_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNbTransfers() <em>Nb Transfers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbTransfers()
	 * @generated
	 * @ordered
	 */
	protected static final int NB_TRANSFERS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNbTransfers() <em>Nb Transfers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNbTransfers()
	 * @generated
	 * @ordered
	 */
	protected int nbTransfers = NB_TRANSFERS_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOnRightWay() <em>Is On Right Way</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOnRightWay()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ON_RIGHT_WAY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOnRightWay() <em>Is On Right Way</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOnRightWay()
	 * @generated
	 * @ordered
	 */
	protected boolean isOnRightWay = IS_ON_RIGHT_WAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getWalkingDistance() <em>Walking Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWalkingDistance()
	 * @generated
	 * @ordered
	 */
	protected static final double WALKING_DISTANCE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getWalkingDistance() <em>Walking Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWalkingDistance()
	 * @generated
	 * @ordered
	 */
	protected double walkingDistance = WALKING_DISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWaitingTime() <em>Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected static final long WAITING_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getWaitingTime() <em>Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWaitingTime()
	 * @generated
	 * @ordered
	 */
	protected long waitingTime = WAITING_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrips() <em>Trips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrips()
	 * @generated
	 * @ordered
	 */
	protected static final String TRIPS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrips() <em>Trips</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrips()
	 * @generated
	 * @ordered
	 */
	protected String trips = TRIPS_EDEFAULT;

	/**
	 * The default value of the '{@link #isDeprecated() <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPRECATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeprecated() <em>Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected boolean deprecated = DEPRECATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ItineraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RoutingPackage.Literals.ITINERARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Leg> getPath() {
		if (path == null) {
			path = new EObjectResolvingEList<Leg>(Leg.class, this, RoutingPackage.ITINERARY__PATH);
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrivalTime(long newArrivalTime) {
		long oldArrivalTime = arrivalTime;
		arrivalTime = newArrivalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.ITINERARY__ARRIVAL_TIME, oldArrivalTime, arrivalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNbTransfers() {
		return nbTransfers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNbTransfers(int newNbTransfers) {
		int oldNbTransfers = nbTransfers;
		nbTransfers = newNbTransfers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.ITINERARY__NB_TRANSFERS, oldNbTransfers, nbTransfers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLastTrip() {
		return lastTrip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastTrip(String newLastTrip) {
		String oldLastTrip = lastTrip;
		lastTrip = newLastTrip;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.ITINERARY__LAST_TRIP, oldLastTrip, lastTrip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDepartureTime() {
		return departureTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepartureTime(long newDepartureTime) {
		long oldDepartureTime = departureTime;
		departureTime = newDepartureTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.ITINERARY__DEPARTURE_TIME, oldDepartureTime, departureTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getWalkingDistance() {
		return walkingDistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWalkingDistance(double newWalkingDistance) {
		double oldWalkingDistance = walkingDistance;
		walkingDistance = newWalkingDistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.ITINERARY__WALKING_DISTANCE, oldWalkingDistance, walkingDistance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getWaitingTime() {
		return waitingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWaitingTime(long newWaitingTime) {
		long oldWaitingTime = waitingTime;
		waitingTime = newWaitingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.ITINERARY__WAITING_TIME, oldWaitingTime, waitingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOnRightWay() {
		return isOnRightWay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOnRightWay(boolean newIsOnRightWay) {
		boolean oldIsOnRightWay = isOnRightWay;
		isOnRightWay = newIsOnRightWay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.ITINERARY__IS_ON_RIGHT_WAY, oldIsOnRightWay, isOnRightWay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeprecated() {
		return deprecated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeprecated(boolean newDeprecated) {
		boolean oldDeprecated = deprecated;
		deprecated = newDeprecated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.ITINERARY__DEPRECATED, oldDeprecated, deprecated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTrips() {
		return trips;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrips(String newTrips) {
		String oldTrips = trips;
		trips = newTrips;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.ITINERARY__TRIPS, oldTrips, trips));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RoutingPackage.ITINERARY__PATH:
				return getPath();
			case RoutingPackage.ITINERARY__LAST_TRIP:
				return getLastTrip();
			case RoutingPackage.ITINERARY__DEPARTURE_TIME:
				return getDepartureTime();
			case RoutingPackage.ITINERARY__ARRIVAL_TIME:
				return getArrivalTime();
			case RoutingPackage.ITINERARY__NB_TRANSFERS:
				return getNbTransfers();
			case RoutingPackage.ITINERARY__IS_ON_RIGHT_WAY:
				return isIsOnRightWay();
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				return getWalkingDistance();
			case RoutingPackage.ITINERARY__WAITING_TIME:
				return getWaitingTime();
			case RoutingPackage.ITINERARY__TRIPS:
				return getTrips();
			case RoutingPackage.ITINERARY__DEPRECATED:
				return isDeprecated();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RoutingPackage.ITINERARY__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends Leg>)newValue);
				return;
			case RoutingPackage.ITINERARY__LAST_TRIP:
				setLastTrip((String)newValue);
				return;
			case RoutingPackage.ITINERARY__DEPARTURE_TIME:
				setDepartureTime((Long)newValue);
				return;
			case RoutingPackage.ITINERARY__ARRIVAL_TIME:
				setArrivalTime((Long)newValue);
				return;
			case RoutingPackage.ITINERARY__NB_TRANSFERS:
				setNbTransfers((Integer)newValue);
				return;
			case RoutingPackage.ITINERARY__IS_ON_RIGHT_WAY:
				setIsOnRightWay((Boolean)newValue);
				return;
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				setWalkingDistance((Double)newValue);
				return;
			case RoutingPackage.ITINERARY__WAITING_TIME:
				setWaitingTime((Long)newValue);
				return;
			case RoutingPackage.ITINERARY__TRIPS:
				setTrips((String)newValue);
				return;
			case RoutingPackage.ITINERARY__DEPRECATED:
				setDeprecated((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RoutingPackage.ITINERARY__PATH:
				getPath().clear();
				return;
			case RoutingPackage.ITINERARY__LAST_TRIP:
				setLastTrip(LAST_TRIP_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__DEPARTURE_TIME:
				setDepartureTime(DEPARTURE_TIME_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__ARRIVAL_TIME:
				setArrivalTime(ARRIVAL_TIME_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__NB_TRANSFERS:
				setNbTransfers(NB_TRANSFERS_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__IS_ON_RIGHT_WAY:
				setIsOnRightWay(IS_ON_RIGHT_WAY_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				setWalkingDistance(WALKING_DISTANCE_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__WAITING_TIME:
				setWaitingTime(WAITING_TIME_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__TRIPS:
				setTrips(TRIPS_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__DEPRECATED:
				setDeprecated(DEPRECATED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RoutingPackage.ITINERARY__PATH:
				return path != null && !path.isEmpty();
			case RoutingPackage.ITINERARY__LAST_TRIP:
				return LAST_TRIP_EDEFAULT == null ? lastTrip != null : !LAST_TRIP_EDEFAULT.equals(lastTrip);
			case RoutingPackage.ITINERARY__DEPARTURE_TIME:
				return departureTime != DEPARTURE_TIME_EDEFAULT;
			case RoutingPackage.ITINERARY__ARRIVAL_TIME:
				return arrivalTime != ARRIVAL_TIME_EDEFAULT;
			case RoutingPackage.ITINERARY__NB_TRANSFERS:
				return nbTransfers != NB_TRANSFERS_EDEFAULT;
			case RoutingPackage.ITINERARY__IS_ON_RIGHT_WAY:
				return isOnRightWay != IS_ON_RIGHT_WAY_EDEFAULT;
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				return walkingDistance != WALKING_DISTANCE_EDEFAULT;
			case RoutingPackage.ITINERARY__WAITING_TIME:
				return waitingTime != WAITING_TIME_EDEFAULT;
			case RoutingPackage.ITINERARY__TRIPS:
				return TRIPS_EDEFAULT == null ? trips != null : !TRIPS_EDEFAULT.equals(trips);
			case RoutingPackage.ITINERARY__DEPRECATED:
				return deprecated != DEPRECATED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lastTrip: ");
		result.append(lastTrip);
		result.append(", departureTime: ");
		result.append(departureTime);
		result.append(", arrivalTime: ");
		result.append(arrivalTime);
		result.append(", nbTransfers: ");
		result.append(nbTransfers);
		result.append(", isOnRightWay: ");
		result.append(isOnRightWay);
		result.append(", walkingDistance: ");
		result.append(walkingDistance);
		result.append(", waitingTime: ");
		result.append(waitingTime);
		result.append(", trips: ");
		result.append(trips);
		result.append(", deprecated: ");
		result.append(deprecated);
		result.append(')');
		return result.toString();
	}
 
	@Override
	/* Time is a departure time when the itinerary doesn't reach the target and a duration otherwise. 
	 * The function return 1 if the current itinerary dominates the one passed in parameters,
	 * 0 if they're pareto opt, -1 otherwise */
	public int isDominated (Request request, Itinerary it, boolean toTarget) {
				
		int thisIsDominated = 0 ;
		int thisDominates = 0 ;
		
		double walkingDistance = it.getWalkingDistance() ;
		
		String trips = it.getTrips() ;
		if (this.trips.equals(trips)) {
			/* Both the same */
			if (this.walkingDistance <= walkingDistance) return 1;
			else return -1 ;
		} 
		
		int THRESHOLD_WALKING = request.getSignificantGapWalk() ;
		if (this.walkingDistance + THRESHOLD_WALKING < walkingDistance) {
			thisDominates ++;
		} else if (this.walkingDistance > walkingDistance + THRESHOLD_WALKING) {
			thisIsDominated ++;
		}
		
		/* TODO : refactorer en utilisant compare... fonction à simplifier. */
		
		/* TODO : introduire une gradation dans la prise en compte des critères :
			Itinerary of 84 min which starts at 10:32:17 and arrives at 11:56:15 ; walking 1,447 m, waiting for 1 min with 5 transfers
			Itinerary of 67 min which starts at 10:49:17 and arrives at 11:56:15 ; walking 695 m, waiting for 5 min with 3 transfers
			Itinerary of 81 min which starts at 11:06:17 and arrives at 12:27:15 ; walking 245 m, waiting for 6 min with 2 transfers
		 * Le premier itinéraire n'a rien à faire là je pense...
		 */

		long waitingTime = it.getWaitingTime() ;
		int THRESHOLD_WAITING = request.getSignificantGapWait() ;
		if (this.waitingTime + THRESHOLD_WAITING < waitingTime) {
			thisDominates ++;
		} else if (this.waitingTime > waitingTime + THRESHOLD_WAITING) {
			thisIsDominated ++;
		}

		long time ;
		if (toTarget) {
			time = it.getDuration() ;
			int THRESHOLD_DURATION = request.getSignificantGapDuration() ;
			if (this.getDuration() + THRESHOLD_DURATION < time) {
				thisDominates ++;
			} else if (this.getDuration() > time + THRESHOLD_DURATION) {
				thisIsDominated ++;
			}
		}
		else {
			time = it.getDepartureTime() ;
			int THRESHOLD_DEPARTURE = request.getSignificantGapDeparture() ;
			if (this.departureTime + THRESHOLD_DEPARTURE < time) {
				thisIsDominated ++;
			} else if (this.departureTime > time + THRESHOLD_DEPARTURE) {
				thisDominates ++;
			}
		}
				
		/* If we are not already on the right way (we are on a trip that go through the target stop) 
		 * then it means that we need at least one more transfer */
		int nbTransfers = it.getNbTransfers() ; 
		boolean goodWay = it.isIsOnRightWay() ;
		if (this.nbTransfers + (isOnRightWay?0:1) < nbTransfers + (goodWay?0:1)) {
			thisDominates ++;
		} else if (this.nbTransfers + (isOnRightWay?0:1) > nbTransfers + (goodWay?0:1)) {
			thisIsDominated ++ ;
		}

		/* Need a majority */
		if (thisDominates >= 1 && thisIsDominated==0) {
			return 1 ;
		} else if (thisIsDominated >= 1 && thisDominates==0) {
			return -1 ;
		} else {
			return 0; // Pareto Opt
		}
		
	}
	
//	private static int compare (double a, double b, double threshold, boolean smallest) {
//		if (a + threshold < b) {
//			return smallest?1:-1;
//		} else if (a > b + threshold) {
//			return smallest?-1:1;
//		}
//		return 0 ;
//	}

	@Override
	public long getDuration() {
		return arrivalTime - departureTime;
	}


} //ItineraryImpl
