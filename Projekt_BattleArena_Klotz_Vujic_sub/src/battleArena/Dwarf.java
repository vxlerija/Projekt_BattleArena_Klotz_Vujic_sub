package battleArena;

import java.util.concurrent.ThreadLocalRandom;

public class Dwarf extends BaseCharacter{

	public Dwarf(String name) {
		super(name);
	}

	
	
	/**
	 * calculates damage of Dwarf
	 */
	@Override
	public void getDamage(int points) {
		this.livingPoints = this.livingPoints - points;
		if(this.getLivingPoints() < 0) {
			this.setLivingPoints(0);
		}
		
	}
	
	
	/**
	 * attack method for Dwarf which refers to the method attackPossibilities
	 */
	@Override
	public void attack(BaseCharacter enemy) {
		int points = ThreadLocalRandom.current().nextInt(15, 25 +1);
		if(this.isSpecialAbility()) {
			if(this.attackPossibilities()== true) {
				points = points*2;
			}else {
				points = points /2;
			}
		}
		enemy.getDamage(points);
	}

	
	/**
	 * activates special ability of Dwarf
	 */
	@Override
	public boolean specialAbilityActive() {
		if(getLivingPoints() < 50) {
		}
		return true;
	}

	/**
	 * deactives special ability
	 */
	@Override
	public boolean specialAbilityDeactive() {
		return false;
	}
	
	/**
	 * calculates probability of the success of the attack
	 * @param points
	 */
	public boolean attackPossibilities() {
		int points = ThreadLocalRandom.current().nextInt (1, 10 + 1);
		if((this.getLivingPoints() <= 50) && (points <= 3)) {
		return true;
		}else if ((this.getLivingPoints() <- 20) && (points <= 5)){
		return true;
		}else if ((this.getLivingPoints() <- 10) && (points <=7)) {
			return true;
		}
		return false;
		
		
		
	
	}
	
	
	
	
	

}
