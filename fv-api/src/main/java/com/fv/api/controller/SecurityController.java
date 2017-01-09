package com.fv.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fv.api.constant.HttpConstant;
import com.fv.api.constant.URIConstant;
import com.fv.api.dto.LoginRequest;
import com.fv.api.dto.RestaurantDetail;
import com.fv.api.service.SecurityService;
import com.fv.common.util.Either;
import com.fv.common.util.Errors;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Ravi Chauhan
 *
 */
@Controller
@Api(value = HttpConstant.SECURITY_API, basePath=URIConstant.SECURITY_API_BASE, 
produces=HttpConstant.PRODUCES_JSON, consumes=HttpConstant.CONSUMES_JSON, position=1)
public class SecurityController {

	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);

	@Autowired
	private SecurityService securityService;
	
	@ApiOperation(value = "Login Request", notes = "Login with credentials and send restaurant details or error.")
	@RequestMapping(value = URIConstant.SIGNIN, method = RequestMethod.POST)
	public @ResponseBody Either<RestaurantDetail> getLoginDetail(@RequestBody LoginRequest loginRequest){
		Errors errors= new Errors();
		Either<RestaurantDetail> response = securityService.getLoginDetail(loginRequest, errors); 
		if(response.hasErrors()){
			
		}
		return response;
	}

	//	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	//	@RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
	//	public @ResponseBody Employee getDummyEmployee() {
	//		logger.info("Start getDummyEmployee");
	//		Employee emp = new Employee();
	//		emp.setId(9999);
	//		emp.setName("Dummy");
	//		emp.setCreatedDate(new Date());
	//		empData.put(9999, emp);
	//		return emp;
	//	}
	//	
	//	@RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
	//	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
	//		logger.info("Start getEmployee. ID="+empId);
	//		
	//		return empData.get(empId);
	//	}
	//	
	//	@RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	//	public @ResponseBody List<Employee> getAllEmployees() {
	//		logger.info("Start getAllEmployees.");
	//		List<Employee> emps = new ArrayList<Employee>();
	//		Set<Integer> empIdKeys = empData.keySet();
	//		for(Integer i : empIdKeys){
	//			emps.add(empData.get(i));
	//		}
	//		return emps;
	//	}
	//	
	//	@RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
	//	public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
	//		logger.info("Start createEmployee.");
	//		emp.setCreatedDate(new Date());
	//		empData.put(emp.getId(), emp);
	//		return emp;
	//	}
	//	
	//	@RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
	//	public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
	//		logger.info("Start deleteEmployee.");
	//		Employee emp = empData.get(empId);
	//		empData.remove(empId);
	//		return emp;
	//	}

}
