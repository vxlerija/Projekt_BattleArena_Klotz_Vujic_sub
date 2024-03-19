package battleArena;

public abstract class BaseCharacter {
	private String name;
	private int livingPoints;
	private boolean specialAbility;
	private int damagePoints;
	
	
	public BaseCharacter(String name) {
		super();
		this.name = name;
		this.livingPoints = 100;
		this.specialAbility =false;
		this.damagePoints = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLivingPoints() {
		return livingPoints;
	}
	
	
	public boolean isSpecialAbility() {
		return specialAbility;
	}
	public void setSpecialAbility(boolean specialAbility) {
		this.specialAbility = specialAbility;
	}
	
	public void setLivingPoints(int livingPoints) {
		if (this.livingPoints >= 0) {
			this.livingPoints = livingPoints;
		}else {
			this.livingPoints = 0;
		}
	}
	
	public int getDamagePoints() {
		return damagePoints;
	}
	public void setDamagePoints(int damagePoints) {
		this.damagePoints = damagePoints;
	}
	
	
	
	public void getDamage(int points) {
		this.setLivingPoints(livingPoints - damagePoints); 
	}
	
	public abstract void attack(BaseCharacter enemy);
	
	public abstract void specialAbilityActive();
	 
	public abstract void specialAbilityDeactive();
}
