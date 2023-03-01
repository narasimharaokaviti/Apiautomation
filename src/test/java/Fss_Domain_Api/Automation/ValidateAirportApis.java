package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateAirportApis {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This testcase verifies create a new airport
	 * @return: NO
	 * @parameters: NO
	 */

	@Test(priority=0,description="This api verifies create a new airport",enabled=true)
	void verifyCreateNewAirport() {
		RestAssured.baseURI=Constants.URI;
		RequestSpecification httprequest=RestAssured.given();
		JSONObject request=new JSONObject();
		request.put("airPortId",6);
		request.put("altitude","abdc");
		request.put("countryId",2);
		request.put("createdBy",3);
		request.put("edi","abhcdde");
		request.put("iata","JKJ");
		request.put("icao","VKN");
		request.put("latitude","NJD	");
		request.put("location","HYDd");
		request.put("longitude","hyd");
		request.put("name","NELOAL");
		request.put("updatedBy",2);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/airport");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		int responcecode =responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This testcase verifies Update existing Airport details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=1,description="This api verifies Update existing Airport details ",enabled=false)
	void verifyUpdateAirport() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("airPortId",2);
		request.put("altitude","abcd");
		request.put("countryId",1);
		request.put("createdBy",1);
		request.put("edi","ancd");
		request.put("iata","KJ");
		request.put("icao","VTO");
		request.put("latitude","310.33");
		request.put("location","nepal");
		request.put("longitude","988884.098");
		request.put("name","nepdal");
		request.put("updatedBy",2);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		Response responce= httprequest.request(Method.PUT,"/admin/airport");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This api verifies get all airport details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=2,description="This testcase verifies get all airport details",enabled=false)
	void verifyGetAirport() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/airports");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		//Assert.assertEquals(responcebody.contains("SUCESS"), true); 
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		/*
		 * Headers allheaders=responce.headers(); for(Header header:allheaders) {
		 * System.out.println(header.getName()+"  "+header.getValue());
		 * 
		 * }
		 */
	}
	/*
	 * This api verifies delete existing sirport details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=3,description="This api verifies delete existing sirport details",enabled=false)
	void verifyDeleteAirports() {
		RestAssured.baseURI=Constants.URI;
		RestAssured.baseURI="http://fss-alb-955427281.ap-south-1.elb.amazonaws.com";
		httprequest=RestAssured.given();
		request=new JSONObject();
		//httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.DELETE,"/admin/airport/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}

}
