package me.guillaume.duel;

import static me.guillaume.duel.Weapon.GREAT_SWORD_LABEL;
import static me.guillaume.duel.Weapon.GREAT_SWORD_DAMAGE;

public class Highlander extends Warrior {

	public Highlander() {
		hitPoints = HIGHLANDER_HITPOINTS;
		weapon = new Weapon(GREAT_SWORD_LABEL, GREAT_SWORD_DAMAGE);
	}

	public Highlander(String string) {
	}

	@Override
	protected Warrior equip(String item) {
		return this;
	}

}
