import java.util.ArrayList;

public class AdressBook {
	
	private ArrayList<AdressBookEntry> entries = new ArrayList<>();
	
	public void addEntry(String name, String email, String phone) {
		AdressBookEntry entry = new AdressBookEntry(name, email, phone);
		entries.add(entry);
	}
	
	public AdressBookEntry searchEntryWithName(String name) {
		for (AdressBookEntry entry : entries) {
			if (entry.getName().equals(name)) return entry;
		}
		return null;
	}
	
	public boolean deleteEntryWithName(String name) {
		// Entry exists in adress book
		AdressBookEntry toDel = searchEntryWithName(name);
		if (toDel != null) {
			entries.remove(toDel);
			return true;
		} else return false;
	}
	
}
