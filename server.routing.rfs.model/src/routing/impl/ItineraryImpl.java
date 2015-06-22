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
	protected static final String LAST_TRIP_EDEFAULT = "";
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
		result.append(')');
		return result.toString();
	}

	@Override
	public int isDominated (long arrivalTime, int nbTransfers) {
		int res = 0 ;
		
		if (this.nbTransfers <= nbTransfers) res ++;
		else res -- ;
		if (this.arrivalTime <= arrivalTime) res ++ ;
		else res -- ;
		
		if (res == 2) {
			return 1;
		} else if (res == -2) {
			return -1;
		} else {
			return 0;
		}
	}

} //ItineraryImpl
