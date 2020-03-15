package me.guillaume.duel;

public class Armor {

	public Armor(Warrior warrior) {
		warrior.getWeapon().decreaseDamage(1);
	}

}
