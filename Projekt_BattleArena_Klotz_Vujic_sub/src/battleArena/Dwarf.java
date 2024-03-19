package battleArena;

import java.util.concurrent.ThreadLocalRandom;

public class Dwarf extends BaseCharacter {
	public Dwarf(String name) {
		super(name);
	}

	/**
	 * calculates damage of Dwarf
	 */
	@Override
	public void getDamage(int points) {
	//setLivingPoints(getLivingPoints() - points);
		
	}

	/**
	 * method to attack the dwarfs enemy
	 */
	@Override
	public void attack(BaseCharacter enemy) {
		this.setDamagePoints(ThreadLocalRandom.current().nextInt(15, 25 +1));
		this.setDamagePoints(getDamagePoints());
		enemy.setLivingPoints(getLivingPoints()-getDamagePoints());
	}

	
	/**
	 * activates special ability of dwarf
	 */
	@Override
	public void specialAbilityActive() {
			if(this.getLivingPoints()<=50) {
			this.setSpecialAbility(true);
			int ranNumber = ThreadLocalRandom.current().nextInt(1, 10 + 1);
			if(getLivingPoints() <= 50 && getLivingPoints() > 20 && 1 <= ranNumber && ranNumber >= 3) {
				int i = ThreadLocalRandom.current().nextInt(15, 25 +1);
				this.setDamagePoints(i*2);
				//points = points*2;
				//enemy.getDamage(points);
			}else if(getLivingPoints() <= 20 && getLivingPoints() > 10 && 1 <= ranNumber && ranNumber >= 5) {
				int i = ThreadLocalRandom.current().nextInt(15, 25 +1);
				this.setDamagePoints(i*2);
				//points = points*2;
				//enemy.getDamage(points);
			}else if(getLivingPoints() <= 10 && getLivingPoints() > 0 && 1 <= ranNumber && ranNumber >= 7) {
				int i = ThreadLocalRandom.current().nextInt(15, 25 +1);
				this.setDamagePoints(i*2);
				//points = points*2;
				//enemy.getDamage(points);
			}else if(getLivingPoints() <= 50 && getLivingPoints() > 0 && 6 <= ranNumber && ranNumber >= 10) {
				int i = ThreadLocalRandom.current().nextInt(15, 25 +1);
				this.setDamagePoints(i/2);
				//points = points/2;
				//enemy.getDamage(points);
				}
		}
	}

	/**
	 * deactives special ability
	 */
	@Override
	public void specialAbilityDeactive() {
		this.setSpecialAbility(false);
	}
}
