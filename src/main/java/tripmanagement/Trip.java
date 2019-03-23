package tripmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Trip {

	private String id;
	List<Traveler> travelersList = new ArrayList<Traveler>();

	public Trip(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public List<Traveler> getTravelersList() {
		return Collections.unmodifiableList(travelersList);
	}

	public abstract boolean addTraveler(Traveler traveler);

	public abstract boolean removeTraveler(Traveler traveler);

}
