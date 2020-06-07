package com.example.test.model;

import java.util.Date;
import lombok.Data;

/**
 * 用户信息
 */
@Data
public class AccountInfo {
	private Integer id;

	private Integer loginId;

	private String username;

	private Date createdAt;

	private Date updatedAt;
}