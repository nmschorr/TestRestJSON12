/* TestRestJSON by Nancy Schorr, 2016/2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Also goes to url http://jsonplaceholder.typicode.com/albums and reads the data and store it in various objects.
 2018 : added rest assured.
 */
package com.nmschorr;

import config.EndPoint;

import config.TestConfig;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;



public  class TestRestJSON extends TestConfig {

	  @Test
		public void newtestDemo2()  {
		    String myData =  "{\n"  + 
		    		"  \"userId\":333,\n"  +  
		            "  \"id\":3333,\n" +  
		    		"  \"title\":\"mynewbook\"\n " + 
		            "}";
																			//		    String gameBodyJson = "{\n" +
																			//	                "  \"id\": 11,\n" +
																			//	                "  \"name\": \"MyNewGame\",\n" +
																			//	                "  \"releaseDate\": \"2017-12-07T11:49:25.712Z\",\n" +
																			//	                "  \"reviewScore\": 50,\n" +
																			//	                "  \"category\": \"Driving\",\n" +
																			//	                "  \"rating\": \"Mature\"\n" +
																			//	                "}";
		    															//    String VIDEOGAMES = "/videogames";

	         String newendpoint = "/kbxij";

			given().body(myData).
			log().all().
			spec(arspec).
			when().
			//get().
			post(newendpoint).
			//when().get(EndPoint.SINGLE_ALBUM).
			 //when().get("/1/").
				then().
				log().all();		
			}

	  //@Test
	public void newtestDemo()  {
	
 		System.out.println("Beginning...");
		given().log().all().
		spec(arspec).
		when().get().
		//when().get(EndPoint.SINGLE_ALBUM).
		 //when().get("/1/").
			then().
			log().all();		
		}
}


