package work.assignment;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Market_mutual_funds {
	@Test
	public void mutual_funds() {
		//testcase1 will all valid data
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String getResposne= given().log().all().queryParam("start", "0")
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/mu/topmutualfunds")
				.then().assertThat().log().all().statusCode(200)
				.body("total", equalTo(1468))
				.extract().response().asString();
		
		
		JsonPath js = new JsonPath(getResposne);
		System.out.println(js);
	}
	@Test
	public void validate_response_body() {
		//testcase2 to validate the response body in "Quotes" element 
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String getResposne= given().log().all().queryParam("start", "0")
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/mu/topmutualfunds")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		
		
		JsonPath js = new JsonPath(getResposne);
		
		int size = (js.get("quotes.size()"));
		//this for loop is to get nd print all the value in quotes 
		for(int i=0;i<size;i++) {
			System.out.println(js.get("quotes[0]"));
		}
	}
	@Test
	public void get_value() {
		//this test case will validate response body for all values in "language" feild 
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String getResposne= given().log().all().queryParam("start", "0")
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/mu/topmutualfunds")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		
		
		JsonPath js = new JsonPath(getResposne);
		
		//in the below line of code quotes size is stored in a variable
		int size = (js.get("quotes.size()"));
		//withh the help of size variable we are going through every object present inside
		
		for(int i=0;i<size;i++) {
		 String ddd=js.get("quotes["+i+"].language");
		 //in this "if" we are confirming that hour value shoe be equal to "en-US" nd if it is equal then print it
		 if(ddd.equalsIgnoreCase("en-US")) {
			 System.out.println(js.get("quotes["+i+"].language"));
		 }
		}
	}
	
	
	@Test
	public void validateResponseJSONBody_test()
	{
	    RestAssured.baseURI = "https://yahoo-finance15.p.rapidapi.com";
	    RequestSpecification httpRequest = RestAssured.given();
	    // Set HTTP Headers
	    httpRequest.queryParam("start", "0");
	    httpRequest.header("Content-Type", "application/json");
	    httpRequest.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com");
	    httpRequest.header("X-RapidAPI-Key", "4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5");
	    httpRequest.header("useQueryString","true");
	    
	    Response response = httpRequest.get("/api/yahoo/mu/topmutualfunds");
	    // Get Response Body 
	    ResponseBody body = response.getBody();
	    
	    // Get Response Body as String 
	    String bodyStringValue = body.asString();
	    // Validate if Response Body Contains a specific String
	    Assert.assertTrue(bodyStringValue.contains("language"));
	    
	    // Get JSON Representation from Response Body 
	    JsonPath jsonPathEvaluator = response.jsonPath();
	    
	  
	}

@Test
public void Test_case2() {
  // to validate the wrong status code
	RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
	String getResposne= given().log().all().queryParam("start", "0")
			.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
			.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
			.header("useQueryString","true")
			.when().get("/api/yahoo/mu/topmutualfunds")
			.then().assertThat().statusCode(404)
			.extract().response().asString();
	
	
	JsonPath js = new JsonPath(getResposne);
}


}	
		
	
//			
//		
		
	
	

