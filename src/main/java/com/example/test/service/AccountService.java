package com.example.test.service;

import com.example.test.model.AccountInfo;
import com.example.test.model.AccountLogin;
import com.example.test.model.response.DefaultResponse;

public interface AccountService {

	int insertAccountInfo(AccountInfo accountInfo);

	DefaultResponse findAccountInfoByUsername(String username);

	int insertAccountLogin(AccountLogin accountLogin);

	DefaultResponse findAccountLoginByPhone(String phone);

}
