package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.member;

public interface memberDao {
	void add(member m);
	List<member> queryAll();
	member queryMember(String username,String password);
	boolean queryUsername(String username);
}
