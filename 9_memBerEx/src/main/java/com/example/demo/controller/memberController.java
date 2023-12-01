package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.vo.member;

import com.example.demo.service.impl.memberDaoImpl;

@RestController
public class memberController {
	@Autowired
	memberDaoImpl mdi;

	@RequestMapping("addMember")
	public ModelAndView addMember() {
		ModelAndView mav = new ModelAndView("addMember");
		return mav;
	}

	@PostMapping("/login")
	public ModelAndView login(String username,String password)
	{
		member m=mdi.queryMember(username, password);
		
		ModelAndView mav=null;
		if(m!=null)
		{
			mav=new ModelAndView("/loginSuccess");
		}else{
			mav=new ModelAndView("/loginError");
		}
		return mav;
	}

	@PostMapping("add")
	public ModelAndView addmember(String username,String password,String name
									,String address,String phone,String mobile) {
		boolean u = mdi.queryUsername(username); //確認username是否重複
		ModelAndView mav = null;
		if(u==true) {
			mav = new ModelAndView("/addMemberError");
		}else {
			member m = new member(username,password,name,address,phone,mobile);
			mdi.add(m);
			mav = new ModelAndView("/addMemberSuccess");
		}
		return mav;
	}
}
