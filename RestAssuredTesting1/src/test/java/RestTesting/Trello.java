package RestTesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;

public class Trello {
	//base URL is common to all the actions
	public static String baseurl="https://api.trello.com"; 
	public static String id;
	
	
	@Test(priority=0)
	public void createBoard()
	{
		
		//1st step to provide base url to the request
		//RestAssured is a class
		RestAssured.baseURI=baseurl;
		// In rest assured we have three keywords
		//1st given : Pre-condition like parameter,header,authorization
		//2nd when : condition // we have to provide the name//that is called resource/1/boared
		//3rd then : post condition : is searching like response check the response
		Response response=given().queryParam("name","Shivani11 ")
		.queryParam("key","e4aec382228751778748bea3aef00e19")
		.queryParam("token","85be9ec75a23dd5c8f3121609323c20a1e7ecb485343f905df38e17a4cfe6f4f")
		.header("Content-Type","application/json")
		.when()
		
		.post("/1/boards/")
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		
		String jsonresponse = response.asString();
		//i want to convert the response in to json format
		//if I want to convert the response into a jsonformat using jsonpath
		JsonPath js = new JsonPath(jsonresponse);
		//nw i have to fetch the id
		id = js.get("id");
		
	}
	
	@Test(priority=1)
	public void getBoard()
	{

		RestAssured.baseURI=baseurl;
		Response response=given().queryParam("key","e4aec382228751778748bea3aef00e19")
		.queryParam("token","85be9ec75a23dd5c8f3121609323c20a1e7ecb485343f905df38e17a4cfe6f4f")
		.header("Content-Type","application/json")
		.when()
		.get("/1/boards/"+id)
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		String jsonresponse = response.asString();
		System.out.println(jsonresponse);
		
	}
	@Test(priority = 2)
	public void DeleteBoard()
	{
		RestAssured.baseURI = baseurl;
		
		
	Response response =	given()
		.queryParam("key", "e4aec382228751778748bea3aef00e19")
		.queryParam("token", "85be9ec75a23dd5c8f3121609323c20a1e7ecb485343f905df38e17a4cfe6f4f")
		.header("Content-Type","application/json")
		
		.when()
		.delete("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();	
		String jsonresponse = response.asString();
		
		System.out.println(jsonresponse);
	}
}
