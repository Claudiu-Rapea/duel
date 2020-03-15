package me.guillaume.duel;

import static me.guillaume.duel.Buckler.BUCKLER_LABEL;
import static me.guillaume.duel.Weapon.AXE_DAMAGE;
import static me.guillaume.duel.Weapon.AXE_LABEL;

import java.util.Optional;

public class Viking extends Warrior {

	public Viking() {
		hitPoints = VIKING_HITPOINTS;
		weapon = new Weapon(AXE_LABEL, AXE_DAMAGE);
	}

	@Override
	public Viking equip(String item) {
		if (BUCKLER_LABEL.equals(item)) {
			buckler = Optional.of(new Buckler());
		}
		return this;
	}

}
