package me.guillaume.duel;

public class Swordsman {

	public static final int WEAPON_DAMAGE = 5;

	private int hitPoints = 100;

	public Swordsman() {
	}

	public Swordsman(String string) {
	}

	public void engage(Highlander highlander) {
	}

	public void engage(Viking viking) {
		while (this.hitPoints > 0 && viking.hitPoints() > 0) {
			viking.setHitPoints(viking.hitPoints() - Swordsman.WEAPON_DAMAGE);
			this.hitPoints -= Viking.WEAPON_DAMAGE;
		}
		this.hitPoints = this.hitPoints < 0 ? 0 : this.hitPoints;
		viking.setHitPoints(viking.hitPoints() < 0 ? 0 : viking.hitPoints());
	}

	public Swordsman equip(String string) {
		return null;
	}

	public int hitPoints() {
		return 0;
	}

}
