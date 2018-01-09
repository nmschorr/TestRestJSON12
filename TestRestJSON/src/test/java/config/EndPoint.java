package config;

public interface EndPoint {

    String VIDEOGAMES = "/videogames";
    String SINGLE_VIDEOGAME = "/videogames/{videoGameId}";
    
    String ALBUMBASE = "/albums";
    String SINGLE_ALBUMS = "{ALBUMBASE}/{albumId}/";
    
    String BLOB_ENDPOINT = "53998288-f328-11e7-8877-3d11de9ec1d3";   //  "/ff731071-8808-4855-91e8-954f2c8fd0d7";
    String MY_EP = "/db";
}
