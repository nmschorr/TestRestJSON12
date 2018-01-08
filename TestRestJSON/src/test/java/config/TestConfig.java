package config; 

import config.EndPoint;
import io.restassured.RestAssured;
import  io.restassured.builder.RequestSpecBuilder;
import  io.restassured.builder.ResponseSpecBuilder;
import  io.restassured.specification.RequestSpecification;
import  io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class TestConfig {
	public static RequestSpecBuilder typicodebuilder;
	public static RequestSpecification typicodeSpec;
	public static RequestSpecification blobSpec;
	public static RequestSpecification myjsonSpec;
	public static RequestSpecBuilder myjsonSpecB;

	public static ResponseSpecification responseSpec;
	public static ResponseSpecBuilder responseSpecBuilder;
												//https://jsonblob.com/53998288-f328-11e7-8877-3d11de9ec1d3
												// other :  "/d14860ba-f2a0-11e7-8877-13767a00f47a";

 
 	
	@BeforeClass
	public static void SetUp() {
		RestAssured.proxy("localhost", 8888);	
		String blobBase        = "https://jsonblob.com"; 
		String blobBasePath = "/api/jsonBlob/53998288-f328-11e7-8877-3d11de9ec1d3";   // + EndPoint.BLOB_ENDPOINT;

		
		//https://api.myjson.com/bins/bl3ht
			myjsonSpec = new RequestSpecBuilder().
			setBaseUri("http://api.myjson.com/bins").
			setBasePath("/bl3ht").
			setPort(80).
			addHeader("Content-Type", "application/json").
			addHeader("Accept", "application/json").
		    build();

		blobSpec = new RequestSpecBuilder().
				setBaseUri(blobBase).
				setBasePath(blobBasePath).
				setPort(8080).
				//addHeader("ContentType", "application/json").
				addHeader("Content-Type", "application/json").
				addHeader("Accept", "application/json").
				addHeader("X-jsonblob","53998288-f328-11e7-8877-3d11de9ec1d3").
			    build();
	 
		System.out.println(blobSpec.toString());
			//RestAssured.requestSpecification = blobSpec;
			//TestConfig.SetUpTypicode();
		//TestConfig.SetUpResponse();
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
			responseSpec = new ResponseSpecBuilder().
			    expectStatusCode(200).
				build();

		RestAssured.responseSpecification = responseSpec;    // sets this for all tests
	}
}