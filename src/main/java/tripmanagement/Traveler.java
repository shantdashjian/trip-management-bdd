package tripmanagement;

public class Traveler {

	private String name;
	private boolean vip;

	public Traveler(String name, boolean vip) {
		this.name = name;
		this.vip = vip;
	}

	public String getName() {
		return name;
	}

	public boolean isVip() {
		return vip;
	}

}
