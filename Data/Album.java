package Data;
public class Album {
	private String title;
	private String artist;
	private String genre;  
// Constructors
public Album() {}
public Album(String title, String artist, String genre) {}
// Getters and Setters

public String getTitle(){
	return this.title;
}

public String getArtist(){
	return this.artist;
}

public String getGenre(){
	return this.genre;
}

public void setTitle(String name){
	this.title=name;
}

public void setArtist(String singer){
	this.artist = singer;
}

public void setGenre(String genres){
	this.genre = genres;
}

//toString()
public String toString() {
   return "Album{title=" + title + ", artist=" + artist + ", genre=" + genre +"}";
}
    
}
