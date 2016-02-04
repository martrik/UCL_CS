
public class AdressBookManager {
	
	private AdressBook book = new AdressBook();
	
	static public void main(String[] ags) {
		AdressBookManager manager = new AdressBookManager();
		manager.start();
	}
	
	public void start() {
		displayUI();
	}
	
	private void displayUI() {
		Input in = new Input();
		
		while (true) {
			System.out.println("");
			System.out.println("1. Add an entry to the adress book.");
			System.out.println("2. Search an existant entry from the adress book.");
			System.out.println("3. Delete an existant entry from the adress book.");
			
			if (in.hasNextInt()) {
				switch (in.nextInt()) {
				case 1:
					selectedAdd();
					break;
				case 2:
					selectedSearch();
					break;
				case 3:
					selectedDelete();
					break;
				default:
					System.out.println("This is not a valid number");
					continue;
				}
			}	
		}
	}
	
	private void selectedDelete() {
		String name = getInput("Input the exact name of the person you want to delete:");
			
		if (book.deleteEntryWithName(name)) {
			System.out.println("Entry deleted correctly.");
		} else System.out.println("The specified entry couldn't be deleted.");
	}
	
	private void selectedAdd() {
		String name = getInput("Input the name of the person you want to add:");
		String email = getInput("Input the email of the person you want to add:");
		String phone = getInput("Input the phone number name of the person you want to add:");
		book.addEntry(name, email, phone);
		System.out.println("Entry correctly saved");
		
	}
	
	private void selectedSearch() {
		String name = getInput("Input the exact name of the person you want to search:");
		AdressBookEntry entry = book.searchEntryWithName(name);
		
		// Searched entry exists
		if (entry != null) {
			System.out.println("This is the entry's available info:");
			System.out.println("* Name: " + entry.getName());
			System.out.println("* Email: " + entry.getEmail());
			System.out.println("* Phone: " + entry.getPhone());
		} else System.out.println("The specified entry couldn't be found.");
	}
	
	private String getInput(String initial) {
		Input in = new Input();

		while (true) {
			System.out.println(initial);
			if (in.hasNextLine()) {
				return in.nextLine();
			}
		}
	}
}
