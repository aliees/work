package work.assignment;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Market_top_gainers {
	
	@Test
	//to get the response peinted in output
	public void top_gainers() {
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String response= given().log().all().queryParam("start", "0")
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/ga/topgainers")
				.then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		
		        JsonPath js = new JsonPath(response);
		        System.out.println(js);
	}
	
	@Test
	//to get
	public void test_case2() {
		//without providing headers to validate the status code
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String response= given().log().all().queryParam("start", "0")

				.when().get("/api/yahoo/ga/topgainers")
				.then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		
		        JsonPath js = new JsonPath(response);
		      
	}
	@Test
	
	public void test_case3() {
		//To validate how many objects present in the quotes array
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String response= given().queryParam("start", "0")
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/ga/topgainers")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		
		        JsonPath js = new JsonPath(response);
		        //this will print total count of elements present inside "quotes" element! 
		        
		      System.out.println("The total count is "+js.getInt("quotes.size()")+"");
		      
		 
		    
		      
	}
}
