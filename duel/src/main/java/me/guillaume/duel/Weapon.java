package me.guillaume.duel;

public class Weapon {

	public static final int SWORD_DAMAGE = 5;
	public static final int AXE_DAMAGE = 6;

	private final int damage;

	public Weapon(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

}
