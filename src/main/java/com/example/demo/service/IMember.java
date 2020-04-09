package com.example.demo.service;

import com.example.demo.entity.Member;

public interface IMember {
	Member login(String name, String passsword) throws Exception;
}
