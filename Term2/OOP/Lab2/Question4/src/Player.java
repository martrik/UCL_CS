
public class Player {
	
	private String name = new String();
	private int score = 0;
	private boolean bust = false;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void setScore(int n) {
		score = n;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBust(boolean value) {
		bust = value;
	}
	
	public boolean isBust() {
		return bust;
	}
}
