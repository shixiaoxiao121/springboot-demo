package com.example.test.mapper;

import com.example.test.model.AccountInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shixiaoxiao
 */
@Mapper
public interface AccountInfoMapper {

	int deleteByPrimaryKey(Integer id);

	int insert(AccountInfo record);

	List<AccountInfo> findByUsername(@Param("username") String username);

}