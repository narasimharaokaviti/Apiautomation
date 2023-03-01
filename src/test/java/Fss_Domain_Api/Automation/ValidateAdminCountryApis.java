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

public class ValidateAdminCountryApis {

	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This test case  verifies Create new country
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=0,description="This test case  verifies Create New country",enabled=true)
	void verifyCreateNewCountry() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
	    request=new JSONObject();
		request.put("code","INDE");
		request.put("countryId",2);
		request.put("createdBy",1);
		request.put("name","SRILANKA");
		request.put("updatedBy",1);
		request.put("zoneId",1);  
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/country");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		Headers allheaders=responce.headers(); 
		for(Header header:allheaders) {
		System.out.println(header.getName()+"  "+header.getValue());
		}

	}
	/*
	 * This test case  verifies update existing country details
	 * @Parameters:No
	 * @return: NO
	 */
	
	@Test(priority=1,description="This test case  verifies update existing country details",enabled=true)
	void verifyUpdateCountry() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("code","INDEH");
		request.put("countryId",2);
		request.put("createdBy",1);
		request.put("name","SRILANKA");
		request.put("updatedBy",1);
		request.put("zoneId",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.PUT,"/admin/country");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies get  Country details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=2,description="This test case  verifies get  Country details",enabled=true)
	void verifyGetCountryDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		/*
		 * httprequest.header("H-CompId","1"); httprequest.header("H-BranchId","1");
		 */
		httprequest.header("H-RequesterId","fss-ui");//contactpersonId
		//httprequest.pathParam("contactpersonId", 1);
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/country/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies get  Countries details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=3,description="This test case  verifies get  Countries details",enabled=true)
	void verifyGetCountriesDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		//httprequest.header("H-BranchId","1");
		httprequest.header("H-RequesterId","fss-ui");//contactpersonId
		//httprequest.pathParam("contactpersonId", 1);
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/countries");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies delete  Country details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=4,description="This test case  verifies delete  Country details",enabled=true)
	void verifyDeleteCountryDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		//httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		//httprequest.pathParam("airlineId",1);
		responce= httprequest.request(Method.DELETE,"/admin/country/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}


}
