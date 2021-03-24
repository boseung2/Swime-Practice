package dao;


public class User {
	private String id , password , name , email ;

	public User() {
//		this("insertUser","1234","³²±Ã¼º","aaa@aaa.com");
		this(null, null, null, null);
	}

	public User(String id, String password, String name, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("id = %s, password = %s, name = %s, email = %s", id, password, name, email);
	}

}
