package me.guillaume.duel;

import static me.guillaume.duel.Item.ARMOR;
import static me.guillaume.duel.Item.BUCKLER;

import java.util.Optional;

public class Swordsman extends Warrior {

	public Swordsman() {
		hitPoints = SWORDSMAN_HITPOINTS;
		weapon = new Weapon(Weapon.SWORD, Weapon.SWORD_DAMAGE);
	}

	public Swordsman(String string) {
	}

	@Override
	public Swordsman equip(String item) {
		if (BUCKLER.equals(item)) {
			buckler = Optional.of(new Buckler());
		}

		if (ARMOR.equals(item)) {
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
