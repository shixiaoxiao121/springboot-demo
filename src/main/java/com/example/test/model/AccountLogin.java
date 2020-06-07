package com.example.test.model;

import java.util.Date;
import lombok.Data;

/**
 * 账号管理
 */
@Data
public class AccountLogin {
	private Integer id;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 登录密码
	 */
	private String password;

	private Date updatedAt;

	private Date createdAt;
}