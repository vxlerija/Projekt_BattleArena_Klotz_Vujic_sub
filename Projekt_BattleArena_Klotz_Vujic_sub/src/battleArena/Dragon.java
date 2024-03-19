package battleArena;

import java.util.concurrent.ThreadLocalRandom;

public class Dragon extends BaseCharacter {
	private int damagePoints;



	public Dragon(String name) {
		super(name);
	}
	

	@Override
	/**
	 * calculates damage
	 */
	public void getDamage(int Points) {	
		/*int damagePoints = ThreadLocalRandom.current().nextInt(5, 10 + 1);
		if(isSpecialAbility() == true) {
			this.setLivingPoints(getLivingPoints()- damagePoints);
		}*/
		
		
	}

	/**
	 * method to attack the dragons enemy
	 */
	@Override
	public void attack(BaseCharacter enemy) {
		int points = ThreadLocalRandom.current().nextInt(20, 25 + 1);
		if(isSpecialAbility() == true) {
			points = points - ThreadLocalRandom.current().nextInt(5, 10 + 1);
		}
		enemy.getDamage(points);
			
		}
			

	/**
	 * activates the dragons special ability
	 */
	@Override
	public void specialAbilityActive() {
	    if (!this.isSpecialAbility()) {
	        damagePoints = damagePoints - calculateMalus();
	        this.setLivingPoints(getLivingPoints()+10);
	        this.setSpecialAbility(true); 
	    } else {
	        System.out.println("Special ability is already active!"); 
	    }
	}
	

	/**
	 * deactivates special ability
	 */
	@Override
	public void specialAbilityDeactive() {
	    if (this.isSpecialAbility()) {
	        damagePoints = ThreadLocalRandom.current().nextInt(20, 25);
	        this.setLivingPoints(getLivingPoints()-10);
	        this.setSpecialAbility(false); 
	    } else {
	        System.out.println("Special ability is not active!"); 
	    }
	}


	/**
	 * calculates malus for damage
	 * @return
	 */
	private int calculateMalus() {
		int malus = ThreadLocalRandom.current().nextInt(5,10);
		return malus;
	}

}
