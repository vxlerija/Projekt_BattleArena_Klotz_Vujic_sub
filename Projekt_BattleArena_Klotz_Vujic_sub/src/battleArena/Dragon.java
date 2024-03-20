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
	public void getDamage(int points) {	
		int damagePoints = ThreadLocalRandom.current().nextInt(5, 10 + 1);
		this.setLivingPoints(getLivingPoints()- damagePoints);
		
		
		
	}

	/**
	 * method to attack the dragons enemy
	 */
	@Override
	public void attack(BaseCharacter enemy) {
		int points = ThreadLocalRandom.current().nextInt(20, 25 + 1);
		if(this.isSpecialAbility() == true) {
			points = points - ThreadLocalRandom.current().nextInt(5, 10 + 1);
		}
		enemy.getDamage(points);
			
		}
			

	/**
	 * activates the dragons special ability
	 */
	@Override
	public boolean specialAbilityActive() {
	    if(!this.isSpecialAbility()) {
	        damagePoints = damagePoints - calculateMalus();
	        this.setLivingPoints(getLivingPoints()+10);
	        this.setSpecialAbility(true);
	        return true; 
	    }else {
	        System.out.println("Special ability is already active!");
	        return false; 
	    }
	}
	

	/**
	 * deactivates special ability
	 */
	@Override
	public boolean specialAbilityDeactive() {
	    if (this.isSpecialAbility()) {
	        damagePoints = ThreadLocalRandom.current().nextInt(20, 25);
	        this.setLivingPoints(getLivingPoints()-10);
	        this.setSpecialAbility(false);
	        return true; 
	    } else {
	        System.out.println("Special ability is not active!");
	        return false; 
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
