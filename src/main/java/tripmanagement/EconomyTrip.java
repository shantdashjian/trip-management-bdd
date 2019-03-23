package tripmanagement;

public class EconomyTrip extends Trip {

	public EconomyTrip(String id) {
		super(id);
	}

	@Override
	public boolean addTraveler(Traveler traveler) {
		return travelersList.add(traveler);
	}

	@Override
	public boolean removeTraveler(Traveler traveler) {
		if (!traveler.isVip()) {
			return travelersList.remove(traveler);
		}
		return false;
	}

}
