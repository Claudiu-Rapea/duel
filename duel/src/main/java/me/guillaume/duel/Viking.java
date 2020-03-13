package me.guillaume.duel;

public class Viking {

	public static final int WEAPON_DAMAGE = 6;
	public static final String BUCKLER = "buckler";

	private int hitPoints = 120;
	private boolean hasBuckler = false;

	public Viking equip(String item) {
		if (BUCKLER.equals(item)) {
			this.setBuckler(true);
		}
		return this;
	}

	public int hitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public boolean hasBuckler() {
		return hasBuckler;
	}

	public void setBuckler(boolean hasBuckler) {
		this.hasBuckler = hasBuckler;
	}

}
