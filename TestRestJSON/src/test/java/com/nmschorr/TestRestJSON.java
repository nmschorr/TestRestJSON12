/* TestRestJSON by Nancy Schorr, 2016/2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Also goes to url https://jsonblob.com/53998288-f328-11e7-8877-3d11de9ec1d3 and reads the data and store it in various objects.
 2018 : added rest assured.
 */
package com.nmschorr;

import config.TestConfig;
import config.EndPoint;
import org.json.JSONObject;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import  io.restassured.http.*;
import  io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import  io.restassured.specification.*;

public  class TestRestJSON extends TestConfig {
											public static String jsonAsString;
											public static String newPeep =  "{\"id\":0}";
										 public static String postLoc = EndPoint.BLOB_ENDPOINT;
									 
 
 		//------------------------------------- test 1 --------------------------------------
	@Test
	public void blobTest1()  {
		System.out.println("\n\n---------------Beginning blobTest1 --------------------\n\n");
		
		String responseStr =			
				given().
				log().parameters().
				spec(blobSpec).
				when().
				get(EndPoint.BLOB_ENDPOINT).asString();
		
		System.out.println(responseStr);

		int  a = 0;             // for dev

		//then().assertThat().body(containsString("nancy")).
		//and().body(containsString("a")).
	}

			//------------------------------------- test 2 --------------------------------------
	@Test
	public void blobTest2()  {
		System.out.println("\n\n---------------Beginning blobTest2---------------------\n\n");
		
		Response response2 =			
				given().
				log().all().
				spec(blobSpec).
				when().
				get(EndPoint.BLOB_ENDPOINT).
				then().
				contentType(ContentType.JSON).
				extract().response();

		Headers headers = response2.getHeaders();
		String contentType = response2.getHeader("Content-Type");
		System.out.println("\n\n contentType blobTest2:   " + contentType);
		System.out.println("here is body:     "  + response2.getBody().asString().toString()        );
		int  a = 1;  // for dev
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
	@Test
	public void blobTest4()  {

		
		
		String myString2 = "{\n" +
                "  \"id\": 15,\n" +
                "  \"name\": \"MyNewGame5\",\n" +
                "  \"releaseDate\": \"2017-12-07T11:49:25.755Z\",\n" +
                "  \"reviewScore\": 45,\n" +
                "  \"category\": \"Driving55\",\n" +
                "  \"rating\": \"Mature5\"\n" +
                "}";

		
		System.out.println("\n\n---------------Beginning blobTest4---------------------\n\n");
		System.out.println("\n\npostLoc: " + postLoc + "\n\n");
		System.out.println("\n\n newPeep: " + newPeep + "\n\n");
	       String		myString = new JSONObject()
							.put("id", 92).toString();
			boolean  b= false;  // for dev

		 given().spec(blobSpec).
		 			body (myString).
				    when().
				//    put(EndPoint.BLOB_ENDPOINT);  //works!!!
		      post(EndPoint.BLOB_ENDPOINT);  //works!!!
		 
		 
		 
			System.out.println( postLoc);
			boolean  a = false;  // for dev
     } // test4
}  // class


