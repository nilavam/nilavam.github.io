import java.util.Collection;
import java.util.LinkedList;

public class Assignment2 {

	/************************* *************************/
	
	/**
	 * @description Main function.
	 */
	public static void main(String[] args) {
		
		Vehicle v1 = new Ship("titanic", 100);
		Vehicle v2 = new Ship("olympic", 20);
		System.out.println(v1.getCapacity());
		
		Traveller t1 = new PremiumSailor("Alice", "A");
		Traveller t2 = new CheapSailor("Bob", "B");
		System.out.println(t1.getMaxCoTravellers());
		
		try {
			t1.canCoTravel(t2);
		} catch(IncomparableTravellersException e) {
			
		}
		
		Collection<Vehicle> vehicles = new LinkedList<Vehicle>();
		vehicles.add(v1);
		vehicles.add(v2);
		
		Collection<Traveller> travellers = new LinkedList<Traveller>();
		travellers.add(t1);
		travellers.add(t2);
		
		System.out.println(TravelUtils.getTypesCount(vehicles));
		try {
			System.out.println(TravelUtils.getVehiclesClassCount(travellers));
		} catch(IncomparableTravellersException e) {
			
		}
	}
}
