package com.example.test.service.serviceimpl;


import com.example.test.mapper.AccountInfoMapper;
import com.example.test.model.AccountInfo;
import com.example.test.model.AccountLogin;
import com.example.test.model.request.RegisterRequest;
import com.example.test.model.response.DefaultResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.example.test.mapper.AccountLoginMapper;
import com.example.test.service.AccountService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shixiaoxiao
 */
@Service
@Log4j2
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
		response.setMessage("昵称已存在");
		return response;
	}

	@Override
	public int insertAccountLogin(AccountLogin accountLogin) {
		return 0;
	}

	@Override
	public DefaultResponse findAccountLoginByPhone(String phone) {

		List<AccountLogin> accountLoginList = accountLoginMapper.findByPhone(phone);
		DefaultResponse response = new DefaultResponse();
		if (accountLoginList.size() == 0) {
			response.success(0);
		}
		response.setMessage("该手机号已被注册");
		return response;
	}

	@Override
	@Transactional(rollbackFor = {RuntimeException.class,Error.class})
	public DefaultResponse Register(RegisterRequest registerRequest) {

		AccountLogin login = new AccountLogin();
		login.setPhone(registerRequest.getPhone());
		login.setPassword(registerRequest.getPassword());
		accountLoginMapper.insert(login);
		log.info("login:" + login);
		AccountInfo info = new AccountInfo();
		info.setLoginId(login.getId());
		info.setUsername(registerRequest.getUsername());
		accountInfoMapper.insert(info);

		DefaultResponse response = new DefaultResponse();
		response.success(null);
		return response;
	}
}
