/* TestRestJSON by Nancy Schorr, 2016/2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Also goes to url https://jsonblob.com/53998288-f328-11e7-8877-3d11de9ec1d3 and reads the data and store it in various objects.
 2018 : added rest assured.
 */
package com.nmschorr;

import config.TestConfig;
import config.EndPoint;
import org.json.JSONObject;
import java.util.*; 

import org.junit.Test;
import static io.restassured.RestAssured.*;
import  io.restassured.http.*;
import  io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import  io.restassured.specification.*;
import com.github.fge.jsonpatch.*;

public  class TestRestJSON extends TestConfig {
											public static String jsonAsString;
											public static String newPeep =  "{\"id\":0}";
										 public static String postLoc = EndPoint.BLOB_ENDPOINT;
									 

 		//------------------------------------- test 1 --------------------------------------
	//@Test					
										
	public void blobTest1()  {
		System.out.println("\n\n---------------Beginning blobTest1 Simple GET --------------------\n\n");
										 System.out.println("\n\n- --------------Fiddler must be running! -------------------- \n\n");
		
		String responseStr =			
				given().
				log().parameters().
				spec(blobSpec).
				when().
				get(EndPoint.BLOB_ENDPOINT).asString();
		
		System.out.println("responseStr:  "   + responseStr);
		int  a = 0;             // for dev

												//then().assertThat().body(containsString("nancy")).
												//and().body(containsString("a")).
	}

			//------------------------------------- test 2 --------------------------------------
	@Test
	public void blobTest2()  {
		System.out.println("\n\n---------------Beginning blobTest2 Fancy GET---------------------\n\n");
		
	    String MOK_ENDPOINT = "/ff731071-8808-4855-91e8-954f2c8fd0d7/view";
		Response responseFromJsonSite =			
				given().
				log().all().
				spec(newSpec).
				when().
				get(MOK_ENDPOINT);
				

		Headers headers = responseFromJsonSite.getHeaders();
		String contentType = responseFromJsonSite.getHeader("Content-Type");
		System.out.println("\n\n contentType blobTest2:   " + contentType);
		System.out.println("here is body:     "  + responseFromJsonSite.getBody().asString().toString()        );
	//	int  a = 1;  // for dev
	}

			//------------------------------------- test 3 --------------------------------------
	//@Test
	public void blobTest3()  {
		System.out.println("\n\n---------------Beginning blobTest3---------------------\n\n");
		
		given().log().all().
		spec(blobSpec).
		when().
		get(EndPoint.BLOB_ENDPOINT).
		then().log().all().
		assertThat().
		body(containsString("nancy"));
		//log().all();		
	}
	//------------------------------------- test 4 --------------------------------------
	//@Test
	public void blobTest4()  {

			System.out.println("\n\n---------------Beginning blobTest4---------------------\n\n");
			System.out.println("\n\n---------------Fiddler must be running! --------------------\n\n");

		
		String myString2 = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"MyNewGame5\",\n" +
                "  \"releaseDate\": \"2017-12-07T11:49:25.755Z\",\n" +
                "  \"reviewScore\": 45,\n" +
                "  \"category\": \"Driving55\",\n" +
                "  \"rating\": \"Mature5\"\n" +
                "}" +  "{\n" +
                "  \"id\": 2,\n" +
                "  \"name\": \"changedagain55533\",\n" +
                "  \"releaseDate\": \"2017-12-07T11:49:25.755Z\",\n" +
                "  \"reviewScore\": 45,\n" +
                "  \"category\": \"Driving55\",\n" +
                "  \"rating\": \"Mature5\"\n" +
                "}";
	
		String myStringP = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"patched\",\n" + "}";

                
                String myString7 = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"seven\",\n" +
                "  \"releaseDate\": \"2017-12-07T11:49:25.755Z\",\n" +
                "  \"reviewScore\": 45,\n" +
                "  \"category\": \"Driving55\",\n" +
                "  \"rating\": \"Mature5\"\n" +
                "}";
				 //System.out.println("\n  myString7: " + myStringBig + "\n\n");
																	Map<String, Object>  jsonAsMap = new HashMap<>();
																	jsonAsMap.put("name", "Test12");
																	jsonAsMap.put("title", "Test127123");
																	jsonAsMap.put("contactEmail", "x");
																	jsonAsMap.put("description", "testing purpose");
	
																	//		given().
																	//	        spec(blobSpec).
																	//	        body(myString2).
																	//		    when().
																	//		  //  post().
																	//		    then().
																	//		    log().all();
		
		//String repStr = "[   {\"replace\": \"/id\", \"value\": 5} ]";												    

		given().
        spec(blobSpec).
  //      body().
	    when().
	//    put().
	    then().
	    log().all();
																    														
										//			given().log().all().
										//	        accept(ContentType.JSON).
										//	        contentType(ContentType.JSON).
										//	        spec(blobSpec).
										//		 	body (myString7).
										//		    when().
										//			//put(EndPoint.BLOB_ENDPOINT);  //works!!!
										//		    put().
										//		    then().log().all().assertThat().statusCode(200)
										//		   ;  //   trying
		 
		 
				boolean  b= false;  // for dev
	 
			//System.out.println( EndPoint.BLOB_ENDPOINT);
		//	boolean  a = false;  // for dev
     } // test4
}  // class


