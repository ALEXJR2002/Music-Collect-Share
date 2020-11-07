package model;

public class User{
	
	//CONSTANTS
	private static final int LITTLE_CONTRIBUTOR = 3;
	private static final int MILD_CONTRIBUTOR = 10;
	private static final int STAR_CONTRIBUTOR = 30;
	
	
	//Attributes
	private String username;
	private String password;
	private String age;
	private Category category; 
	private int sharedSongs;
	
	//Methods
	 //Constructor
	/**
	* Create a new User.<br>
	* <b>post:</b> Has created the user.
	* @param username The name the user has given. username != null, username != " ".
	* @param password The password the user has given. password != null, password != " ".
	* @param age The age the user has given. age != null, age != " ".
	*/
	public User (String username, String password, String age){
		this.username = username;
		this.password = password;
		this.age = age;
		category = Category.NEWBIE;
		sharedSongs = 0;
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
	public int getSharedSongs(){
		return sharedSongs;
	}
	 //End Get Methods
	 
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
	 //End Set Methods
	
	/**
	* Increase the shared songs number.<br>
	* <b>pre #1:</b> Shared songs is initializated (is not null). <br>
	* <b>post:</b> Has increased the shared songs number by one. 
	*/
	public void increaseSharedSongs(){
		sharedSongs++;
		updateCategoryState(sharedSongs);
	}
	/**
	* Update the category state.<br>
	* <b>pre #1:</b> Shared songs is initializated (is not null). <br>
	* <b>post:</b> Has changed the total value for the given store 
	* @param sharedSongs Shared songs quantity. sharedSongs != null, sharedSongs &gt;= 0.
	*/
	public void updateCategoryState(int sharedSongs){
		if (sharedSongs >= LITTLE_CONTRIBUTOR && sharedSongs < MILD_CONTRIBUTOR)
			category = Category.LITTLE_CONTRIBUTOR;
		else if (sharedSongs >= MILD_CONTRIBUTOR && sharedSongs < STAR_CONTRIBUTOR)
			category = Category.MILD_CONTRIBUTOR;
		else if(sharedSongs == STAR_CONTRIBUTOR)
			category = Category.STAR_CONTRIBUTOR;
	}
	/**
	* Show the iformation about a user.<br>
	* <b>pre:</b> The user attributes are initializated (are not null). <br>
	* <b>post:</b> Has shown the whole information about a user. 
	* @return A string with the required information.
	*/
	public String showInfo (){
		return "*************  User **************" +
				"\n**  UserName: " + getUsername() +
				"\n**  Age: " + getAge() +
				"\n**  Category: " + getCategory() +
				"\n***********************************";	
	}
	
	
}