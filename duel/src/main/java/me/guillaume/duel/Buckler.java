package me.guillaume.duel;

import static me.guillaume.duel.Weapon.AXE_LABEL;

import java.util.Optional;

public class Buckler {

	public static final String BUCKLER_LABEL = "buckler";

	private int hits = 0;
	private int axeHits = 0;

	public void hit(Weapon weapon, Warrior warrior) {
		hits++;
		if (axeHits > 3) {
			warrior.buckler = Optional.empty();
			return;
		}
		if (AXE_LABEL.equals(weapon.getName())) {
			axeHits++;
		}
	}

	public int getHits() {
		return hits;
	}

}
