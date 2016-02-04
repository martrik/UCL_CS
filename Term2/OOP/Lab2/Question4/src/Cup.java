import java.util.ArrayList;
import java.util.Collections;


public class Cup {
	
	private int dice;
	
	public Cup() {
		
	}
	
	// Generates random results for x dice
	public ArrayList<Integer> throwDice(int dice) {
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 0; i<dice; i++) {
			result.add(randomWithRange(1,6));
		}
		
		return result;	
	}
	
	
	public int[] scoreDice(ArrayList<Integer> dice) {
		int score = 0;
		int freeDice = dice.size();
		
		// Check for 3 of a kind
		for (int i = 1; i<7; i++) {
			int occurrences = Collections.frequency(dice, i);
			
			if (occurrences >= 3) {
				if (i == 1) score = 1000;
				else score = i*100;
				occurrences -= 3;
				freeDice -= 3;
			}
			
			if (i == 1 || i == 5) {
				score += occurrences*numberScore(i);
				freeDice -= occurrences;
			}
		}
		
		int[] response = new int[2];
		response[0] = score;
		response[1] = freeDice;
		return response;
	}
	
	private int numberScore(int n) {
		if (n == 1) return 100;
		else if (n == 5) return 50;
		else return 0;
	}
	
	int randomWithRange(int min, int max) {
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
}
