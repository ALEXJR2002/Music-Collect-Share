package model;
public class PublicPlaylist extends Playlist{
	
	//Attributes
	int score;
	
	//Methods
	 //Constructor
	/**
	* Create a new public Playlist.<br>
	* <b>post:</b> Has created the public playlist.
	* @param name The name of the playlist the user has given. name != null, name != " ".
	*/
	public PublicPlaylist (String name){
		super(name);
		score = 0;
	}
	public PublicPlaylist (String name, int score){
		super (name);
		this.score = score;
	}
	 //Get 
	public int getScore (){
		return score;
	}
	 //Set
	public void setScore (int score){
		this.score = score;
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
		"\n**  Calification: " + score;
	}	
	/**
	* Rate the public playlist.<br>
	* <b>pre #1:</b> Score is initializated (is not null). <br>
	* <b>post:</b> Has change the calification. 
	* @param score The score given by the user. score != null, score &gt;= 0, score &lt;= 5.
	*/
	public void ratePlaylist (int score){
		this.score += score;
		if (this.score != score)
			this.score = (int) this.score/2;
	}
}