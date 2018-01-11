package config;

public interface EndPoint {
	public int[] myTestList = { 7 };  // edit this list
	//public int[] myTestList = {  1, 2, 3, 4 };  // edit this list

    String ALBUMBASE = "/albums";
    String SINGLE_ALBUMS = "{ALBUMBASE}/{albumId}/";
    String MOVIE_EP = "/movies";
}
