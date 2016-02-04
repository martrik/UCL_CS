
public class TableManager {
	
	public static void main(String[] ags) {
		TableManager manager = new TableManager();
		manager.start();
	}
	
	public void start() {
		TableGenerator table = new TableGenerator(0,12);
		table.setTableHeader("Hello");
		table.setColumnHeaders("C", "F");
		table.setNumberColumns(4);
		table.setSpacesBetween(4);
		table.generateTable();
		
		for (String st : table.getTable()) {
			System.out.println(st);
		}
	}

}
