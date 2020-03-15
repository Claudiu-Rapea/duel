package me.guillaume.duel;

import static me.guillaume.duel.Item.BUCKLER;

import java.util.Optional;

public class Viking extends Warrior {

	public Viking() {
		hitPoints = VIKING_HITPOINTS;
		weapon = new Weapon(Weapon.AXE, Weapon.AXE_DAMAGE);
	}

	@Override
	public Viking equip(String item) {
		if (BUCKLER.equals(item)) {
			buckler = Optional.of(new Buckler());
		}
		return this;
	}

}
