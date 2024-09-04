package com.toyproject.springbootforbasicboard.auth.service.mapper;

import com.toyproject.springbootforbasicboard.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthMapper {

    int selectAllUsersCount() throws Exception;

    List<UserVO> selectAllUsers() throws Exception;

    int selectUserCountByUserId(String uiId) throws Exception;

    int selectUserCountByUserIdWithPwd(Map<String, Object> signInData) throws Exception;

    Map<String, Object> selectUserInfoByUserIdUserPwd(Map<String, Object> signInData) throws Exception;

    void insertUserInfo(Map<String, Object> signUpData) throws Exception;

    void insertUseHistoryInfo(Map<String, Object> HistoryData) throws Exception;

}
