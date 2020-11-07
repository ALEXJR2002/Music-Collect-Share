package model;

public class Song{
	
	//Attributes
	private String title;
	private String artistName;
	private String releaseDate;
	int [] length;
	private Genre genre;
	
	//Methods
	 //Constructor
	/**
	* Create a new Song.<br>
	* <b>post:</b> Has created the song.
	* @param title The title the user has given. title != null, title != " ".
	* @param artistName The artist name the user has given. artistName != null, artistName != " ".
	* @param releaseDate The release date the user has given. releaseDate != null, releaseDate != " ".
	* @param minute The length in minutes the user has given. minute != null, minute &gt;= 0.
	* @param seconds The length in seconds the user has given. seconds != null, seconds &gt;= 0.
	* @param optionGenre The genre the user has chosen. optionGenre != null, optionGenre &gt;= 0, optionGenre &lt;= 0.
	*/
	public Song (String title, String artistName, String releaseDate,  int minute, int seconds, int optionGenre){
		this.title = title;
		this.artistName = artistName;
		this.releaseDate = releaseDate;
		length = new int [2];
		length[0] = minute;
		length[1] = seconds;
		
		switch(optionGenre){
			case 1:
				genre = Genre.ROCK;
				break;
			case 2:
				genre = Genre.HIP_HOP;
				break;
			case 3:
				genre = Genre.CLASSIC;
				break;
			case 4:
				genre = Genre.REGGAE;
				break;
			case 5:
				genre = Genre.SALSA;	
				break;
			case 6:
				genre = Genre.METAL;
				break;
			case 7:
			 	genre = Genre.POP;
				break;
		}
	}
	
	 //Get 
	public String getTitle (){
		return title;
	}
	public String getArtistName (){
		return artistName;
	}
	public String getReleaseDate (){
		return releaseDate;
	}
	public int [] getLength (){
		return length;
	}
	public Genre getGenre (){
		return genre;
	}
	 //End Get Methods
	
	/**
	* Show the iformation about a song.<br>
	* <b>pre:</b> The song attributes are initializated (are not null). <br>
	* <b>post:</b> Has shown the whole information about a song. 
	* @return A string with the required information.
	*/
	public String showInfo (){
		return "**************  Song **************" +
		"\n**  Title: " + title +
		"\n**  Artist: " + artistName +
		"\n**  Duration: " + length[0] + ":" + length[1] +
		"\n**  Genre: " + genre.toString() +
		"\n***********************************";
	}
	 
	
}