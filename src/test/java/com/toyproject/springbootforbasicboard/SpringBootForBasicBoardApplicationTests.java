package com.toyproject.springbootforbasicboard;

import com.toyproject.springbootforbasicboard.auth.service.AuthService;
import com.toyproject.springbootforbasicboard.auth.service.mapper.AuthMapper;
import com.toyproject.springbootforbasicboard.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import java.util.List;

@SpringBootTest
//@Service
class SpringBootForBasicBoardApplicationTests  {

	@Autowired
	AuthMapper authMapper;

	@Test
	void DBTest() {
		try {
			System.out.println("success");
			List<UserVO> usrList = authMapper.selectAllUsers();
			System.out.println("usrList : " + usrList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
