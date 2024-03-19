package battleArena;
import java.util.Scanner;

public class App {
	
	public static BaseCharacter player1 = null;
	public static BaseCharacter player2 = null;
	static String name;
	static int choice;
	
	
	public static int input(Scanner sc) {
		System.out.println("Choose your Character \n\t" + "|1| Dragon \n\t" + "|2| Dwarf");
		choice = -1;
			do {
				choice = sc.nextInt();
				if(choice < 1 || choice > 2) {
					System.err.println("Error");
				}
		}	while (!(choice >= 1 && choice <=2));
			return choice;
			
	}
	
	public static String enterCharacterName(Scanner sc) {
		do {
			if(choice == 1) {
				System.out.println("Name your Dragon: " + "\n");
				name = "";
				name = sc.nextLine();
			}else if(choice == 2) {
				System.out.println("Name your Dwarf: " + "\n");
				name = "";
				name = sc.nextLine();
			}
		}while (name.equals(""));
		return name;
	}
	

	
	public static BaseCharacter createCharakter(String name) {
		if(choice == 1) {
			return new Dragon(name);
		}else if (choice == 2) {
			return new Dwarf(name);
			
		}else {
			System.err.println("Something went wrong. Please try again!");
			
		}
		return null;
}
	
	public static int inputCharacter(Scanner sc, BattleArena arena) {	
		System.out.println("It's " + arena.attacker.getName() + " turn" + "\n");
		System.out.println("please choose your mode");
		System.out.println("|1| attack \n"+"|2| activate special ability \n" + "|3| deactivate special ability \n");
		int input;
		do {
			input = sc.nextInt();
		} while (!(input>= 1 && input <= 3));
		return input;
	}
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		do {
			choice = input(sc);
			sc.nextLine();
			name = enterCharacterName(sc);
			player1 = createCharakter(name);
			
			choice = input(sc);
			sc.nextLine();
			name = enterCharacterName(sc);
			player2 = createCharakter(name);
		} while (player1.equals(null) || player2.equals(null));
		
		BattleArena arena = new BattleArena(player1, player2);
		arena.selectStarter();
		
		
		int inputCharacter;
		do {
			inputCharacter = inputCharacter(sc, arena);
			arena.fight(inputCharacter);
			//arena.electTheWinner();
			
		} while (player1.getLivingPoints() > 0 && player2.getLivingPoints() > 0);
		
		arena.electTheWinner();
		sc.close();

	}
}