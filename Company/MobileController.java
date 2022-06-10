package com.Company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileController {
	@Autowired
	 MobileService  mobileService;
	@RequestMapping("/mobile")
	public List<Mobile> mobileList(){
		return mobileService.getAllmobiles();		
	}
	@RequestMapping("/mobile/{id}")
	public Mobile  singlemobile(@PathVariable String id){
		return mobileService.getproduct(id);
	}
	@RequestMapping(method = RequestMethod.POST,value="/mobile")
	public void addMobile(@RequestBody Mobile mobile) {
		mobileService.addMobile(mobile);
	}
	@RequestMapping(method = RequestMethod.PUT,value="/mobile{id}")
	public void updateMobile(@PathVariable String id,@RequestBody Mobile mobile) {
		mobileService.updateMobile(id,mobile);
	}
}
