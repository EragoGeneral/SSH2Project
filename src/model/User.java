package model;

public class User {

	private int ID;
	private String FirstName;
	private String LastName;
	private String Phone;
	private String Email;
	
	public User(){
	}
	
	public User(int ID, String firstName, String lastName, String phone, String email) {
		super();
		this.ID = ID; 
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Phone = phone;
		this.Email = email;
	}
	
	public User(String firstName, String lastName, String phone, String email) {
		super();
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Phone = phone;
		this.Email = email;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
}
