/**
 */
package tracking;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tracking.TrackingPackage
 * @generated
 */
public interface TrackingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TrackingFactory eINSTANCE = tracking.impl.TrackingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Itinerary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Itinerary</em>'.
	 * @generated
	 */
	Itinerary createItinerary();

	/**
	 * Returns a new object of class '<em>Leg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Leg</em>'.
	 * @generated
	 */
	Leg createLeg();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TrackingPackage getTrackingPackage();

} //TrackingFactory
