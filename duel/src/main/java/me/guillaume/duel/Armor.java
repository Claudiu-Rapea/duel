package me.guillaume.duel;

public class Armor {

	public static final String ARMOR_LABEL = "armor";

	public Armor(Warrior warrior) {
		warrior.getWeapon().decreaseDamage(1);
	}

}
