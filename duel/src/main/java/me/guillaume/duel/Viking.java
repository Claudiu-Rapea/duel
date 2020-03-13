package me.guillaume.duel;

public class Viking extends Fighter {

	public Viking() {
		hitPoints = VIKING_HITPOINTS;
		weapon = new Weapon(Weapon.AXE_DAMAGE);
	}

	@Override
	public Viking equip(String item) {
		if (BUCKLER.equals(item)) {
			this.setBuckler(true);
		}
		return this;
	}

}
