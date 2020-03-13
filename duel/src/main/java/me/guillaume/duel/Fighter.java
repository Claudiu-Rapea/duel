package me.guillaume.duel;

public abstract class Fighter {

	protected static final int SWORDSMAN_HITPOINTS = 100;
	protected static final int VIKING_HITPOINTS = 120;
	protected static final String BUCKLER = "buckler";

	protected int hitPoints;
	protected Weapon weapon;
	protected boolean hasBuckler;

	public abstract Fighter equip(String item);

	protected void setHitPointsToZeroIfHitPointsAreNegative(Fighter fighter) {
		fighter.setHitPoints(fighter.hitPoints() < 0 ? 0 : fighter.hitPoints());
	}

	protected void hit(Fighter fighter1, Fighter fighter2) {
		fighter2.setHitPoints(fighter2.hitPoints() - fighter1.getWeapon().getDamage());
	}

	public int hitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public Weapon getWeapon() {
		return weapon;
	}

//	public void setWeapon(Weapon weapon) {
//		this.weapon = weapon;
//	}

	public boolean hasBuckler() {
		return hasBuckler;
	}

	public void setBuckler(boolean hasBuckler) {
		this.hasBuckler = hasBuckler;
	}

}
