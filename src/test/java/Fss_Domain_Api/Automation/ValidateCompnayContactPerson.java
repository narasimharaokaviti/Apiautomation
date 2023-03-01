package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateCompnayContactPerson {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This test case  verifies Create NewCompany ContactPerson
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=0,description="This test case  verifies Create NewCompany ContactPerson",enabled=true)
	void verifyCreateNewCompanyContactPerson() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		JSONObject request=new JSONObject();
		request.put("company",1);
		request.put("contactPersonId",1);
		request.put("createdBy",1);
		request.put("designation","account");
		request.put("email","raoh2233j@gmail.com");
		request.put("firstName","narsiha");  
		request.put("lastName","raokk");
		request.put("middleName","kavitii3");
		request.put("phone","6302665982");
		request.put("title","mr");
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/company/contactPerson");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies update NewCompany ContactPerson
	 * @Parameters:No
	 * @return: NO
	 */
	
	@Test(priority=1,description="This testcase verifies update NewCompany ContactPerson",enabled=true)
	void verifyUpdateCompanyContactPerson() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("company",1);
		request.put("contactPersonId",1);
		request.put("createdBy",1);
		request.put("designation","account");
		request.put("email","raoh2233j@gmail.com");
		request.put("firstName","narsiha");  
		request.put("lastName","raokk");
		request.put("middleName","kavitii3");
		request.put("phone","6302665882");
		request.put("title","mr");
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.PUT,"/admin/company/contactPerson");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies get NewCompany ContactPersons details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=2,description="This test case  verifies get NewCompany ContactPersons details",enabled=true)
	void verifyGetCompanyContactPersonsDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/company/contactPersons");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies delete NewCompany ContactPerson details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=3,description="This test case  verifies delete NewCompany ContactPerson details",enabled=true)
	void verifyDeleteAirlineDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		//httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		//httprequest.pathParam("airlineId",1);
		responce= httprequest.request(Method.DELETE,"/admin/company/contactPerson/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}

}
