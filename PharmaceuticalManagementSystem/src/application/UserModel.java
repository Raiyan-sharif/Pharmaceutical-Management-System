package application;

public class UserModel {
	private int id;
	private String name;
	private String password;
	private String emp_id;
	private String gender;
	private String roll;
	private String status;
	public UserModel(int id, String name, String password, String emp_id, String gender, String roll, String status) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.emp_id = emp_id;
		this.gender = gender;
		this.roll = roll;
		this.status = status;
	}
//	public UserModel(int id, String name, String emp_id, String gender, String roll, String status) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.emp_id = emp_id;
//		this.gender = gender;
//		this.roll = roll;
//		this.status = status;
//	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
