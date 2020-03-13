package me.guillaume.duel;

import java.util.Optional;

public abstract class Warrior {

	protected static final int SWORDSMAN_HITPOINTS = 100;
	protected static final int VIKING_HITPOINTS = 120;

	protected int hitPoints;
	protected Weapon weapon;
	protected Optional<Buckler> buckler;

	protected abstract Warrior equip(String item);

	protected void strike(Warrior attacker, Warrior target) {
		if (!target.getBuckler().isPresent()) {
			subtractHitPoints(target, attacker.getWeapon().getDamage());
		} else {
			strikeWhenTargetWarriorHasBuckler(attacker, target);
		}
	}

	private void strikeWhenTargetWarriorHasBuckler(Warrior attacker, Warrior target) {
		Buckler targetWarriorsBuckler = target.getBuckler().get();
		targetWarriorsBuckler.block(target, attacker.getWeapon());
		if (target.getBuckler().isPresent() && targetWarriorsBuckler.getBlockedHits() % 2 == 0) {
			subtractHitPoints(target, attacker.getWeapon().getDamage());
		}
	}

	private void subtractHitPoints(Warrior target, int attackersDamage) {
		target.setHitPoints(target.hitPoints() - attackersDamage);
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

	protected Optional<Buckler> getBuckler() {
		return buckler;
	}

	public void removeBuckler() {
		this.buckler = Optional.empty();
	}

}
