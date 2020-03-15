package me.guillaume.duel;

import java.util.Optional;

public class Buckler {

	private int blockedHits = 0;
	private int axeHits = 0;

	public void getHit(Warrior owner, Weapon weapon) {
		if (axeHits > 3) {
			owner.buckler = Optional.empty();
			return;
		}
		if (Weapon.AXE.equals(weapon.getName())) {
			axeHits++;
		}
		blockedHits++;
	}

	public int getBlockedHits() {
		return blockedHits;
	}

}
