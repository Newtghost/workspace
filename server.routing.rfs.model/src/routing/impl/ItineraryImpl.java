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

import routing.Itinerary;
import routing.Leg;
import routing.RoutingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Itinerary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link routing.impl.ItineraryImpl#getPath <em>Path</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getArrivalTime <em>Arrival Time</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getNbTransfers <em>Nb Transfers</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getLastTrip <em>Last Trip</em>}</li>
 *   <li>{@link routing.impl.ItineraryImpl#getWalkingDistance <em>Walking Distance</em>}</li>
 * </ul>
 * </p>
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
	 * The default value of the '{@link #getWalkingDistance() <em>Walking Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWalkingDistance()
	 * @generated
	 * @ordered
	 */
	protected static final Double WALKING_DISTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWalkingDistance() <em>Walking Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWalkingDistance()
	 * @generated
	 * @ordered
	 */
	protected Double walkingDistance = WALKING_DISTANCE_EDEFAULT;

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
	public Double getWalkingDistance() {
		return walkingDistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWalkingDistance(Double newWalkingDistance) {
		Double oldWalkingDistance = walkingDistance;
		walkingDistance = newWalkingDistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RoutingPackage.ITINERARY__WALKING_DISTANCE, oldWalkingDistance, walkingDistance));
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
			case RoutingPackage.ITINERARY__ARRIVAL_TIME:
				return getArrivalTime();
			case RoutingPackage.ITINERARY__NB_TRANSFERS:
				return getNbTransfers();
			case RoutingPackage.ITINERARY__LAST_TRIP:
				return getLastTrip();
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				return getWalkingDistance();
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
			case RoutingPackage.ITINERARY__ARRIVAL_TIME:
				setArrivalTime((Long)newValue);
				return;
			case RoutingPackage.ITINERARY__NB_TRANSFERS:
				setNbTransfers((Integer)newValue);
				return;
			case RoutingPackage.ITINERARY__LAST_TRIP:
				setLastTrip((String)newValue);
				return;
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				setWalkingDistance((Double)newValue);
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
			case RoutingPackage.ITINERARY__ARRIVAL_TIME:
				setArrivalTime(ARRIVAL_TIME_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__NB_TRANSFERS:
				setNbTransfers(NB_TRANSFERS_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__LAST_TRIP:
				setLastTrip(LAST_TRIP_EDEFAULT);
				return;
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				setWalkingDistance(WALKING_DISTANCE_EDEFAULT);
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
			case RoutingPackage.ITINERARY__ARRIVAL_TIME:
				return arrivalTime != ARRIVAL_TIME_EDEFAULT;
			case RoutingPackage.ITINERARY__NB_TRANSFERS:
				return nbTransfers != NB_TRANSFERS_EDEFAULT;
			case RoutingPackage.ITINERARY__LAST_TRIP:
				return LAST_TRIP_EDEFAULT == null ? lastTrip != null : !LAST_TRIP_EDEFAULT.equals(lastTrip);
			case RoutingPackage.ITINERARY__WALKING_DISTANCE:
				return WALKING_DISTANCE_EDEFAULT == null ? walkingDistance != null : !WALKING_DISTANCE_EDEFAULT.equals(walkingDistance);
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
		result.append(" (arrivalTime: ");
		result.append(arrivalTime);
		result.append(", nbTransfers: ");
		result.append(nbTransfers);
		result.append(", lastTrip: ");
		result.append(lastTrip);
		result.append(", walkingDistance: ");
		result.append(walkingDistance);
		result.append(')');
		return result.toString();
	}

	
	private static final int THREASHOLD_TRANSFERS = 0 ;
	private static final int THREASHOLD_ARRIVAL_TIME = 300 ; /* in seconds */
	private static final int THREASHOLD_WALKING = 10 ; /* in meters */

	@Override
	public int isDominated (long arrivalTime, int nbTransfers, double walkingDistance) {
		
		int nbDominated = 0 ;
		int nbDominate = 0 ;
		
		if (this.nbTransfers + THREASHOLD_TRANSFERS < nbTransfers) {
			nbDominate ++;
		} else if (this.nbTransfers > nbTransfers + THREASHOLD_TRANSFERS) {
			nbDominated ++ ;
		}
		
		if (this.walkingDistance + THREASHOLD_WALKING < walkingDistance) {
			nbDominate ++;
		} else if (this.walkingDistance > walkingDistance + THREASHOLD_WALKING) {
			nbDominated ++;
		}
		
		if (nbDominated == 0 && nbDominate == 0) {
			/* If two paths are equivalent, then we prefer to keep the one which arrive the last */
			if (this.arrivalTime + THREASHOLD_ARRIVAL_TIME < arrivalTime) {
				nbDominated ++;
			} else if (this.arrivalTime > arrivalTime + THREASHOLD_ARRIVAL_TIME) {
				nbDominate ++;
			}
		}

		if ((nbDominated > 0 && nbDominate > 0) || (nbDominated == 0 && nbDominate == 0)) {
			return 0; // Pareto Opt
		} else if (nbDominated == 0) {
			return 1;
		} else {
			return -1;
		}
	}

} //ItineraryImpl
