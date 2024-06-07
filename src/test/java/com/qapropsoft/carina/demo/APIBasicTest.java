package com.qapropsoft.carina.demo;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;

import java.io.File;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utils.ApiHelper;

public class APIBasicTest {

	public Response response;
	public Scenario scenario;
	long petID;
	
//	ExtentReports extent = new ExtentReports();
//	ExtentSparkReporter spark = new ExtentSparkReporter("APIExtentReports.html");
//	ExtentTest test;
//	@Before
//	public void beforeTest() {
//		extent.attachReporter(spark);
//
//	}
//
//	@After
//	public void afterTest() {
//		extent.flush();
//	}
//	
	
	@Given("Get the API Base URI")
	public void get_the_api_base_uri() {
		
		ApiHelper.reqResBuilder();

       // test = extent.createTest("Get the API Base URI");
		//test.log(Status.PASS, "Test case passed - Geting the API Base URI");
		//test.pass("verified Geting the API Base URI");

	}

	@Given("Get call to url test the API")
	public void get_call_to_https_reqres_in_api_users_page() {
		// baseURI = "https://reqres.in/api";
		Response response = given().spec(requestSpecification)
				.expect()
				.spec(responseSpecification)
				.when()
				.get("/v2/pet/findByStatus?status=pending");

        //ExtentTest test = extent.createTest("Get call to url to test the API");
//		test.log(Status.PASS, "Test case passed - Get call to url to test the API is displayed");
//		test.pass("verified Get call to url to test the API");

		System.out.println("1----------------------------------end");
	}

	@Then("Response code is storing PostPet")
	public void response_code_is() {

		// given().get("/users?page=2").then().statusCode(200).log().all();
		System.out.println("-------------Test 2 Post pet ------------");
		//String payload = "id":0;etc
		
		Response response = given().spec(requestSpecification)
				.header("accept", "application/json")
				.body(new File("./payload.json"))
				.expect()
				.spec(responseSpecification)
				.when().post("/v2/pet");
		//System.out.println(response.asPrettyString());
		petID = response.path("id");
		System.out.println(petID);
        //ExtentTest test = extent.createTest("Response code is storing PostPet");
		//test.log(Status.PASS, "Test case passed - Response code is storing PostPet");
		//test.pass("verified Response code is storing PostPet");

		System.out.println("2------------------------end");

	}

	@And("Update pet details PutPet")
	public void update_pet_details_put_pet() {
		System.out.println("-------------Test 3 put pet ------------");

//		String jsonBody = ApiHelper.jsonBodyGet();
		
		String jsonBody = "{"
				+ "  \"id\": "+petID+","
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"updated string\""
				+ "  },"
				+ "  \"name\": \"doggie name updated\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"string updated\""
				+ "    }"
				+ "  ],"
				+ "  \"status\": \"sold\""
				+ "}";
		Response response = given()
				.spec(requestSpecification)
				.header("accept", "application/json")
				
				.body(jsonBody)
				.expect()
				.spec(responseSpecification)
				.when().put("/v2/pet/");
		//System.out.println(response.asPrettyString());
       // ExtentTest test = extent.createTest("Update pet details PutPet");
		//test.log(Status.PASS, "Test case passed - Update pet details PutPet");
		//test.pass("verified Update pet details PutPet");

		System.out.println("3rd -------------------------end");
		
	}

	@And("Update pet details PostUpdate")
	public void update_pet_details_post_update() {
		System.out.println("----------postUpdate---------");
		Response response = given()
				.spec(requestSpecification)
				.header("Content-Type","application/x-www-form-urlencoded")
				.formParam("name", "DogUpdated")
				.formParam("status", "sold")
				.expect()
				.spec(responseSpecification)
				.when()
				.post("/v2/pet/"+petID);
				//.patch 
		//System.out.println(response.asPrettyString());
        //ExtentTest test = extent.createTest("Update pet details PostUpdate");
		//test.log(Status.PASS, "Test case passed - Update pet details PostUpdate");
		//test.pass("verified Update pet details PostUpdate");

		System.out.println("4th -------------------end");
	}

	@Then("Delete the pet DeletePet")
	public void delete_the_pet_delete_pet() {
		System.out.println("---------Delete---------------");
		Response response = given()
				.spec(requestSpecification)
				.expect()
				.spec(responseSpecification)
				.when()
				.delete("/v2/pet/"+petID);
		//System.out.println(response.asPrettyString());
        //ExtentTest test = extent.createTest("Delete the pet DeletePet");
		//test.log(Status.PASS, "Test case passed - Delete the pet DeletePet");
		//test.pass("verified Delete the pet DeletePet");

		System.out.println("5th ---------------------end");
	}
}
