/* TestRestJSON by Nancy Schorr, 2016/2018
 Demonstrates use of apis to read a json formatted text file and store it as a JSON object for further manipulation.
 Also goes to url http://jsonplaceholder.typicode.com/albums and reads the data and store it in various objects.
 2018 : added rest assured.
 */

package com.nmschorr;

import static java.lang.System.out;
//import java.io.*;
//import java.net.*;
//import java.util.*;
//import org.json.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.config.*;

import org.junit.runners.MethodSorters;
import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import static org.junit.Assert.*;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRestJSON {

	@BeforeClass  //run once before each testsuite
	public static void TestRestJSONsetup() {
		LogConfig logconfig = new LogConfig().enableLoggingOfRequestAndResponseIfValidationFails().enablePrettyPrinting(true);
		RestAssured.config().logConfig(logconfig);
	}



	@Test
	public void atestDemo() throws Exception {
		System.setProperty("http.agent", "Chrome");
		System.out.println("Beginning...");
		RestAssured.baseURI  = "http://jsonplaceholder.typicode.com/albums";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.request(Method.GET, "/1");
		String responseBody = response.getBody().asString();

		System.out.println("Response Body is =>  \n" + responseBody);

		get("/1").then().body("/1/userId", equalTo(1));
		System.out.println("\nTest Finished\n\n");
	}


	@Test
	public void exampleRestTest() {
		System.setProperty("http.agent", "Chrome");
		System.out.println("\nin 2nd part");
		System.out.println("Beginning...");
		RestAssured.baseURI  = "http://jsonplaceholder.typicode.com/albums";
		//RequestSpecification httpRequest = given();
		given()
		.contentType(ContentType.JSON)
		.pathParam("id", "9")
		.log().all()
		.when()
		.get("/4/{id}")
		.then().log().all()
		.assertThat()
		.statusCode(200).and()
		.contentType(ContentType.JSON).and()
		.body("id", equalTo("1"))
		.body("title", equalTo("quidem molestiae enim"))
		.extract().response();
	}


	//	RestAssured.given().log().all()
	//    .header("Content-Type", "application/XML; charset=utf-8")
	//    .body("")
	//    .when().post("/bxfxml")
	//    .then().log().all()
	//    .assertThat()
	//    .statusCode(200).and()
	//    .contentType(ContentType.XML)
	//    .extract().response();


	@AfterClass
	public static void cleanup() {
		System.out.println("\nProgram Finished");
	}

}	//class










