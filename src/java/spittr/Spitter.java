package spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {

	private Long id;
	
	@NotNull
	@Size(min=2,max=20)
	private String firstName;
	
	@NotNull
	@Size(min=2,max=20)
	private String lastName;
	
	@NotNull
	@Size(min=2,max=20)
	private String username;
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@NotNull
	@Size(min=2,max=20)
	private String password;
	
	public Spitter(String firstName,String lastName,String username,String password){
		this.firstName=firstName;
		this.lastName=lastName;
		this.username=username;
		this.password=password;
		this.id=null;
	}
	
	public Spitter(){
		
	}
}
