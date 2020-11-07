package model;
public abstract class Playlist{
	//Attributes
	private String name;
	int length [];
	Song playlistSongs [];
	
	//Methods
	 //Constructor
	/**
	* Create a new Playlist.<br>
	* <b>post:</b> Has created the playlist.
	* @param name The name of the playlist the user has given. name != null, name != " ".
	*/
	public Playlist (String name){
		this.name = name;
		length = new int [2];
		playlistSongs = new Song [30];
		
	}
	 //Get 
	public String getName (){
		return name;
	}
	public int [] getLength () {
		return length;
	}
	public Song [] getPlaylistSongs () {
		return playlistSongs;
	}
	 //Set 
	public void setName (String name){
		this.name = name;
	}
	public void setLength (int [] length) {
		this.length = length;
	}
	
	/**
	* Get the songs genre and retrurn it.<br>
	* <b>pre:</b> The playlist songs array is created (is not null). <br>
	* <b>post:</b> Has got the songs genre. 
	* @return A string with the songs genres.
	*/
	public String getSongsGenre (){
		String info = "";
		for (int i = 0; i < playlistSongs.length; i++ ){
			if (playlistSongs[i] != null)
				info += playlistSongs[i].getGenre().toString() + ", ";	
		}
		return info;
	}
	/**
	* Show the iformation about a playlist.<br>
	* <b>pre:</b> The playlist attributes are initializated (are not null). <br>
	* <b>post:</b> Has shown the whole information about a playlist. 
	* @return A string with the required information.
	*/
	public String showInfo (){
		return "**************  Playlist **************" +
		"\n**  Title: " + name +
		"\n**  Duration: " + length[0] + ":" + length[1] +
		"\n**  Genre: " + defineGenreState();
		
	}
	/**
	* Define if the genre is unknown or a concrete genre.<br>
	* <b>pre:</b> A playlist is created (is not null). <br>
	* <b>post:</b> Has defined the genre state. 
	* @return A string with the genres or an unknown state.
	*/
	public String defineGenreState(){
		boolean exist = false;
		String message = "";
		for (int i = 0; i < playlistSongs.length && !exist; i++){
			if (playlistSongs[i] != null){
				message = getSongsGenre();
				exist = true;
			}else
				message = "Unknown";
		}
		return message;
	}
	
	/**
	* Sum the songs lengths up.<br>
	* <b>pre #1:</b> The playlist songs array is initialized (is not null). <br>
	* <b>post:</b> Has sum the total songs lengths up and change the length array values.
	*/
	public void sumLength (){
		int minutes = 0;
		int seconds = 0;
		for (int i = 0; i < playlistSongs.length; i++){
			if (playlistSongs[i] != null){
				minutes += playlistSongs[i].getLength()[0];
				seconds += playlistSongs[i].getLength()[1];
			}
		}
		minutes += (int) seconds/60;
		seconds = seconds%60;
		length[0] = minutes;
		length[1] = seconds;
		
	}
	
}