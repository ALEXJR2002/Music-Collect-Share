package model;
public class RestrictedPlaylist extends Playlist{
	
	//Attributes
	User ownerUsers [] = new User [5];		
	
	//Methods
	/**
	* Create a new restricted Playlist.<br>
	* <b>post:</b> Has created the restricted playlist.
	* @param name The name of the playlist the user has given. name != null, name != " ".
	* @param ownerUsers The users that own the restricted playlist. ownerUsers != null.
	*/
	public RestrictedPlaylist (String name, User [] ownerUsers){
		super(name);
		this.ownerUsers = ownerUsers;
	}
	public String getOwnersName (){
		boolean isNull = false;
		String info = "";
		for (int i = 0; i < ownerUsers.length && !isNull; i++ ){
			if (ownerUsers[i] != null)
				info += ownerUsers[i].getUsername() + ", ";
			else 
				isNull = true;	
		}
		return info;
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
		"\n**  Owners: " + getOwnersName();
	}
}