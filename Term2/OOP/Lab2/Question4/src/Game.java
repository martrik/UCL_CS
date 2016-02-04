import java.util.ArrayList;


public class Game {
	
	private ArrayList<Player> players = new ArrayList<>();
	private int turnOf = 1;
	
	private Cup cup = new Cup();
	
	public static void main(String[] ags) {
		Game game = new Game();
		game.start();
	}
	
	public void start() {
		System.out.println("Welcome to game of Greed.");
		
		int numPlayers = inputInt("How many players are going to play?");
		
		for (int i = 1; i<numPlayers+1; i++) {
			players.add(new Player(inputString("Name of player " + i)));
		}
		
		System.out.println("OK! Let's start...");
		nextTurn();
	}
	
	private void nextTurn() {
		Player player = players.get(turnOf);
		int freeDice = 5;
		
		if (!player.isBust()) {
			System.out.println("Turn for player " + player.getName());
			
			while(true) {
				String answer = inputString("Do you want to throw the dice ("+freeDice+")? (y/n)");
				
				if (answer.equals("y")) {
					ArrayList<Integer> dice = cup.throwDice(freeDice);
					printDice(dice);
					int score[] = cup.scoreDice(dice);
					if (freeDice != 0) freeDice = score[1];
					else break;
					System.out.println("This dice have a score of: " + score[0]);
					
				} else break;
			}
		}
		System.out.println("This player is bust with a score of: " + player.getScore());
		
		turnOf = (turnOf+1)%(players.size());
		nextTurn();
		
	}			
	
	private void printDice(ArrayList<Integer> dice) {
		System.out.println("This is the result of the cup:");
		for (Integer n : dice) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
	
	
	private String inputString(String initial) {
		Input in = new Input();

		while (true) {
			System.out.println(initial);
			if (in.hasNextLine()) {
				return in.nextLine();
			}
		}
	}
			
	private int inputInt(String initial) {
		Input in = new Input();

		while (true) {
			System.out.println(initial);
			if (in.hasNextInt()) {
				return in.nextInt();
			}
		}
	}
}
