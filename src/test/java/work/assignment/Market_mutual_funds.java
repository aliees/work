package work.assignment;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Market_mutual_funds {
	@Test
	public void mutual_funds() {
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String getResposne= given().log().all().queryParam("start", "0")
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/mu/topmutualfunds")
				.then().assertThat().log().all().statusCode(200)
				.extract().response().asString();
		
		JsonPath js = new JsonPath(getResposne);
		
			
		System.out.println(js);
	}
}
