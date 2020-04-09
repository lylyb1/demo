package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Member;
import com.example.demo.service.IMember;
 
@Controller 
@MapperScan("com.example.demo.dao") //mapper扫描
public class LoginController{
	@Autowired
	IMember iMemberFunc;

	@RequestMapping(value = "/hello")
	public String hello(){
		System.out.println("Hello");
		return "Log";
	}

	/**
	 * 返回json字符串
	 * 
	 * @return
	 */
	@RequestMapping("getJson")
	@ResponseBody
	public List<Member> getJson() {
		List<Member> welcomes = new ArrayList<>();
		Member w1 = new Member();
		w1.setId(1);
		w1.setName("xx1");

		Member w2 = new Member();
		w2.setId(2);
		w2.setName("xx2");
		welcomes.add(w1);
		welcomes.add(w2);

		return welcomes;
	}
 
	@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String addUser1(String name,String password) {
        System.out.println("loginName is:"+name);
        System.out.println("loginPassword is:"+password);
        try {
			Member member = iMemberFunc.login(name, password);
			if(member == null){
				System.out.println("登录失败");
				return "Log_fail";
			}else {
				System.out.println("登录成功");
				return "Log_success";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("登录异常");
		}
		return null;
        
	}
 
}

