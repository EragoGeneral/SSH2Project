package model;

public class User {

	private String FirstName;
	private String LastName;
	private String Phone;
	private String Email;
	
	public User(String firstName, String lastName, String phone, String email) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Phone = phone;
		Email = email;
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
