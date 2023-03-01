package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateContactPersonApis {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This test case  verifies Create new ContactPerson
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=0,description="This test case  verifies Create New ContactPerson",enabled=true)
	void verifyCreateNewContactPerson() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
	 request=new JSONObject();
		request.put("contactPersonId",1);
		request.put("createdBy",1);
		request.put("customer	",1);
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
		httprequest.header("H-CompId","1");//H-BranchId
		httprequest.header("H-BranchId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/contactPerson");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies update ContactPerson details
	 * @Parameters:No
	 * @return: NO
	 */
	
	@Test(priority=1,description="This testcase verifies update ContactPerson",enabled=true)
	void verifyUpdateContactPerson() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("contactPersonId",1);
		request.put("createdBy",1);
		request.put("customer	",1);
		request.put("designation","account");
		request.put("email","raoh2233j@gmail.com");
		request.put("firstName","narsiha");  
		request.put("lastName","raokk");
		request.put("middleName","kavitii3");
		request.put("phone","6302665482");
		request.put("title","mr");
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-BranchId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.PUT,"/admin/contactPerson");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies get  ContactPersons details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=2,description="This test case  verifies get  ContactPersons details",enabled=true)
	void verifyGetContactPersonsDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-BranchId","1");
		httprequest.header("H-RequesterId","fss-ui");//contactpersonId
		//httprequest.pathParam("contactpersonId", 1);
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/company/contactPerson/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This test case  verifies get  ContactPersons details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=3,description="This test case  verifies get  ContactPerson details",enabled=true)
	void verifyGetContactPersonDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		//httprequest.header("H-BranchId","1");
		httprequest.header("H-RequesterId","fss-ui");//contactpersonId
		//httprequest.pathParam("contactpersonId", 1);
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
	 * This test case  verifies delete  ContactPerson details
	 * @Parameters:No
	 * @return: NO
	 */
	@Test(priority=4,description="This test case  verifies delete  ContactPerson details",enabled=true)
	void verifyDeleteContactPersonDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		//httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
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
