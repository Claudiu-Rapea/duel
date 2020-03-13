package me.guillaume.duel;

public class Weapon {

	public static final String SWORD = "sword";
	public static final String AXE = "axe";
	public static final int SWORD_DAMAGE = 5;
	public static final int AXE_DAMAGE = 6;

	private final String name;
	private final int damage;

	public Weapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

}
