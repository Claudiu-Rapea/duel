package me.guillaume.duel;

import static me.guillaume.duel.Weapon.GREAT_SWORD_DAMAGE;
import static me.guillaume.duel.Weapon.GREAT_SWORD_LABEL;

public class Highlander extends Warrior {

	private static final int HIGHLANDER_HITPOINTS = 150;
	private static final String VETERAN_LABEL = "Veteran";

	private boolean isVeteran = false;
	private boolean isBerserk = true;

	public Highlander() {
		this("");
	}

	public Highlander(String attribute) {
		hitPoints = HIGHLANDER_HITPOINTS;
		weapon = new Weapon(GREAT_SWORD_LABEL, GREAT_SWORD_DAMAGE);
		if (VETERAN_LABEL.equals(attribute)) {
			isVeteran = true;
			isBerserk = false;
		}
	}

	@Override
	protected Warrior equip(String item) {
		return this;
	}

	@Override
	protected int hitPoints() {
		if (isVeteran && !isBerserk && hitPoints <= 0.3 * HIGHLANDER_HITPOINTS) {
			weapon.increaseDamage(GREAT_SWORD_DAMAGE);
			isBerserk = true;
		}
		return super.hitPoints();
	}

}
