package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.memberDao;
import com.example.demo.vo.member;
import com.example.demo.mapper.memberMapper;
@Service
public class memberDaoImpl implements memberDao {
	@Autowired
	memberMapper memberMapper;

	@Override
	public void add(member m) {
		memberMapper.add(m);
	}

	@Override
	public List<member> queryAll() {
		memberMapper.queryAll();
		return memberMapper.queryAll();
	}

	@Override
	public member queryMember(String username, String password) {
		member m = memberMapper.queryMember(username, password);
		if (m != null)
			return m;
		else
			return null;
	}

	@Override
	public boolean queryUsername(String username) {
		boolean x = false;
		member m = memberMapper.queryUsernamer(username);
		if (m != null) {
			x = true;
		}
		return x;
	}

}
