/* TestRestJSON by Nancy Schorr, 2016/2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Also goes to url https://jsonmy.com/53998288-f328-11e7-8877-3d11de9ec1d3 and reads the data and store it in various objects.
 2018 : added rest assured.
 */
package com.nmschorr;

import config.TestConfig;
import config.EndPoint;
							//import org.json.JSONObject;
import java.util.*; 

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
							//import  io.restassured.http.*;
							//import  io.restassured.response.Response;
							//import  io.restassured.specification.*;
							//import com.github.fge.jsonpatch.*;

public  class TestRestJSON extends TestConfig {
		//public static String jsonAsString;
	   public static String   myBasePath = "/movies";   //  
	 

 		//------------------------------------- test 1 Get --------------------------------------
	@Test														
	public void myTest1()  {
		System.out.println("\n\n---------------Beginning myTest1 Simple GET --------------------\n\n");
		System.out.println("\n\n- --------------Fiddler must be running! -------------------- \n\n");
		
		String responseStr =			
				given()
					.log().headers()
					.spec(mySpec)
					.when()
					.get(myBasePath).asString();
		
		System.out.println("responseStr:  "   + responseStr);
		//int  a = 0;             // for dev

												//then().assertThat().body(containsString("nancy")).
												//and().body(containsString("a")).
	}

				//------------------------------------- test 2 --------------------------------------
	//@Test
	public void myTest2()  {
		System.out.println("\n\n---------------Beginning myTest2 Get One Record---------------------\n\n");
	    String myBody2 = "/3";
		String testString2 = "Inception";
		System.out.println("\n\n------Testing Record:     "  +   myBody2  + "  " +  testString2 + "----------\n\n");
	
		given()
		.log().all().
		spec(mySpec)
		.when() 
		.get(myBody2)
		//
		.then()
		.assertThat().body(containsString(testString2))
		.log().all();
		
		//assertThat().
		//body(containsString("Inception"));
		//log().all();		
	}
	//------------------------------------- test 3 --------------------------------------
@Test
public void myTest3()  {
System.out.println("\n\n---------------Beginning myTest3  POST---------------------\n\n");

String myBody3 =  "{\n \"id\": 7,\"name\": \"jsonserver55\", \"director\": \"nms5\",  \"rating\": 9.0 \n}";
System.out.println("\n\n------Testing Record:     "  +   myBody3  + "  "+ "----------\n\n");

////Response responseFromJsonSite =			
		given()
		.log().all()
		.body(myBody3)
		.spec(mySpec)
		.when()
		.post(myBasePath)
		.then()
		.log().all();
//		
//	int  a = 1;  // for dev
}
	//------------------------------------- test 4 --------------------------------------
	//@Test
	public void myTest4()  {

			System.out.println("\n\n---------------Beginning myTest4---------------------\n\n");
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
		
		//String repStr = "[   {\"replace\": \"/id\", \"value\": 5} ]";												    

		given().
        spec(mySpec).
  //      body().
	    when().
	//    put().
	    then().
	    log().all();
																    														
										//			given().log().all().
										//	        accept(ContentType.JSON).
										//	        contentType(ContentType.JSON).
										//	        spec(mySpec).
										//		 	body (myString7).
										//		    when().
										//			//put(EndPoint.my_ENDPOINT);  //works!!!
										//		    put().
										//		    then().log().all().assertThat().statusCode(200)
										//		   ;  //   trying
		 
		 
				boolean  b= false;  // for dev
	 
			//System.out.println( EndPoint.my_ENDPOINT);
		//	boolean  a = false;  // for dev
     } // test4
}  // class


