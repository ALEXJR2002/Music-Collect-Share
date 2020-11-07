package ui;
import java.util.Scanner;
import model.MCS;
public class Main{
	//CONSTANTS
	private final int EXIT = 0;
	private final int REGISTER_USER = 1;
	private final int LIST_USERS = 2;
	private final int REGISTER_SONG = 3;
	private final int LIST_SONGS = 4;
	private final int REGISTER_PLAYLIST = 5;
	private final int LIST_PLAYLIST = 6;
	private final int RATE_PLAYLIST = 7;
	private final int ADD_SONGS_TO_PLAYLIST = 8;
	
	
	private Scanner sc = new Scanner(System.in);
	private MCS mcs = new MCS();
	private static String logo = "\n((((((((((((((((((((((((((((((((((((((((((((((((("+
	"\n((((((((((((((((/(((((((((((((((((((((((((((((((("+
	"\n(((/  .(((((((*  .((((((*        (((((/      /((("+
	"\n(((/   .((((((.  .(((((   ,((((((((((*  .(((((((("+
	"\n(((/    /((((/   .((((/  ,(((((((((((.  /(((((((("+
	"\n(((/     ((((*   .((((*  ,(((((((((((/   (((((((("+
	"\n(((/  *  *(((     ((((*  ,((((((((((((,  .((((((("+
	"\n(((/  /.  ((*     ((((*  *(((((((((((((,   (((((("+
	"\n(((/  //  ,(  .   ((((*  *((((((((((((((/   /(((("+
	"\n(((/  *(*  ,  (   ((((*  *((((((((((((((((   /((("+
	"\n(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   ((("+
	"\n(((/  .((    ((   /((((  .(((((((((((((((((.  /(("+
	"\n(((/  .((.  .((.  *((((,  *((((((((((((((((   /(("+
	"\n(((/  .((((((((.  *(((((   *((((/,/(((((((/   ((("+
	"\n(((/  .((((((((.  *((((((.        *((   .   .(((("+
	"\n(((((((((((((((/*/((((((((((///(((((((////((((((("+
	"\n((((((((((((((((((((((((((((((((((((((((((((((((("+
	"\n               ./(###((///((###(*                "+
	"\n           *#(,                   *((,           "+
	"\n        ,#/                           ((         "+
	"\n        ,#/                           ((         "+
	"\n     *(.      .//////////////////*       *#      "+
	"\n    .#,     *///////////////////////,     /(     "+
	"\n    /(    *///////////////////////////    .#.    "+
	"\n  ,/////,*/////////////////////////////,*////*.  "+
	"\n  /////////////////////////*,...,/////////////,  "+
	"\n  //////*,,,********,,.............,,,,,//////,  "+
	"\n  //////*.........//*........//*.......,//////,  "+
	"\n  //////*.........,,.........,,........,//////,  "+
	"\n  //////*..............................,//////,  "+
	"\n   *///*  ........,/.........**.......  .*///,   "+
	"\n            .......,/*.....,/*.......            "+
	"\n               ........,,,,.......               "+
	"\n                    .........                    "+
	"\n"+
	"\n*************************************************";
	
	public static void main (String[]args){
		System.out.println(logo);
		Main m;
		m = new Main();
		m.startProgram();
		
	}
	/**
	* Start the program with the menu.<br>
	* <b>post:</b> Has initiated the menu. 
	* <b>post:</b> Has done the required operations. 
	*/
	public void startProgram(){
		int option;
			do{
				showMenu();
				option = readOption();
				doOperation(option);
			} while(option > 0);
	}
	/**
	* Show the program menu.<br>
	* <b>pre:</b> startProgram method should have been initializated first. <br>
	* <b>post:</b> Show the program menu.
	*/
	public void showMenu (){
		System.out.println("[1] Agregar un usuario.\n" +
							"[2] Listar los usuarios.\n" +
							"[3] Agregar una cancion.\n" +
							"[4] Listar las canciones.\n" +
							"[5] Agregar una Playlist.\n" +
							"[6] Listar las playlist\n" +
							"[7] Calificar una playlist publica\n" +
							"[8] Agregar una cancion a una playlist\n" +
							"[0] Salir");
	}
	/**
	* Read the option selected by the user.<br>
	* <b>pre:</b> showMeny method should have been initializated first. <br>
	* <b>post:</b> Has read the option given by user. 
	* @return An integer with the user choice.
	*/
	public int readOption(){
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println("\n");
		return choice;
	}/**
	* Select what operation must be done.<br>
	* <b>pre #1:</b> readOption method should have been initializated. <br>
	* <b>pre #2:</b> The user choice is an integer number. <br>
	* <b>post:</b> Has executed the required operation.
	* @param choice Choice made by the user. choice &lt;= 8, choice &gt;= 0.
	*/
	public void doOperation(int choice){
		switch (choice){
			case EXIT:
				System.out.println("Adios!");
				break;
			case REGISTER_USER:
				addUserData();
				break;
			case LIST_USERS:
				if (mcs.countUserExistence() > 0)
					listUserData();
				else 
					System.out.println("No existen usuarios para mostrar. Cree primero un usuario.");
				break;
			case REGISTER_SONG:
				if (mcs.countUserExistence() > 0){
					addSongData();
				}else
				System.out.println("No existen usuarios para crear canciones. Cree un usuario primero.");
				break;
			case LIST_SONGS:
				if(mcs.countSongsExistence() > 0)
					listSongsData();
				else 
					System.out.println("No existen canciones para mostrar. Agregue una cancion primero.");
				break;
			case REGISTER_PLAYLIST:
				choosePlaylistType();
				break;
			case LIST_PLAYLIST:
				if (mcs.countPlaylistsExistence() > 0)
					listPlaylistsData();
				else 
					System.out.println("No existen playlist para mostrar. Cree primero una playlist.");
				break;
			case RATE_PLAYLIST:
				if (mcs.checkPublicExistence())
					ratePublicPlaylist();
				else 
					System.out.println("No existen playlist publicas para calificar. Primero cree una.");
				break;
			case ADD_SONGS_TO_PLAYLIST:
				if(mcs.countSongsExistence() > 0)
					addSongToPlaylist();
				else 
					System.out.println("No existen canciones para agregar a una playlist. Agregue una cancion primero.");
				break;
			default:
				System.out.println("Ingresa una opcion valida");
		}
	}
	/**
	* Add a user with the whole required data.<br>
	* <b>pre #1:</b> doOperation method should have been initializated first. <br>
	* <b>post:</b> Has added a new user. 
	*/
	public void addUserData (){
		System.out.print("Ingrese su nombre de usuario: ");
		String username = sc.nextLine();
		System.out.print("Ingrese una contrasena: ");
		String password = sc.nextLine();
		System.out.print("Ingrese su edad: ");
		String age = sc.nextLine();
		System.out.println(mcs.addUser(username, password, age));
		
	}
	/**
	* Show the existing users in a list.<br>
	* <b>pre:</b> doOperation method should have been initializated first. <br>
	* <b>post:</b> Has shown the whole existing users in the program. 
	*/
	public void listUserData (){
		System.out.println(mcs.showUsers());
	}
	/**
	* Add a song with the whole required data.<br>
	* <b>pre #1:</b> doOperation method should have been initializated first. <br>
	* <b>post:</b> Has added a new song. 
	*/
	public void addSongData (){
			System.out.print("Ingrese el titulo de la cancion: ");
			String title = sc.nextLine();
			System.out.print("Ingrese el nombre del artista: ");
			String artistName = sc.nextLine();
			System.out.print("Ingrese la fecha de lanzamiento: ");
			String releaseDate = sc.nextLine();
			System.out.print("Ahora ingrese la duracion. \n Minutos: ");
			int minute = sc.nextInt(); sc.nextLine();
			System.out.print("Segundos: ");
			int seconds = sc.nextInt(); sc.nextLine();
			System.out.println("Escoja un genero de la lista para la cancion:\n" +
							"(1)ROCK\t\t(2)HIP HOP\t(3)MUSICA CLASICA\n" +
							"(4)REGGAE\t(5)SALSA\t(6)METAL\n" +
							"(7)POP");
			int optionGenre = sc.nextInt(); sc.nextLine();
			System.out.println("Escoja el usuario que va a agregar la cancion (Numero): ");
			System.out.println("\n" + mcs.showUsers());
			int optionUser = sc.nextInt();sc.nextLine();
			System.out.println(mcs.addSong(title, artistName, releaseDate, minute, seconds, optionGenre, optionUser));
	}
	/**
	* Show the existing songs in a list.<br>
	* <b>pre:</b> doOperation method should have been initializated first. <br>
	* <b>post:</b> Has shown the whole existing songs in the program. 
	*/
	public void listSongsData(){
		System.out.println(mcs.showSongs());
	}
	/**
	* Execute an operation with the option selected by the user.<br>
	* <b>pre #1:</b> doOperation method should have been initializated first. <br>
	* <b>post:</b> Has initializated executePlaylistOperation method
	*/
	public void choosePlaylistType(){
		int option = 0;
		do {
			System.out.println("¿Que playlist desea crear?"+
								"\n[1] PLaylist Privada"+
								"\n[2] Playlist Restringida"+
								"\n[3] Playlist Publica");
			option = sc.nextInt(); sc.nextLine();
			executePlaylistOperation(option);
		}while (option < 1 && option > 3);
	}
	/**
	* Execute the required operation to create a playlist<br>
	* <b>pre #1:</b> choosePlaylistType method should have been initializated first. <br>
	* <b>pre #2:</b> Option is an integer value <br>
	* <b>post:</b> Has executed the required playlist creation method
	* @param option Option selected by the user. option &lt;= 3, option &gt;= 1.
	*/
	public void executePlaylistOperation(int option){
		switch (option){
			case 1:
				if (mcs.countUserExistence() > 0)
					addPrivatePlaylistData();
				else
					System.out.println("No existe usuario alguno para crear la playlist. Cree uno primero.");
				break;
			case 2:
				if (mcs.countUserExistence() >= 5)
					addRestrictedPlaylistData();				
				else 
					System.out.println("No existen usuarios suficientes para crear la playlist. Deben haber al menos 5 usuarios para crearla.");
				break;
			case 3:
				addPublicPlaylistData();
				break;
			default:
			System.out.print("Ingrese un numero correspondiente al tipo de playlist que desea crear: ");
		}
	}
	/**
	* Add a private playlist with the whole required data.<br>
	* <b>pre #1:</b> executePlaylistOperation method should have been initializated first. <br>
	* <b>post:</b> Has added a new private playlist. 
	*/
	public void addPrivatePlaylistData(){
		System.out.print("Ingrese el nombre para la playlist: ");
		String name = sc.nextLine();
		System.out.println("Escoja el propietario de la playlist:");
		listUserData();
		System.out.print("=>");
		int userOption = sc.nextInt(); sc.nextLine();
		System.out.println(mcs.addPrivatePlaylist (name, userOption));
	}
	/**
	* Add a restricted playlist with the whole required data.<br>
	* <b>pre #1:</b> executePlaylistOperation method should have been initializated first. <br>
	* <b>post:</b> Has added a new restricted playlist. 
	*/
	public void addRestrictedPlaylistData(){
		System.out.print("Ingrese el nombre para la playlist: ");
		String name = sc.nextLine();
		System.out.println("Escoja los usuarios que seran propietarios de la playlist:");
		listUserData();
		System.out.print("Primer Usuario: ");
		int position1 = sc.nextInt(); sc.nextLine();
		System.out.print("Segundo Usuario: ");
		int position2 = sc.nextInt(); sc.nextLine();
		System.out.print("Tercer Usuario: ");
		int position3 = sc.nextInt(); sc.nextLine();
		System.out.print("Cuarto Usuario: ");
		int position4 = sc.nextInt(); sc.nextLine();
		System.out.print("Quinto Usuario: ");
		int position5 = sc.nextInt(); sc.nextLine();
		System.out.println(mcs.addRestrictedPlaylist(name, position1, position2, position3, position4, position5));
	}
	/**
	* Add a public playlist with the whole required data.<br>
	* <b>pre #1:</b> executePlaylistOperation method should have been initializated first. <br>
	* <b>post:</b> Has added a new public playlist. 
	*/
	public void addPublicPlaylistData(){
		System.out.print("Ingrese el nombre para la playlist: ");
		String name = sc.nextLine();
		System.out.println(mcs.addPublicPlaylist(name));
	}
	/**
	* Show the existing playlist in a list.<br>
	* <b>pre:</b> doOperation method should have been initializated first. <br>
	* <b>post:</b> Has shown the whole existing playlist in the program. 
	*/
	public void listPlaylistsData(){
		System.out.println(mcs.showPlaylists());
	}
	public void ratePublicPlaylist(){
		System.out.println("Escoja una playlist publica para calificar:");
		System.out.println(mcs.showPublicPlaylists());
		System.out.print("=>");
		int playlistChosen = 0;
		do {
			playlistChosen = sc.nextInt(); sc.nextLine();
			if (mcs.checkOptionIsPublic(playlistChosen)){
				System.out.print("Nota: ");
				int score = sc.nextInt(); sc.nextLine();
				mcs.updateScore(playlistChosen, score);
			}
			else
				System.out.println("La playlist seleccionada no es public y, por tanto, no puede ser calificada. Intente nuevamente con una opcion valida.");
		}while (!mcs.checkOptionIsPublic(playlistChosen));
	}
	/**
	* Add a song to an existing playlist. <br>
	* <b>pre:</b> doOperation method should have been initializated first. <br>
	* <b>pre:</b> Playlist already exist. <br>
	* <b>post:</b> Has added a song to a selected playlist. 
	*/
	public void addSongToPlaylist(){
		System.out.println("Escoja la cancion que quiere agregar a la playlist (Numero): ");
		listSongsData();
		int songPosition = sc.nextInt(); sc.nextLine();
		System.out.println("Escoja la playlist a la que le va a agregar la cancion (Numero): ");
		listPlaylistsData();
		int playlistPosition = sc.nextInt(); sc.nextLine();
		System.out.println(mcs.addSongToPlaylist (songPosition, playlistPosition));
	}
	
	
}