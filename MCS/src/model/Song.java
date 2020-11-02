package model;
public class Song{
	
	//Atributes
	private String title;
	private String artistName;
	private String releaseDate;
	int [] length;
	private String genre;
	
	//Methods
	 //Constructor
	public Song (String title, String artistName, String releaseDate, String genre){
		this.title = title;
		this.artistName = artistName;
		this.releaseDate = releaseDate;
		this.genre = genre;
		length = new int [2];
	}
	public Song (String title, String artistName, String releaseDate, String genre, int [] length){
		this.title = title;
		this.artistName = artistName;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.length = length;
	}
	 // 
	
	
}