package config; 

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
	
	public static ResponseSpecification responseSpec;
	public static ResponseSpecBuilder responseSpecBuilder;

	@BeforeClass
	public static void SetUp() {
		RestAssured.proxy("localhost", 8888);	
													//https://jsonblob.com/53998288-f328-11e7-8877-3d11de9ec1d3
												// other :  "/d14860ba-f2a0-11e7-8877-13767a00f47a";
		String blobBase        = "https://jsonblob.com"; 
		String blobBasePath = "/api/jsonBlob";
		blobSpec = new RequestSpecBuilder().
				setBaseUri(blobBase).
				setBasePath(blobBasePath).
				addHeader("ContentType", "application/json").
				//    addHeader("ContentType", "application/json; charset=utf-8").
				addHeader("Accept", "application/json").
				build();
	 
		//RestAssured.requestSpecification = blobSpec;
	
	//TestConfig.SetUpAlbums();
	TestConfig.SetUpResponse();
}
	  // ----------------------------------------------------- Response: 
	static void SetUpAlbums() {

		typicodebuilder = new RequestSpecBuilder();
		typicodebuilder.setBaseUri("http://jsonplaceholder.typicode.com");     
		typicodebuilder.setBasePath("/albums");      
		typicodebuilder.setPort(80);
		typicodebuilder.addHeader("ContentType", "application/json");
		typicodeSpec = typicodebuilder.build();
		//RestAssured.requestSpecification = typicodeSpec;   // sets this for all tests
}

		static void SetUpResponse() {

			responseSpec = new ResponseSpecBuilder().
			    expectStatusCode(200).
				build();

		RestAssured.responseSpecification = responseSpec;    // sets this for all tests
	}
}