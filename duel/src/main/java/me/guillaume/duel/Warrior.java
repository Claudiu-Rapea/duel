package me.guillaume.duel;

import static me.guillaume.duel.Weapon.GREAT_SWORD_LABEL;

import java.util.Optional;

public abstract class Warrior {

	protected int hitPoints;
	protected Weapon weapon;
	protected Optional<Buckler> buckler = Optional.empty();
	protected Optional<Armor> armor = Optional.empty();

	protected abstract Warrior equip(String item);

	protected void fight(Warrior attacker, Warrior opponent) {
		if (attacker.armor.isPresent()) {
			opponent.getWeapon().decreaseDamage(3);
		}

		while (attacker.hitPoints() > 0 && opponent.hitPoints() > 0) {
			strike(attacker, opponent);
			strike(opponent, attacker);
		}
	}

	private void strike(Warrior attacker, Warrior opponent) {
		attacker.getWeapon().increaseHits();

		if (GREAT_SWORD_LABEL.equals(attacker.getWeapon().getName()) && attacker.getWeapon().getHits() % 3 == 0) {
			return;
		}

		if (opponent.buckler.isPresent()) {
			opponent.buckler.get().hit(attacker.getWeapon(), opponent);
		}

		if (opponent.buckler.isPresent() && opponent.buckler.get().isCooldownActive()) {
			return;
		}

		subtractOpponentHitPoints(attacker, opponent);
	}

	private void subtractOpponentHitPoints(Warrior attacker, Warrior opponent) {
		int opponentHitPointsAfterStrike = opponent.hitPoints() - attacker.getWeapon().getDamage();
		if (attacker.getWeapon().hasPoison()) {
			opponentHitPointsAfterStrike -= attacker.getWeapon().getPoisonDamage();
		}

		opponent.setHitPoints(opponentHitPointsAfterStrike <= 0 ? 0 : opponentHitPointsAfterStrike);
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

	protected void setWeapon(Weapon weapon) {
		if (this.weapon.hasPoison()) {
			weapon.putPoison();
		}
		this.weapon = weapon;
	}

}
