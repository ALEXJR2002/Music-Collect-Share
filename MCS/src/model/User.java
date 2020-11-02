package model;
enum Category {
	NEWBIE, LITTLE_CONTRIBUTOR, MILD_CONTRIBUTOR, STAR_CONTRIBUTOR;
}
public class User{
	
	//Atributes
	private String username;
	private String password;
	private String age;
	private Category category; 
	
	//Methods
	 //Constructor
	public Users (String username, String password, String age, String category){
		this.username = username;
		this.password = password;
		this.age = age;
		this.category = Category.valueOf(category);
	}
	 
	 //Get
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getAge(){
		return age;
	}
	public Category getCategory(){
		return category;
	}
	 
	 //Set 
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setAge(String age){
		this.age = age;
	}
	public void setCategory(String category){
		this.category = Category.valueOf(category);
	}
	
	
}