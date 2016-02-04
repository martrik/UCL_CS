
public class AdressBookEntry {
	
	private String name = new String();
	private String email = new String();
	private String phone = new String();
	
	public AdressBookEntry(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}

}
