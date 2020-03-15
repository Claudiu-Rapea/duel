package me.guillaume.duel;

import static me.guillaume.duel.Weapon.GREAT_SWORD_LABEL;

import java.util.Optional;

public abstract class Warrior {

	protected static final int SWORDSMAN_HITPOINTS = 100;
	protected static final int VIKING_HITPOINTS = 120;
	protected static final int HIGHLANDER_HITPOINTS = 150;

	protected int hitPoints;
	protected int hits = 0;
	protected Weapon weapon;
	protected Optional<Buckler> buckler = Optional.empty();
	protected Optional<Armor> armor = Optional.empty();

	protected abstract Warrior equip(String item);

	protected void fight(Warrior attacker, Warrior oponnent) {
		if (attacker.armor.isPresent()) {
			oponnent.getWeapon().decreaseDamage(3);
		}

		while (attacker.hitPoints() > 0 && oponnent.hitPoints() > 0) {
			strike(attacker, oponnent);
			strike(oponnent, attacker);
		}

		setHitPointsToZeroIfHitPointsAreNegative(attacker);
		setHitPointsToZeroIfHitPointsAreNegative(oponnent);
	}

	private void strike(Warrior attacker, Warrior opponent) {
		attacker.hits++;

		if (opponent.buckler.isPresent()) {
			opponent.buckler.get().hit(attacker.getWeapon(), opponent);
		}

		if (opponent.buckler.isPresent() && opponent.buckler.get().getHits() % 2 == 0) {
			return;
		}

		if (GREAT_SWORD_LABEL.equals(attacker.getWeapon().getName()) && attacker.hits % 3 == 0) {
			return;
		}

		opponent.setHitPoints(opponent.hitPoints() - attacker.getWeapon().getDamage());
	}

	private void setHitPointsToZeroIfHitPointsAreNegative(Warrior warrior) {
		warrior.setHitPoints(warrior.hitPoints() < 0 ? 0 : warrior.hitPoints());
	}

	protected int hitPoints() {
		return hitPoints;
	}

	protected void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	protected Weapon getWeapon() {
		return weapon;
	}

}
