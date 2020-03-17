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
	private int hits;
	private boolean hasPoison = false;

	public Weapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}

	public void decreaseDamage(int value) {
		damage = damage <= value ? 0 : damage - value;
	}

	public void increaseDamage(int value) {
		damage += value;
	}

	public String getName() {
		return name;
	}

	public int getDamage() {
		return damage;
	}

	public boolean hasPoison() {
		return hasPoison;
	}

	public void putPoison() {
		hasPoison = true;
	}

	public int getPoisonDamage() {
		if (hits <= 2) {
			return 20;
		}
		hasPoison = false;
		return 0;
	}

	public int getHits() {
		return hits;
	}

	public void increaseHits() {
		hits++;
	}

}
