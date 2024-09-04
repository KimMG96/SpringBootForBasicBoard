package com.toyproject.springbootforbasicboard.auth.service.mapper;

import com.toyproject.springbootforbasicboard.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface AuthMapper {

    public int selectAllUsersCount() throws Exception;

    public List<UserVO> selectAllUsers() throws Exception;

    public int selectUserCountByUserId(String uiId) throws Exception;

    public int insertUserInfo(Map<String, Object> signUpData) throws Exception;

    public void insertUseHistoryInfo(Map<String, Object> HistoryData) throws Exception;

}
