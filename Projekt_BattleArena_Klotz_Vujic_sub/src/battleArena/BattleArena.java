package battleArena;

import java.util.Random;

public class BattleArena {
	private BaseCharacter player1;
	private BaseCharacter player2;
	private BaseCharacter winner;
	
	public BattleArena(BaseCharacter player1, BaseCharacter player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.winner = null;
	}

	public BaseCharacter getPlayer1() {
		return player1;
	}

	public void setPlayer1(BaseCharacter player1) {
		this.player1 = player1;
	}

	public BaseCharacter getPlayer2() {
		return player2;
	}

	public void setPlayer2(BaseCharacter player2) {
		this.player2 = player2;
	}

	public BaseCharacter getWinner() {
		return winner;
	}

	public void setWinner(BaseCharacter winner) {
		this.winner = winner;
	}
	
	public BaseCharacter attacker;
	public BaseCharacter defender;
	
	public void selectStarter() {
		Random random = new Random();

        while (player1.getLivingPoints()>0 && player2.getLivingPoints()>0) {
            if (random.nextBoolean()) {
                this.attacker = this.player1;
                this.defender = this.player2;
            } else {
                this.attacker = this.player2;
                this.defender = this.player1;
            }
            break;
        }
	}
	
	public void exchangeTurn() {
		BaseCharacter temp = attacker;
	    attacker = defender;
	    defender = temp;

	}
	
	public void fight(int input) {
		
		if(input == 1) {
			attacker.attack(defender);
			System.out.println(this.attacker.getName() + " caused damage" + "\n\t");
			printPlayersStatus();
			exchangeTurn();
		}else if(input == 2 && attacker.isSpecialAbility() == false) {
			attacker.specialAbilityActive();
			attacker.setSpecialAbility(true);
			System.out.println(this.attacker.getName() + " activated their special Ability: " + "\n\t");
			printPlayersStatus();
			exchangeTurn();
		}else if(input == 3 && attacker.isSpecialAbility() == true) {
			attacker.specialAbilityDeactive();
			attacker.setSpecialAbility(false);
			System.out.println(this.attacker.getName() + " deactivated their special Ability:" + "\n\t");
			printPlayersStatus();
			exchangeTurn();
		}else {
			System.out.println("Only numbers from 1 to 3 accepted!" + "\n" + "Try again!");
		}
	}
	
	public void electTheWinner() {
		if(this.attacker.getLivingPoints() <= 0) {
			this.winner = this.defender;
			System.out.println(this.winner.getName() + "won the game!Congrats");
		}
	}
	
	public void printPlayersStatus() {
		System.out.println(this.player1.getName() + " : \n" + " health = " + this.player1.getLivingPoints() + "\n special ability active = " + this.player1.isSpecialAbility() + 
		"\n\n" + this.player2.getName() + " : \n" + " health = " + this.player2.getLivingPoints() + "\n special ability active = " + this.player2.isSpecialAbility()+ "\n");
	}
}
