import java.util.ArrayList;


public class Range {
	
	private int lower;
	private int upper;
	
	public Range(int lower, int upper) throws Exception {
		if (this.lower<this.upper) {
			this.lower = lower;
			this.upper = upper;
		} else throw new Exception("Upper bound not valid");
	}
	
	public boolean contains(int n) {
		return lower <= n && n <= n;
	}
	
	public ArrayList<Integer> getValues() {
		ArrayList<Integer> values = new ArrayList<>();
		
		for (int i = lower; i < upper+1; i++) {
			values.add(i);
		}
		
		return values;
	}
	
	public int getLower() {
		return lower;
	}
	
	public int getUper() {
		return upper;
	}

}
