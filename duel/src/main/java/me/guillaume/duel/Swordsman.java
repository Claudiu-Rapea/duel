package me.guillaume.duel;

public class Swordsman {

	public static final int WEAPON_DAMAGE = 5;
	public static final String BUCKLER = "buckler";

	private int hitPoints = 100;
	private boolean hasBuckler = false;

	public Swordsman() {
	}

	public Swordsman(String string) {
	}

	public void engage(Highlander highlander) {
	}

	public void engage(Viking viking) {
		int swordsmansBucklerHits = 0;
		int swordsmansBucklerLife = 3;
		int vikingsBucklerHits = 0;

		while (this.hitPoints > 0 && viking.hitPoints() > 0) {

			if (!viking.hasBuckler()) {
				viking.setHitPoints(viking.hitPoints() - Swordsman.WEAPON_DAMAGE);
			} else {
				vikingsBucklerHits++;
				if (vikingsBucklerHits % 2 != 0) {
					viking.setHitPoints(viking.hitPoints() - Swordsman.WEAPON_DAMAGE);
				}
			}

			if (!this.hasBuckler()) {
				this.hitPoints -= Viking.WEAPON_DAMAGE;
			} else {
				swordsmansBucklerHits++;
				if (swordsmansBucklerHits % 2 != 0 || swordsmansBucklerLife == 0) {
					this.hitPoints -= Viking.WEAPON_DAMAGE;
				} else {
					swordsmansBucklerLife--;
				}
			}
		}

		this.hitPoints = this.hitPoints < 0 ? 0 : this.hitPoints;
		viking.setHitPoints(viking.hitPoints() < 0 ? 0 : viking.hitPoints());

	}

	public Swordsman equip(String item) {
		if (BUCKLER.equals(item)) {
			this.setBuckler(true);
		}
		return this;
	}

	public int hitPoints() {
		return hitPoints;
	}

	public boolean hasBuckler() {
		return hasBuckler;
	}

	public void setBuckler(boolean hasBuckler) {
		this.hasBuckler = hasBuckler;
	}

}
