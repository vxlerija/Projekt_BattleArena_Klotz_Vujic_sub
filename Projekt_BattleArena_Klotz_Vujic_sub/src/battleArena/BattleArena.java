package battleArena;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BattleArena {
	
	Scanner sc = new Scanner(System.in);
	private BaseCharacter player1;
	private BaseCharacter player2;
	private BaseCharacter winner;
	
	
	
	public BattleArena(BaseCharacter player1, BaseCharacter player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public BattleArena(Scanner sc) {
		this.player1 = input(sc);
		this.player2 = input(sc);
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
	

	/**
	 * auxiliary method which lets the gamer decide for their mode, with the help of switch
	 * different the possibilities are shown
	 * simple gameplay
	 * @param attacker
	 * @param defender
	 */
	public void simulateCombat(BaseCharacter attacker, BaseCharacter defender) {
		System.out.println("It's" +attacker.getName() + "'s Turn");
		System.out.println("Choose your mode!" +"\n" + "|1| attack \n"+"|2| activate special ability \n" + "|3| deactivate special ability \n");
		System.out.println("Choice: ");
		
		int mode = sc.nextInt();
		switch(mode) {
		
		case 1: 
			System.out.println(attacker.getName() + " attacked");
			attacker.attack(defender);
			printPlayersStatus();
			break;
		case 2:
			System.out.println(attacker.getName() + " activated special ability");
			attacker.specialAbilityActive();
			printPlayersStatus();
			break;
		case 3: 
			System.out.println(attacker.getName() + " deactivated special ability");
			attacker.specialAbilityDeactive();
			printPlayersStatus();
			break;
		default:
			System.out.println("Something went wrong! Please try again!");
			break;
		}
		if(defender.getLivingPoints()<=0) {
			this.winner = attacker;
		}else {
			this.winner = defender;
		}
	}	
	
	/**
	 * method which lets the game go through by deciding for a random starter and for a winner in the end
	 */
	public void fight() {
		int starter = ThreadLocalRandom.current().nextInt(1,2+1);
		while(player1.getLivingPoints() > 0 && player2.getLivingPoints() > 0) {
			if(starter == 1) {
				simulateCombat(player1, player2);
				starter=2;
			}else {
				simulateCombat(player2, player1);
				starter = 1;
			}
		}
		if(this.winner == player1) {
			System.out.println("THE WINNER IS:" + this.player1.getName() + " CONGRATS!");
		}else {
			System.out.println("THE WINNER IS: " + this.player2.getName()+ " CONGRATS!");
		}
	}
	
	/**
	 * prints out the current situation of each player
	 */
	public void printPlayersStatus() {
		System.out.println(this.player1.getName() + " : \n" + " livingPoints = " + this.player1.getLivingPoints() + "\n special ability active = " + this.player1.isSpecialAbility() 
		+ "\n\n " + this.player2.getName() + " : \n" + " livingPoints = " + this.player2.getLivingPoints() + "\n special ability active = " + this.player2.isSpecialAbility()+ "\n");
	}
	
	/**
	 * lets gamer decide for their desired character and their names
	 * @param sc
	 * @return
	 */
	
	public static BaseCharacter input(Scanner sc) {
	System.out.println("Choose your Character!");
	System.out.println("|1. Dragon|" + "\n" + "|2. Dwarf|");
	System.out.print("Choice: ");
	String characterChoice = sc.nextLine();
	System.out.println();
	System.out.println("Name your chosen character: ");
	String name = sc.nextLine();
	
	switch(characterChoice) {
	case "1": return new Dragon(name);
	case "2": return new Dwarf(name);
	default: return null;
	}
	
	}
}
