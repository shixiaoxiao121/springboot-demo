package com.example.test.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.test.model.AccountLogin;

@Mapper
public interface AccountLoginMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(AccountLogin record);

	List<AccountLogin> findByPhone(@Param("phone")String phone);



}