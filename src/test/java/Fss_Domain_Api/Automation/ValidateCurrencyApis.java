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

public class ValidateCurrencyApis {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This test case  verifies Create new currency
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=0,description="This test case  verifies Create new currency",enabled=false)
	void verifyCreateNewCountry() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
	    request=new JSONObject();
		request.put("createdBy",1);
		request.put("currencyId",1);
		request.put("currencyName","INR");
		request.put("symbol","RS");
		request.put("territory","india");
		request.put("updatedBy",1);  
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/currency");
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
	 * This test case  verifies update existing currency details
	 * @Parameters:No
	 * @return: NO
	 */
	
	@Test(priority=1,description="This test case  verifies update existing currency details",enabled=false)
	void verifyUpdateCurrency() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("code","INDEH");
		request.put("countryId",2);
		request.put("createdBy",1);
		request.put("name","INDIA");
		request.put("updatedBy",1);
		request.put("zoneId",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.PUT,"/admin/currency");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies get  Currency details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=2,description="This test case  verifies get  Currency details",enabled=false)
	void verifyGetCurrencyDetails() {
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
		responce= httprequest.request(Method.GET,"/admin/currency/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies get  Currencies details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=3,description="This test case  verifies get  Countries details",enabled=false)
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
		responce= httprequest.request(Method.GET,"/admin/currencies");
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
	@Test(priority=4,description="This test case  verifies delete  Country details",enabled=false)
	void verifyDeleteCurrencyDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		//httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		//httprequest.pathParam("airlineId",1);
		responce= httprequest.request(Method.DELETE,"/admin/currency/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}


}
