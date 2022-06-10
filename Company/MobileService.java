package com.Company;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class MobileService {

	public List<Mobile> mobileList=
			Arrays.asList(new Mobile("101","SonyEricsion","Sony"),
					new Mobile("102","SamsungA50","Samsung"),
					new Mobile(" 103","13pro","iphone"));



	public List<Mobile>getAllmobiles(){
		return   mobileList;
	}

	public Mobile getproduct(String id) {
		return mobileList.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	public void addMobile(Mobile mobile) {
		mobileList.add(mobile);		
	}

	public void updateMobile(String id, Mobile mobile) {
		for(int i=0;i<mobileList.size();i++) {
			if(mobileList.get(i).getId().equals(id));
		}
		
	}

	public void deleteMobile(String id) {
		mobileList.removeIf(r->r.getId().equals(id));
	}
}
