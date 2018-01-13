/* TestRestJSON by Nancy Schorr, 2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Goes to url  localhost:3000  and reads the data and store it in various objects running with JSONserver and Node.js.
 2018 : added rest assured.  
 Note to self: do log first, then spec, then the rest in each section.
 see https://github.com/typicode/json-server/blob/master/README.md for usage
 */
package com.nmschorr;

import static  java.lang.System.out;
import static io.restassured.RestAssured.*;
import static  io.restassured.http.ContentType.JSON;
import groovy.json.JsonSlurper ;

import static org.hamcrest.Matchers.*;

import java.net.URL;
import java.util.Map;

import config.TestConfig;
import static org.hamcrest.CoreMatchers.containsString;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import config.EndPoint;
import org.json.JSONObject;
import org.junit.Test;


public  class TestRestJSON extends TestConfig {
	public static String   myBasePath = EndPoint.MOVIE_EP;  
	public static String BOL = "\n--------------- " ;
	public static String EOLn = "  --------------------\n" ;

	//------------------------------------- test 1 Get --------------------------------------
	@Test														
	public void myTest1()  {
		int testNumber = 1;
		String testName = "GET";

		if  (mycheck(myTests, testNumber))    {              // 1 = this test number
			out.println(BOL + "Fiddler must be running! " + EOLn);	 	
			printEndLine(testNumber,"begin", testName);

			ValidatableResponse validatableResponse =			
					given()
					.log().all()
					.spec(mySpec)
					.when()
					.get()
					.then()
					.spec(responseSpecGet)
					.log().all();

			validatableResponse.assertThat().statusCode(200);
			//String id = validatableResponse.extract().body().jsonPath().get("id").toString();
			String movieNamesList = validatableResponse.extract().body().jsonPath().get("name").toString();
			//Headers h= validatableResponse.extract().headers();
			//	String statusCode =  validatableResponse.extract().statusLine();

			//    assertTrue(statusCode, containsString("200"));
			System.out.println("Test one movie names list:  " + movieNamesList);
			printEndLine(testNumber,"end",testName);
		}	
		else {
			printEndLine(testNumber,"skip",testName);
		}
	}

	//------------------------------------- test 2 Get Record --------------------------------------
	@Test
	public void myTest2()  {
		int testNumber = 2;
		String testName = "GET2";
		if  (mycheck(myTests, testNumber))    {              // 2 = this test number
			printEndLine(testNumber,"begin", testName);
			String selectedRecord = "/3";
			String selectedTestString = "Inception";

			given()
			.log().all()
			.spec(mySpec)
			.when() 
			.get(selectedRecord)
			.then()
			.spec(responseSpecGet)
			.assertThat().body(containsString(selectedTestString))
			.log().all();
			printEndLine(testNumber,"end",testName);
		}	
		else {
			printEndLine(testNumber,"skip",testName);
		}
	}
	//------------------------------------- test 3 POST --------------------------------------
	@Test
	public void myTest3()  {
		int testNumber =3;
		String testName = "POST";
	if  (mycheck(myTests, testNumber))    {              // 3 = this test number
			printEndLine(testNumber,"begin",testName);

			JSONObject obj = new JSONObject();  //no need for id
			obj.put("rating","rating12");
			obj.put("director","director12");
			obj.put("name","new12");      	//	obj.put("id", new Integer(12));  // no need for id - gets it automatically
			System.out.println("\n\n------ex obj Record:    \n "  +   obj.toString()  + "  "+ "----------\n\n");

			given()
			.log().everything()
			.spec(mySpec)
			.body(obj.toString())     // all specs must be before body!
			.when()
			.post()
			.then()
			.spec(responseSpecPost)
			.log().all();		
			printEndLine(testNumber,"end",testName);
		}	
		else {
			printEndLine(testNumber,"skip",testName);
		}
	}

	//------------------------------------- test 4 --------------------------------------
	@Test
	public void myTest4()  {
		int testNumber = 4;
		String testName = "PATCH";

		if  (mycheck(myTests,testNumber))    {              // 4 = this test number
			printEndLine(testNumber,"begin", testName);
			System.out.println(BOL + "Fiddler must be running! " + EOLn);
			String recNumber = "/4";
			String myPatch =   " {  \"rating\": 44 }"  ;     // very simple - just field name to replace and value

			given()
			.spec(mySpec)
			.body(myPatch)
			.when()
			.patch(recNumber)    
			.then()
			.spec(responseSpecGet)       // 200
			.log().all();			

			printEndLine(testNumber,"end",testName);
		}
		else {
			printEndLine(testNumber,"skip",testName);
		}
	}  // test 4
	//------------------------------------- test 5 PUT --------------------------------------
	//   this will replace an entire record
	@Test
	public void myTest5()  {
		int testNumber = 5;
		String testName = "PUT";
		if  (mycheck(myTests,testNumber))    {              // 5 = this test number
			printEndLine(testNumber,"begin", testName);
			System.out.println(BOL + "Fiddler must be running! " + EOLn);
			String recNumber = "/12";
				//	String myPUT =  "{   \"name\": \"Mission Impossible\",  \"director\": \"Tom Cruise\",  \"rating\": 9.0 }";    // this string works for Post
	
			JSONObject myPUT = new JSONObject();  //no need for id, add to object in reverse order
			myPUT.put("rating","93");
			myPUT.put("director","Tom Cruise3");
			myPUT.put("name","Mission Impossible 3");      	//	obj.put("id", new Integer(12));  // no need for id - gets it automatically
			System.out.println("\n\n------ex obj Record:    \n "  +   myPUT.toString()  + "  "+ "----------\n\n");

			given()
			.spec(mySpec)
			.body(myPUT.toString())
			.when()
			.put(recNumber)    
			.then()
			.spec(responseSpecGet)       // 200
			.log().all();			

			printEndLine(testNumber,"end",testName);
		}	
		else {
			printEndLine(testNumber,"skip",testName);
		}
	}  // test 5

	//------------------------------------- test 6 DELETE --------------------------------------
	//   this will replace an entire record
	@Test
	public void myTest6()  {
		int testNumber = 6;
		String testName = "DELETE";
		if  (mycheck(myTests,testNumber))    {              // 6 = this test number
			printEndLine(testNumber,"begin", testName);
			System.out.println(BOL + "Fiddler must be running! " + EOLn);
			String recNumber = "/16";
	
			given()
			.spec(mySpec)
			.when()
			.delete(recNumber)    
			.then()
			.spec(responseSpecGet)       // 200
			.log().all();			

			printEndLine(testNumber,"end",testName);
		}	
		else {
			printEndLine(testNumber,"skip",testName);
		}
	}  // test 6	
	
	
	//------------------------------------- test 99  --------------------------------------
//	@Test
	public void myTest7() {
		out.println("\n--------------- In print records   \n");
		
		given()
		.log().headers()
		.spec(mySpec)
		.when()
		//.options()
		.get()                                         // this will get all records
		.then()
		.spec(responseSpecGet)
		.contentType(JSON) 
		.log().headers()
	  	.log().body()
		;
		out.println("\n--------------- Done with print records");
	}
	
	//@Test
	public void myTest8() {
		Response response = given().spec(mySpec).get();
		String director = response.path("director[0]");
		System.out.println("\nfirst director in db "  + director);
		System.out.println("\n  " + response.path("[0]") );
		String lastTeamName = response.path("director[-1]");
		System.out.println("\n  " + lastTeamName );
		java.util.ArrayList<String> allTeamNames = response.path("director");
		System.out.println("\n  all directors:  " + allTeamNames );
		java.util. ArrayList<Map<String,?>> allTeamData = response.path("director");
		System.out.println("\n  all directors mapped:  " + allTeamData );
	      
		JsonSlurper jsonSlurper = new JsonSlurper();
		///URL myu = new URL("http", "localhost", 3000, "/");
		//URL(String protocol, String host, int port, String file)
		
	//	Object myObj = jsonSlurper.parse(myu);
		int a = 0;
 
		    
		//println(object)
	//	def allTeamNames = object.teams.name
	}

	@Test
	public void myTest9() {
		out.println("\n--------------- In 9    \n");
		Response response =  given()
				.spec(mySpec)
				.when()
				.get("/1")                                         // this will get all records
				;
		out.println( response.body().prettyPrint());

	}		
		
		
		
		

	public void printEndLine(int tnbr, String ttype, String tname) {

		switch (ttype) {
			case "end":  out.println(BOL + "End Test " + tnbr + ": "  + tname + EOLn);
				break;
			case "begin":  out.println(BOL + "Begin Test " + tnbr + ": "  + tname +  EOLn);
				break;
			case "skip":  out.println(EOLn + "Skipped Test " + tnbr + ": "  + tname + EOLn);
				break;
		default:  
				break;
		}
	}
}        // class


