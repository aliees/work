package work.assignment;

import static io.restassured.RestAssured.given;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Market_most_watched {
	@Test
	public void most_watched() {
		//to get the response printed in output
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String response2= given().log().all()
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/tr/trending")
				.then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		
		        JsonPath js = new JsonPath(response2);
		        //to validate the body
		       System.out.println("The count is" +js.get("count")+"");
		       
		       
	}
	@Test
	public void most_watched2() {
		//to check what exection comes when key is no provided
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String response2= given().log().all()
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
			
				.when().get("/api/yahoo/tr/trending")
				.then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		
		        JsonPath js = new JsonPath(response2);
		        //to validate the body
		       
		       
		       
	}
	
	@Test
	public void most_watched3() {
		//to validate the status code with all valid data
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String response2= given().log().all()
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/tr/trending")
				.then().assertThat().statusCode(401)
				.extract().response().asString();
		
		        JsonPath js = new JsonPath(response2);
		    
		       
		       
	}

}
