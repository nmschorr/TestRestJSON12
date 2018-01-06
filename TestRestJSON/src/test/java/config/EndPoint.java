package config;

public interface EndPoint {

    String VIDEOGAMES = "/videogames";
    String SINGLE_VIDEOGAME = "/videogames/{videoGameId}";
    
    String ALBUMBASE = "/albums";
    String SINGLE_ALBUMS = "{ALBUMBASE}/{albumId}/";
    //String SINGLE_ALBUM1 = "{ALBUMBASE}/1/";
    String SINGLE_ALBUM1 = "/albums/1/";
    String SINGLE_ALBUM = "/1/";
}
