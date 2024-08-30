package com.toyproject.springbootforbasicboard;

import com.toyproject.springbootforbasicboard.auth.service.AuthService;
import com.toyproject.springbootforbasicboard.auth.service.mapper.AuthMapper;
import com.toyproject.springbootforbasicboard.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

	@Test
	void DateFormatTest() {
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		System.out.println("LocalDateTime + Formatter : " + dt.format(formatter));

		Timestamp tt = new Timestamp(System.currentTimeMillis());
		System.out.println("Timestamp + currentTimeMills : " + tt);
	}
}
