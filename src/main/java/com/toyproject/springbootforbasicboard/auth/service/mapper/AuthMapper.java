package com.toyproject.springbootforbasicboard.auth.service.mapper;

import com.toyproject.springbootforbasicboard.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface AuthMapper {

    public List<UserVO> selectAllUsers() throws Exception;

    public int selectAllusersCount() throws Exception;

    public void insertUserInfo(Map<String, Object> inputData) throws Exception;

}
