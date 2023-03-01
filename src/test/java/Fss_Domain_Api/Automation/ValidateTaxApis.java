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

public class ValidateTaxApis {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This testcase verifies create a TaxType
	 * @return: NO
	 * @parameters: NO
	 */

	@Test(priority=0,description="This testcase verifies create a TaxType",enabled=true)
	void verifyCreateTaxType() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("code","TAX");
		request.put("createdBy",1);
		request.put("description","taxes");
		request.put("taxTypeId",1);
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/taxType");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode =responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		String statusline=responce.getStatusLine();
		System.out.println("status line is "+ statusline);
		Headers allheaders=responce.headers();
		for(Header header:allheaders) {
		System.out.println(header.getName()+"  "+header.getValue());

		}
	}
	/*
	 * This testcase verifies Update existing taxtype
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=1,description=" This testcase verifies Update existing taxtype ",enabled=true)
	void verifyUpdatetaxtype() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request.put("code","TAXES");
		request.put("createdBy",1);
		request.put("description","taxes");
		request.put("taxTypeId",1);
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
	    responce= httprequest.request(Method.PUT,"/admin/taxType");
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
	 * This testcase verifies get all taxtype details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=2,description="This testcase verifies get all taxtype details",enabled=false)
	void verifyGetTaxTypessDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/taxTypes");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		//Assert.assertEquals(responcebody.contains("SUCESS"), true); 
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
	 * This testcase verifies get single taxtype details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=3,description="This testcase verifies get single taxtype details",enabled=true)
	void verifyGetShipline() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/taxType/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		//Assert.assertEquals(responcebody.contains("SUCESS"), true); 
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
	 * This testcase verifies delete single taxtype details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=4,description="This testcase verifies delete single taxtype details",enabled=false)
	void verifyDeleteShipline() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","25");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.DELETE,"/admin/taxType/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		//Assert.assertEquals(responcebody.contains("SUCESS"), true); 
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
		Headers allheaders=responce.headers();
		for(Header header:allheaders) {
			System.out.println(header.getName()+"  "+header.getValue());

		}
	}

}
