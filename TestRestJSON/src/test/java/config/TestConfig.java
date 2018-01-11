package config; 

import config.EndPoint;
import io.restassured.RestAssured;
import  io.restassured.builder.RequestSpecBuilder;
import  io.restassured.builder.ResponseSpecBuilder;
import  io.restassured.specification.RequestSpecification;
import  io.restassured.specification.ResponseSpecification;
import java.util.ArrayList;
import org.junit.BeforeClass;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
	
	
	
public class TestConfig {
	//public int[] myTests = {  1, 2, 3, 4 };  // edit this list
	public int[] myTests = { 1, 4 };  // edit this list

	
	public static RequestSpecBuilder typicodebuilder;
	public static RequestSpecification typicodeSpec;
	public static RequestSpecification mySpec;

	public static ResponseSpecification responseSpecGet;
	public static ResponseSpecification responseSpecPost;
	public static ResponseSpecBuilder responseSpecBuilder;
	
	@BeforeClass
	public static void SetUp() {
        RestAssured.proxy("localhost", 8888);	  // for fiddler
		String   myBase        = "http://localhost:3000"; 
		String   myBasePath = "/movies";   //  
		Integer myPort         = 3000;        // for JSONserver
 		String MYBASE = myBase;
	    String MYBASEPATH = myBasePath;
	    													    
		mySpec = new RequestSpecBuilder()
			.setBaseUri(MYBASE) 													
		    .setBasePath(MYBASEPATH)
			.setPort(myPort)
			.addHeader("Accept", "application/json")
			.addHeader("Content-Type", "application/json")
		    .build();
	 
		System.out.println("\n-----------------Must run with Fidder!---------------------------\n");
			//RestAssured.requestSpecification = mySpec;  // uncomment to set true for all tests
		TestConfig.SetUpResponse();		
}
	  // ----------------------------------------------------- typicode.com: 
	
	static void SetUpTypicode() {

		typicodebuilder = new RequestSpecBuilder();
		typicodebuilder.setBaseUri("http://jsonplaceholder.typicode.com");     
		typicodebuilder.setBasePath("/albums");      
		typicodebuilder.setPort(80);
		typicodebuilder.addHeader("ContentType", "application/json");
		typicodeSpec = typicodebuilder.build();
		//RestAssured.requestSpecification = typicodeSpec;   // sets this for all tests
}
	  // ----------------------------------------------------- Response: 

	static void SetUpResponse() {
		responseSpecGet = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.build();

		responseSpecPost = new ResponseSpecBuilder()
				.expectStatusCode(201)
				.build();

		//RestAssured.responseSpecification = responseSpec;    // sets this for all tests
	}
	  // ----------------------------------------------------- Response: 

	public static boolean mycheck(int[] myTestListLoc, int tOne)  {
		boolean runThisTestVar = IntStream.of(myTestListLoc).anyMatch(x -> x == tOne);       
		return runThisTestVar;
	} 
}



