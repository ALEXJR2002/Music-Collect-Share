package model;

public class PrivatePlaylist extends Playlist{
	
	//Attributes
	User owner;
	
	//Methods
	 //Constructor 
	/**
	* Create a new private Playlist.<br>
	* <b>post:</b> Has created the private playlist.
	* @param name The name of the playlist the user has given. name != null, name != " ".
	* @param owner The owner of the private playlist the user has given. owner != null.
	*/
	public PrivatePlaylist (String name, User owner){
		super(name);
		this.owner = owner;
	}
	 //Get
	public User getOwner (){
		return owner;
	}
	/**
	* {@inheritDoc}
	*/
	@Override 
	public String showInfo (){
		return "**************  Playlist **************" +
		"\n**  Title: " + getName() +
		"\n**  Duration: " + length[0] + ":" + length[1] +
		"\n**  Genre: " + defineGenreState() +
		"\n**  Owner: " + owner.getUsername();
		
	}
}