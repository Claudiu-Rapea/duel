package me.guillaume.duel;

public class Swordsman extends Fighter {

	public Swordsman() {
		hitPoints = SWORDSMAN_HITPOINTS;
		weapon = new Weapon(Weapon.SWORD_DAMAGE);
	}

	public Swordsman(String string) {
	}

	@Override
	public Swordsman equip(String item) {
		if (BUCKLER.equals(item)) {
			this.setBuckler(true);
		}
		return this;
	}

	public void engage(Highlander highlander) {
	}

	public void engage(Viking viking) {
		int swordsmansBucklerHits = 0;
		int swordsmansBucklerLife = 3;
		int vikingsBucklerHits = 0;

		while (this.hitPoints > 0 && viking.hitPoints() > 0) {

			if (!viking.hasBuckler()) {
				hit(this, viking);
			} else {
				vikingsBucklerHits++;
				if (vikingsBucklerHits % 2 != 0) {
					hit(this, viking);
				}
			}

			if (!this.hasBuckler()) {
				hit(viking, this);
			} else {
				swordsmansBucklerHits++;
				if (swordsmansBucklerHits % 2 != 0 || swordsmansBucklerLife == 0) {
					hit(viking, this);
				} else {
					swordsmansBucklerLife--;
				}
			}
		}

		setHitPointsToZeroIfHitPointsAreNegative(this);
		setHitPointsToZeroIfHitPointsAreNegative(viking);

	}

}
