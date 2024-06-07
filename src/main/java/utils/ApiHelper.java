package utils;

import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

public class ApiHelper {
	
	static long petID;

    public static void reqResBuilder() {
    	System.out.println("Commaon steps");
		RequestSpecBuilder requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri("https://petstore.swagger.io");
		requestSpec.setContentType(ContentType.JSON);
		requestSpec.log(LogDetail.ALL);
		requestSpec.addHeader("accept", "application/json");
		requestSpecification = requestSpec.build();

		ResponseSpecBuilder responseSpec = new ResponseSpecBuilder();
		responseSpec.expectStatusCode(200);
		responseSpec.expectContentType(ContentType.JSON);
		responseSpec.log(LogDetail.ALL);
		responseSpecification = responseSpec.build();
    }
    
    public static String jsonBodyGet(String jsonBodyPart) {
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
		return jsonBodyPart;
    }
    
}