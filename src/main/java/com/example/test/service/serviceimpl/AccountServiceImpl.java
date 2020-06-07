package com.example.test.service.serviceimpl;


import com.example.test.mapper.AccountInfoMapper;
import com.example.test.model.AccountInfo;
import com.example.test.model.AccountLogin;
import com.example.test.model.response.DefaultResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.example.test.mapper.AccountLoginMapper;
import com.example.test.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountLoginMapper accountLoginMapper;

	@Resource
	private AccountInfoMapper accountInfoMapper;


	@Override
	public int insertAccountInfo(AccountInfo accountInfo) {
		return accountInfoMapper.insert(accountInfo);
	}

	@Override
	public DefaultResponse findAccountInfoByUsername(String username) {

		List<AccountInfo> accountInfoList = accountInfoMapper.findByUsername(username);
		DefaultResponse response = new DefaultResponse();
		if (accountInfoList.size() == 0) {
			response.success(0);
		}
		return response;
	}

	@Override
	public int insertAccountLogin(AccountLogin accountLogin) {
		return 0;
	}

	@Override
	public DefaultResponse findAccountLoginByPhone(String phone) {
		return null;
	}
}
