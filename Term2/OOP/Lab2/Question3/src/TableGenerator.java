import java.util.ArrayList;


public class TableGenerator {
	
	private int lower;
	private int upper;

	private String tableHeader = new String();
	private String fromHeader = new String();
	private String toHeader = new String();
	
	private int columns;
	private int spacesBetween;
	
	private ArrayList<String> table = new ArrayList<>();
	
	public TableGenerator(int lower, int upper) {
		this.lower = lower;
		this.upper  = upper;
	}
	
	public void setTableHeader(String header) { 
		tableHeader = header;
	}
	
	public void setColumnHeaders(String from, String to) {
		fromHeader = from;
		toHeader = to;
	}
	
	public void setNumberColumns(int cols) {
		columns = cols;
	}
	
	public void setSpacesBetween(int spaces) {
		spacesBetween = spaces;
	}
	
	public void generateTable() {
		table.clear();	
		String line = new String();
		String spaces = new String(new char[spacesBetween]).replace('\0', ' ');
		
		// Generate top bar
		for (int i = 0; i<columns; i++) {
			line += fromHeader + "   " + toHeader;
			if (i<columns-1) {
				line += spaces; 
			}
		}
		table.add(line);
		line = "";
		
		int counter = 0;
		
		// Generate each line
		for (int i = lower; i < upper+1; i++) {
			line += i + "   " + convertTemp(i);
			if (counter == columns-1) {
				table.add(line);
				line = new String();
				counter = 0;
				continue;
			}
			line += spaces;
			counter++;
		}
	}
	
	public ArrayList<String> getTable() {
		return new ArrayList<String>(table);
	}
	
	// Converts from celsius to Fahrenheit
	private int convertTemp(int temp) {
		return (int) (temp * (9/5.0) +32);
	}
	
	
}
