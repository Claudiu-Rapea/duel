package me.guillaume.duel;

public class Weapon {

	public static final String SWORD_LABEL = "sword";
	public static final String AXE_LABEL = "axe";
	public static final String GREAT_SWORD_LABEL = "Great Sword";
	public static final int SWORD_DAMAGE = 5;
	public static final int AXE_DAMAGE = 6;
	public static final int GREAT_SWORD_DAMAGE = 12;

	private final String name;
	private int damage;

	public Weapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}

	public void decreaseDamage(int value) {
		damage = damage <= value ? 0 : damage - value;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

}
