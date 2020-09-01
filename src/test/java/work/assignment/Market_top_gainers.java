package work.assignment;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Market_top_gainers {
	
	@Test
	
	public void top_gainers() {
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		
		String response= given().log().all().queryParam("start", "0")
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/ga/topgainers")
				.then().statusCode(200)
				.extract().response().asString();
		System.out.println("posetive test case that will validate all valid data");
		        JsonPath js = new JsonPath(response);
		        
		        
	}

	@Test
	
	public void test_case2() {
		//this will  total count of elements present inside "quotes" element! 
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String response= given().log().all().queryParam("start", "0")
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/ga/topgainers")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		
		        JsonPath js = new JsonPath(response);
		        System.out.println("To validate if expected count matches with actual count value"); 
		        
		      
		      Assert.assertEquals(js.getInt("quotes.size()"), 25);
		      
		 
		    
		      
	}
@Test
	
	public void test_case3() {
		//To validate specific element in body
		RestAssured.baseURI="https://yahoo-finance15.p.rapidapi.com";
		String response= given().log().all().queryParam("start", "0")
				.header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
				.headers("X-RapidAPI-Key"," 4d8dcb3a9fmsh7ecca9be9e75e6dp130491jsnf44539c76ee5")
				.header("useQueryString","true")
				.when().get("/api/yahoo/ga/topgainers")
				.then().assertThat().statusCode(200)
				.extract().response().asString();
		
		        JsonPath js = new JsonPath(response);
		        //this will print total count of elements present inside "quotes" element! 
		        System.out.println("This test-case will find get the size of Quotes and will iterete until it sees curency=USD and print it in the output ");
		        int size = (js.get("quotes.size()"));
				//withh the help of size variable we are going through every object present inside
				
				for(int i=0;i<size;i++) {
				 String ddd=js.get("quotes["+i+"].currency");
				
				 if(ddd.equalsIgnoreCase("USD")) {
					 System.out.println(js.get("quotes["+i+"].currency"));
				 }
				 break;
				}
}
}
	

