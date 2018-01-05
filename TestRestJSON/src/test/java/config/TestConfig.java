package config; 

import org.junit.BeforeClass;
import io.restassured.RestAssured;
import  io.restassured.builder.RequestSpecBuilder;
import  io.restassured.specification.RequestSpecification;

public class TestConfig {
	
	@BeforeClass
	public static void SetUp() {
		RestAssured.baseURI = ("http://jsonplaceholder.typicode.com");
		RestAssured.basePath = ("/albums");
		
		
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.addHeader("ContentType", "application/json")
				.addHeader("Accept", "application/json").build();
		RestAssured.requestSpecification = requestSpecification;
		
		
		
    }
}