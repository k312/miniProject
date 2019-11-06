package DTO;

public class UserDTO {
	private String id;
	private String password;
	private String residence;
	
	
	
	public UserDTO() {}
	
	
	public UserDTO(String id, String password, String residence) {
		super();
		this.id = id;
		this.password = password;
		this.residence = residence;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	

}
