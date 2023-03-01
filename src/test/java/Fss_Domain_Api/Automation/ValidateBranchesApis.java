package Fss_Domain_Api.Automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateBranchesApis {
	RequestSpecification httprequest;
	JSONObject request;
	Response responce;
	String responcebody;
	int responcecode;
	/*
	 * This testcase verifies creata a new branch
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=0,description="This testcase verifies creata a new branch",enabled=false)
	void verifyCreateNewBranch() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("addressId",1);
		request.put("addressLine1","vij");
		request.put("addressLine2","west vij");
		request.put("addressType","gandhi nagr");
		request.put("city","vij");
		request.put("country",1);
		request.put("createdBy",1);
		request.put("district","NTR");
		request.put("phone","6302665982");
		request.put("postalCode","534223");
		request.put("region",1);
		request.put("state",1);
		request.put("updatedBy",1);
		request.put("branchCode","NTRG");
		request.put("branchId",1);
		request.put("companyId",1);
		request.put("createdBy",1);
		request.put("email","naraWwer@gmail.com");
		request.put("gstNumber","37AADCS0472N1Z1");
		request.put("gstState",1);
		request.put("location","ANDHRA");
		request.put("name","krishna");
		request.put("registeredGST",1);
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.POST,"/admin/branch");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This testcase verifies update existing branch details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=1,description="This testcase verifies update existing branch details",enabled=false)
	void verifyUpdateBranch() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		request.put("addressId",1);
		request.put("addressLine1","vij");
		request.put("addressLine2","west vij");
		request.put("addressType","gandhi nagr");
		request.put("city","vij");
		request.put("country",1);
		request.put("createdBy",1);
		request.put("district","NTR");
		request.put("phone","6302665982");
		request.put("postalCode","534223");
		request.put("region",1);
		request.put("state",1);
		request.put("updatedBy",1);
		request.put("branchCode","NTRG");
		request.put("branchId",1);
		request.put("companyId",1);
		request.put("createdBy",1);
		request.put("email","naraWwer@gmail.com");
		request.put("gstNumber","37AADCS0472N1Z1");
		request.put("gstState",1);
		request.put("location","ANDHRA");
		request.put("name","ramesh");
		request.put("registeredGST",1);
		request.put("updatedBy",1);
		httprequest.body(request.toJSONString());
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.PUT,"/admin/branch");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This testcase verifies get all branch details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=2,description="This testcase verifies get all branch details",enabled=false)
	void verifyGetbranchesDetails() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		responce= httprequest.request(Method.GET,"/admin/branches");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}
	/*
	 * This testcase verifies delete existing branch details
	 * @return: NO
	 * @parameters: NO
	 */
	@Test(priority=3,description="This testcase verifies delete existing branch details",enabled=false)
	void verifyDeletebranchDetailsS() {
		RestAssured.baseURI=Constants.URI;
		httprequest=RestAssured.given();
		request=new JSONObject();
		//httprequest.header("Content-Type","application/json");
		httprequest.header("H-CompId","1");
		httprequest.header("H-RequesterId","fss-ui");
		httprequest.header("Authorization",Constants.authorization);
		//httprequest.pathParam("airlineId",1);
		responce= httprequest.request(Method.DELETE,"/admin/branch/1");
		httprequest.body(request.toJSONString());
		responcebody=responce.getBody().asString();
		System.out.println("responce body is "+responcebody);
		responcecode=responce.getStatusCode();
		System.out.println("responce code is "+responcecode);
		Assert.assertEquals(responcecode, 200);
	}

}
