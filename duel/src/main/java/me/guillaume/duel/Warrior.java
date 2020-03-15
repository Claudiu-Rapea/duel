package me.guillaume.duel;

import static me.guillaume.duel.Weapon.GREAT_SWORD;

import java.util.Optional;

public abstract class Warrior {

	protected static final int SWORDSMAN_HITPOINTS = 100;
	protected static final int VIKING_HITPOINTS = 120;
	protected static final int HIGHLANDER_HITPOINTS = 150;

	protected int hitPoints;
	protected Weapon weapon;
	protected Optional<Buckler> buckler = Optional.empty();
	protected Optional<Armor> armor = Optional.empty();

	protected abstract Warrior equip(String item);

	protected void fight(Warrior attacker, Warrior target) {
		if (attacker.armor.isPresent()) {
			target.getWeapon().decreaseDamage(3);
		}

		while (attacker.hitPoints() > 0 && target.hitPoints() > 0) {
			strike(attacker, target);
			strike(target, attacker);
		}

		setHitPointsToZeroIfHitPointsAreNegative(attacker);
		setHitPointsToZeroIfHitPointsAreNegative(target);
	}

	private void strike(Warrior attacker, Warrior target) {
		if (target.buckler.isPresent()) {
			target.buckler.get().getHit(target, attacker.getWeapon());
		}

		if (target.buckler.isPresent() && target.buckler.get().getBlockedHits() % 2 == 0) {
			return;
		}

		if (GREAT_SWORD.equals(attacker.getWeapon().getName()) && target.buckler.isPresent()
				&& target.buckler.get().getBlockedHits() % 3 == 0) {
			return;
		}
		target.setHitPoints(target.hitPoints() - attacker.getWeapon().getDamage());

	}

	protected void setHitPointsToZeroIfHitPointsAreNegative(Warrior fighter) {
		fighter.setHitPoints(fighter.hitPoints() < 0 ? 0 : fighter.hitPoints());
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

//	public void setWeapon(Weapon weapon) {
//		this.weapon = weapon;
//	}

}
