package JSONObjectStudy;

public class User {
	
	private String name;
	private String gender;
	private int age;

//	public User(String name, String gender, int age) {
//		this.name = name;
//		this.gender = gender;
//		this.age = age;
//	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
		
	}
}

