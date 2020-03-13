package me.guillaume.duel;

import static me.guillaume.duel.Buckler.BUCKLER;

import java.util.Optional;

public class Swordsman extends Warrior {

	private final Swordsman swordsman = this;

	public Swordsman() {
		hitPoints = SWORDSMAN_HITPOINTS;
		weapon = new Weapon(Weapon.SWORD, Weapon.SWORD_DAMAGE);
		buckler = Optional.empty();
	}

	public Swordsman(String string) {
	}

	@Override
	public Swordsman equip(String item) {
		if (BUCKLER.equals(item)) {
			buckler = Optional.of(new Buckler());
		}
		return this;
	}

	public void engage(Highlander highlander) {
	}

	public void engage(Viking viking) {
		while (swordsman.hitPoints() > 0 && viking.hitPoints() > 0) {
			strike(swordsman, viking);
			strike(viking, swordsman);
		}

		setHitPointsToZeroIfHitPointsAreNegative(swordsman);
		setHitPointsToZeroIfHitPointsAreNegative(viking);
	}

}
