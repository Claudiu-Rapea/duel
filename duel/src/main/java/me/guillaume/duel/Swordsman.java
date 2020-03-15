package me.guillaume.duel;

import static me.guillaume.duel.Armor.ARMOR_LABEL;
import static me.guillaume.duel.Buckler.BUCKLER_LABEL;
import static me.guillaume.duel.Weapon.SWORD_DAMAGE;
import static me.guillaume.duel.Weapon.SWORD_LABEL;

import java.util.Optional;

public class Swordsman extends Warrior {

	public Swordsman() {
		hitPoints = SWORDSMAN_HITPOINTS;
		weapon = new Weapon(SWORD_LABEL, SWORD_DAMAGE);
	}

	public Swordsman(String string) {
	}

	@Override
	public Swordsman equip(String item) {
		if (BUCKLER_LABEL.equals(item)) {
			buckler = Optional.of(new Buckler());
		}

		if (ARMOR_LABEL.equals(item)) {
			armor = Optional.of(new Armor(this));
		}

		return this;
	}

	public void engage(Viking viking) {
		fight(this, viking);
	}

	public void engage(Highlander highlander) {
		fight(this, highlander);
	}

}
