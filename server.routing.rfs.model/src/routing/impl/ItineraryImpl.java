/**
 */
package routing.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import routing.Connection;
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
 *   <li>{@link routing.impl.ItineraryImpl#getWalkingDistance <em>Walking Distance</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#isIsOnRightWay <em>Is On Right Way</em>}</li>
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
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				return getWalkingDistance();
			case RoutingPackage.ITINERARY__IS_ON_RIGHT_WAY:
				return isIsOnRightWay();
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
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				setWalkingDistance((Double)newValue);
				return;
			case RoutingPackage.ITINERARY__IS_ON_RIGHT_WAY:
				setIsOnRightWay((Boolean)newValue);
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
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				setWalkingDistance(WALKING_DISTANCE_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__IS_ON_RIGHT_WAY:
				setIsOnRightWay(IS_ON_RIGHT_WAY_EDEFAULT);
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
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				return walkingDistance != WALKING_DISTANCE_EDEFAULT;
			case RoutingPackage.ITINERARY__IS_ON_RIGHT_WAY:
				return isOnRightWay != IS_ON_RIGHT_WAY_EDEFAULT;
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
		result.append(", walkingDistance: ");
		result.append(walkingDistance);
		result.append(", isOnRightWay: ");
		result.append(isOnRightWay);
		result.append(", deprecated: ");
		result.append(deprecated);
		result.append(')');
		return result.toString();
	}
 
	private static final int THRESHOLD_TRANSFERS = 0 ;
	private static final int THRESHOLD_WALKING = 100 ; /* in meters */
	private static final int THRESHOLD_DEPARTURE = 300 ; /* in seconds */

	@Override
	/* Time is a departure time when the itinerary doesn't reach the target and a duration otherwise. 
	 * The function return 1 if the current itinerary dominates the one passed in parameters,
	 * 0 if they're pareto opt, -1 otherwise */
	public int isDominated (long time, int nbTransfers, double walkingDistance, boolean isTarget, boolean goodWay) {
		int thisIsDominated = 0 ;
		int thisDominates = 0 ;
		
		if (!isTarget) {
			if (this.departureTime + THRESHOLD_DEPARTURE < time) {
				thisIsDominated ++;
			} else if (this.departureTime > time + THRESHOLD_DEPARTURE) {
				thisDominates ++;
			}
		}
		else {
			if (this.getDuration() + THRESHOLD_DEPARTURE < time) {
				thisDominates ++;
			} else if (this.getDuration() > time + THRESHOLD_DEPARTURE) {
				thisIsDominated ++;
			}
		}

		/* If we are not already on the right way (we are on a trip that go through the target stop) 
		 * then it means that we need at least one more transfer */
		if (this.nbTransfers + (isOnRightWay?0:1) + THRESHOLD_TRANSFERS < nbTransfers + (goodWay?0:1)) {
			thisDominates ++;
		} else if (this.nbTransfers + (isOnRightWay?0:1) > nbTransfers + (goodWay?0:1) + THRESHOLD_TRANSFERS) {
			thisIsDominated ++ ;
		}
		
		if (this.walkingDistance + THRESHOLD_WALKING < walkingDistance) {
			thisDominates ++;
		} else if (this.walkingDistance > walkingDistance + THRESHOLD_WALKING) {
			thisIsDominated ++;
		}
				
		if ((thisIsDominated > 0 && thisDominates > 0) || (thisIsDominated == 0 && thisDominates == 0)) {
			return 0; // Pareto Opt
		} else if (thisIsDominated == 0) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	/* Only used at the final step, when we have found all the itineraries, to delete useless itineraries */
	public int compare(Itinerary it) {
		/* Both are pareto opt - check for some differences */
		if (this.nbTransfers != it.getNbTransfers()) return 0 ;
		if (this.departureTime != it.getDepartureTime()) return 0 ;
		if (this.getDuration() != it.getDuration()) return 0 ;

		/* Check how the routes are chained */
		ArrayList<String> routes_this = getRoutesFromPath(path) ; 
		ArrayList<String> routes_it = getRoutesFromPath(it.getPath()) ; 
		if (routes_it.size() != routes_this.size()) return 0 ;
		for (int i = 0 ; i < routes_it.size() ; i++) {
			if (!routes_it.get(i).equals(routes_this.get(i))) return 0 ;
		}

		/* The walking distance is the only thing that differentiate both itineraries */
		if (this.walkingDistance > it.getWalkingDistance()) {
			return -1 ;
		} else {
			return 1 ;
		}
	}

	private ArrayList<String> getRoutesFromPath(List<Leg> path) {
		ArrayList<String> routes = new ArrayList<String>() ;
		String prev = "" ;
		for (Leg l : path) {
			if (l instanceof Connection) {
				String current = ((Connection) l).getRouteId() ;
				if (!current.equals(prev)) {
					prev = current ;
					routes.add(current) ;
				}
			}
		}
		return routes;
	}

	@Override
	public long getDuration() {
		return arrivalTime - departureTime;
	}


} //ItineraryImpl
