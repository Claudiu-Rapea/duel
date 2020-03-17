package me.guillaume.duel;

import static me.guillaume.duel.Weapon.AXE_LABEL;

import java.util.Optional;

public class Buckler {

	public static final String BUCKLER_LABEL = "buckler";

	private int axeHits = 0;
	private boolean isCooldownActive = false;

	public void hit(Weapon weapon, Warrior warrior) {
		isCooldownActive = !isCooldownActive;
		if (isCooldownActive) {
			if (AXE_LABEL.equals(weapon.getName())) {
				axeHits++;
			}
			if (axeHits > 3) {
				warrior.buckler = Optional.empty();
			}
		}
	}

	public boolean isCooldownActive() {
		return isCooldownActive;
	}

}
