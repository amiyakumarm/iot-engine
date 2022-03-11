package com.iotengine;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iotengine.core.EngineCore;
import com.iotengine.dao.IOTGatewayRepo;
import com.iotengine.dto.RawItemInsight;

@SpringBootTest
class IOTEngineApplicationTests {

	String[][] result = { 
			{ "Parle-G", "Food", "2017-07-23 13:10:00", "3" },
			{ "Parle-G", "Food", "2017-07-23 13:11:00", "3" },
			{ "Parle-G", "Food", "2017-07-23 13:12:00", "3" },
			{ "Parle-G", "Food", "2017-07-23 13:13:00", "3" },
			{ "Parle-G", "Food", "2017-07-23 13:15:00", "3" },
			{ "Parle-G", "Food", "2017-07-23 13:17:00", "3" },
			{ "Parle-G", "Food", "2017-07-23 14:10:00", "3" },
			{ "Parle-G", "Food", "2017-07-23 13:11:00", "3" },
			{ "Parle-G", "Food", "2017-07-23 13:15:00", "3" },
			{ "Parle-G", "Food", "2017-07-23 13:16:00", "3" },
			};

	@Autowired
	EngineCore engineCore;
	@Autowired
	IOTGatewayRepo iotGatewayRepo;

	@Test
	void contextLoads() {
		List<RawItemInsight> items = iotGatewayRepo.getItemList(result);
		System.out.println(items.size());
		try {
			engineCore.doProcess(items,1);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
