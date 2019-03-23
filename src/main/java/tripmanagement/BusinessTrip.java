package tripmanagement;

public class BusinessTrip extends Trip {
	
	public BusinessTrip(String id) {
		super(id);
	}

	@Override
	public boolean addTraveler(Traveler traveler) {
		if (traveler.isVip()) {
			return travelersList.add(traveler);
		}
		return false;
	}

	@Override
	public boolean removeTraveler(Traveler traveler) {
		return false;
	}

}
