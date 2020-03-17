package me.guillaume.duel;

import static me.guillaume.duel.Armor.ARMOR_LABEL;
import static me.guillaume.duel.Buckler.BUCKLER_LABEL;
import static me.guillaume.duel.Weapon.AXE_DAMAGE;
import static me.guillaume.duel.Weapon.AXE_LABEL;
import static me.guillaume.duel.Weapon.SWORD_DAMAGE;
import static me.guillaume.duel.Weapon.SWORD_LABEL;

import java.util.Optional;

public class Swordsman extends Warrior {

	private static final int SWORDSMAN_HITPOINTS = 100;
	private static final String VICIOUS_LABEL = "Vicious";

	public Swordsman() {
		this("");
	}

	public Swordsman(String attribute) {
		hitPoints = SWORDSMAN_HITPOINTS;
		weapon = new Weapon(SWORD_LABEL, SWORD_DAMAGE);
		if (VICIOUS_LABEL.equals(attribute)) {
			weapon.putPoison();
		}
	}

	@Override
	public Swordsman equip(String item) {
		if (BUCKLER_LABEL.equals(item)) {
			buckler = Optional.of(new Buckler());
		}

		if (ARMOR_LABEL.equals(item)) {
			armor = Optional.of(new Armor(this));
		}

		if (AXE_LABEL.equals(item)) {
			setWeapon(new Weapon(AXE_LABEL, AXE_DAMAGE));
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
