package model;
public class MCS{
	
	//Attributes
	private static final int USER_NUMBER = 10;
	private static final int SONG_NUMBER = 30;
	private static final int PLAYLIST_NUMBER = 20;
	
	User users [];			//Relation
	Song songsPool [];		//Relation
	Playlist playlist [];	//Relation
	
	//Methods
	/**
	* Create a new MCS.<br>
	*/
	public MCS(){				//Constructor
		users = new User [USER_NUMBER];
		songsPool = new Song [SONG_NUMBER];
		playlist = new Playlist [PLAYLIST_NUMBER];
	}
	
	/**
	* Add a new user to the program.<br>
	* <b>pre #1:</b> The username is initializated (is not empty). <br>
	* <b>pre #2:</b> The password is initializated (is not empty). <br>
	* <b>pre #3:</b> The age is initializated (is not empty). <br>
	* <b>post:</b> Has added a new user. 
	* @param username The name the user wrote. username != null, username != " ".
	* @param password User password. password != null, password != " ".
	* @param age User age. age != null, age != " ".
	* @return A string with the required message.
	*/
	public String addUser(String username, String password, String age){
		String message = "";
		boolean exist = false;
		for (int i = 0; i < users.length && !exist; i++){
			if (users[i] == null){
				//if (!username.equals(users[i].getUsername())){
					users[i] = new User (username, password, age);
					exist = true;
					message = "Usuario creado exitosamente";
				//}else
					//message = "Este usuario ya existe. Intente nuevamente";
			}else
				message = "No se pueden crear mas usuarios.";	
			
		}
		return message;
	}
	/**
	* Add a new song to the program.<br>
	* <b>pre #1:</b> The title is initializated (is not empty). <br>
	* <b>pre #2:</b> The artist name is initializated (is not empty). <br>
	* <b>pre #3:</b> The release date is initializated (is not empty). <br>
	* <b>pre #4:</b> The song minutes is initializated (is not null). <br>
	* <b>pre #5:</b> The song seconds is initializated (is not null). <br>
	* <b>pre #6:</b> The option about the genre chosen by user is initializated (is not null). <br>
	* <b>pre #7:</b> The option about the user chosen by user is initializated (is not null). <br>
	* <b>post:</b> Has added a new song. 
	* @param title The title the user wrote. title != null, title != " ".
	* @param artistName Song artist name. artistName != null, artistName != " ".
	* @param releaseDate Song release date. releaseDate != null, releaseDate != " ".
	* @param minute Song minutes length. minute != null, minute &gt;= 0.
	* @param seconds Song seconds length. seconds != null, seconds &gt;= 0.
	* @param optionGenre The genre user choice number. optionGenre != null, optionGenre &gt;= 0.
	* @param optionUser The user choice number made by user. optionUser != null, optionUser &gt;= 0.
	* @return A string with the required message.
	*/
	public String addSong(String title, String artistName, String releaseDate, int minute, int seconds, int optionGenre, int optionUser){
		String message = "";
		boolean exist = false;
		for (int i = 0; i < songsPool.length && !exist; i++){
			
			if (songsPool[i] != null && title.equalsIgnoreCase(songsPool[i].getTitle())){
				message = "Esta cancion ya existe. Intente añadiendo otra cancion";
				exist = true;
			}
			else if (songsPool[i] == null){
					songsPool[i] = new Song (title, artistName, releaseDate, minute, seconds, optionGenre);
					exist = true;
					users[optionUser].increaseSharedSongs();
					message = "Cancion agregada exitosamente";
			}else if (i == songsPool.length)
				message = "No se pueden agregar mas canciones.";
		}
		return message;
	}
	/**
	* Add a new private playlist to the program.<br>
	* <b>pre #1:</b> The name is initializated (is not empty). <br>
	* <b>pre #2:</b> The user position is initializated (is not null). <br>
	* <b>post:</b> Has added a new private playlist. 
	* @param name The playlist name. name != null, name != " ".
	* @param userPosition The user position chosen by the user to be the playlist owner . userPosition != null, userPosition &gt;= 0.
	* @return A string with the required message.
	*/
	public String addPrivatePlaylist (String name, int userPosition){
		boolean created = false;
		String message = "";
		for (int i = 0; i < playlist.length && !created; i++){
			if (playlist[i] == null){
				playlist[i] = new PrivatePlaylist (name, users[userPosition]);
				created = true;
				message = "Playlist creada existosamente";
			}else 
				message = "No se pueden crear mas playlist.";
		}
		return message;
	}
	/**
	* Add a new restricted playlist to the program.<br>
	* <b>pre #1:</b> The name is initializated (is not empty). <br>
	* <b>pre #2:</b> The position 1 is initializated (is not null). <br>
	* <b>pre #3:</b> The position 2 is initializated (is not null). <br>
	* <b>pre #4:</b> The position 3 is initializated (is not null). <br>
	* <b>pre #5:</b> The position 4 is initializated (is not null). <br>
	* <b>pre #6:</b> The position 5 is initializated (is not null). <br>
	* <b>post:</b> Has added a new restricted playlist. 
	* @param name The playlist name. name != null, name != " ".
	* @param position1 The position 1 chosen by the user to be the first playlist owner. position1 != null, position1 &gt;= 0.
	* @param position2 The position 2 chosen by the user to be the second playlist owner. position2 != null, position2 &gt;= 0.
	* @param position3 The position 3 chosen by the user to be the third playlist owner. position3 != null, position3 &gt;= 0.
	* @param position4 The position 4 chosen by the user to be the fourth playlist owner. position4 != null, position4 &gt;= 0.
	* @param position5 The position 5 chosen by the user to be the fifth playlist owner. position5 != null, position5 &gt;= 0.
	* @return A string with the required message.
	*/
	public String addRestrictedPlaylist (String name, int position1, int position2, int position3, int position4, int position5){
		String message = "";
		boolean created = false;
		User ownerUsers [] = {users[position1], users[position2], users[position3], users[position4], users[position5]};
		for (int i = 0; i < playlist.length && !created; i++){
			if (playlist[i] == null){
				playlist[i] = new RestrictedPlaylist (name, ownerUsers);
				created = true;
				message = "Playlist creada exitosamente";
			}else 
				message = "No se pueden crear mas playlist.";
		}
		return message;
	}
	/**
	* Count how many users do exist.<br>
	* <b>pre #1:</b> The users array should have at least one user created. <br>
	* <b>post:</b> Has calculated the total users number.
	* @return An Integer number representing the users quantity.
	*/
	public int countUserExistence(){
		int userCounter = 0;
		for (int c = 0; c < users.length; c++){
			if (users[c] != null)
				userCounter++;
		}
		return userCounter;
	}
	/**
	* Count how many songs do exist.<br>
	* <b>pre #1:</b> The songsPool array should have at least one song created. <br>
	* <b>post:</b> Has calculated the total songs number.
	* @return An Integer number representing the songs quantity.
	*/
	public int countSongsExistence(){
		int songsCounter = 0;
		for (int c = 0; c < songsPool.length; c++){
			if (songsPool[c] != null)
				songsCounter++;
		}
		return songsCounter;
	}
	/**
	* Count how many playlists do exist.<br>
	* <b>pre #1:</b> The playlist array should have at least one playlist created. <br>
	* <b>post:</b> Has calculated the total playlist number.
	* @return An Integer number representing the playlist quantity.
	*/
	public int countPlaylistsExistence(){
		int playlistCounter = 0;
		for (int c = 0; c < playlist.length; c++){
			if (playlist[c] != null)
				playlistCounter++;
		}
		return playlistCounter;
	}
	/**
	* Add a new private playlist to the program.<br>
	* <b>pre:</b> The name is initializated (is not empty). <br>
	* <b>post:</b> Has added a new public playlist. 
	* @param name The playlist name. name != null.
	* @return A string with the required message.
	*/
	public String addPublicPlaylist (String name){
		boolean created = false;
		String message = "";
		for (int i = 0; i < playlist.length && !created; i++){
			if (playlist[i] == null){
				playlist[i] = new PublicPlaylist (name);
				created = true;
				message = "Playlist creada exitosamente.";
			}else 
				message = "No se pueden crear mas playlist.";
		}
		return message;
	}
	/**
	* Show the existing users in a list.<br>
	* <b>pre:</b> The users array should have at least one user created (is not null). <br>
	* <b>post:</b> Has shown the whole existing users . 
	* @return A string with the required message.
	*/
	public String showUsers () {
		String message = "";
		for (int c = 0; c < users.length; c++){
			if (users[c] != null)
				message += "\n[" +  c + "]\n" + users[c].showInfo();
		}
		return message;
	}
	/**
	* Show the existing songs in a list.<br>
	* <b>pre:</b> The songsPool array should have at least one song created (is not null). <br>
	* <b>post:</b> Has shown the whole existing songs . 
	* @return A string with the required message.
	*/
	public String showSongs (){
		String message = "";
		for (int c = 0; c < songsPool.length; c++){
			if (songsPool[c] != null)
				message += "\n[" + c + "]\n" + songsPool[c].showInfo();
		}
		return message;
	}
	/**
	* Show the existing playlist in a list.<br>
	* <b>pre:</b> The playlist array should have at least one playlist created (is not null). <br>
	* <b>post:</b> Has shown the whole existing playlists . 
	* @return A string with the required message.
	*/
	public String showPlaylists (){
		String message = "";
		for (int c = 0; c < playlist.length; c++){
			if (playlist[c] != null)
				message += "\n[" + c + "]\n" + playlist[c].showInfo();
		}
		return message;
		
	}
	/**
	* Show the existing public playlist in a list.<br>
	* <b>pre:</b> The playlist array should have at least one public playlist created (is not null). <br>
	* <b>post:</b> Has shown the whole existing public playlists . 
	* @return A string with the required message.
	*/
	public String showPublicPlaylists (){
		String message = "";
		for (int c = 0; c < playlist.length; c++){
			if (playlist[c] != null && playlist[c] instanceof PublicPlaylist)
				message += "\n[" + c + "]\n" + playlist[c].showInfo();	
		}
		return message;
		
	}
	/**
	* Check if public playlist do exist.<br>
	* <b>pre #1:</b> The playlist array should have at least one playlist created. <br>
	* <b>post:</b> Has checked if a public playlist do exist.
	* @return An boolean value representing the public playlist state.
	*/
	public boolean checkPublicExistence (){
		boolean exist = false;
		for (int i = 0; i < playlist.length && !exist; i++ ){
			if (playlist[i] instanceof PublicPlaylist)
				exist = true;
		}
			
		return exist;
	}
	/**
	* Check if the selected playlist is public.<br>
	* <b>pre #1:</b> The playlist in the referenced position is initializated (is not null). <br>
	* <b>post:</b> Has checked if the playlist at the position is a public playlist.
	* @param playlistPosition The playlist position in the playlist array. playlistPosition != null, playlistPosition &gt;= 0.	
	* @return An boolean value representing verification state.
	*/
	public boolean checkOptionIsPublic(int playlistPosition){
		boolean isPublic = false;
		if (playlist[playlistPosition] instanceof PublicPlaylist)
			isPublic = true;
		return isPublic;
	}
	/**
	* Update the public playlist score.<br>
	* <b>pre #1:</b> The store array is initialized (is not null). <br>
	* <b>pre #2:</b> The playlist position is not null. <br>
	* <b>pre #3:</b> The score is not null and greater than 0. <br>
	* <b>post:</b> Has updated public playlist calification. 
	* @param playlistPosition The position used to search the public playlist. playlistPosition != null, playlistPosition &gt;= 0.
	* @param score Score given by the user. score != null, score &gt;= 0.
	* @return A string with the required message.
	*/
	public String updateScore (int playlistPosition, int score){
		PublicPlaylist chosenPlaylist = (PublicPlaylist) playlist[playlistPosition];
		chosenPlaylist.ratePlaylist(score);
		return "Puntaje Actualizado :)";
	}
	/**
	* Add a existing song to a playlist.<br>
	* <b>pre #1:</b> Do exist at least one song. <br>
	* <b>pre #2:</b> Do exist at least one playlist. <br>
	* <b>post:</b> Has added a song to a playlist. 
	* @param songPosition The song position in the songsPool array. songPosition != null, songPosition &gt;=0.
	* @param playlistPosition The playlist position in the playlist array. playlistPosition != null, playlistPosition &gt;=0.
	* @return A string with the required message.
	*/
	public String addSongToPlaylist (int songPosition, int playlistPosition) {
		boolean added = false;
		String message = "";
		for (int i = 0; i < playlist[playlistPosition].getPlaylistSongs().length && !added; i++){
			if (playlist[playlistPosition].getPlaylistSongs()[i] == null){
				playlist[playlistPosition].getPlaylistSongs()[i] = songsPool[songPosition];
				playlist[playlistPosition].sumLength();
				added = true;
				message = "Cancion agregada existosamente";
			}else 
				message = "No se pueden agregar mas canciones.";
		}
		return message;
	}
	
	
	
}