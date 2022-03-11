package com.iotengine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iotengine.core.EngineCore;
import com.iotengine.dao.IOTGatewayRepo;
import com.iotengine.dto.RawItemInsight;

@Component
public class TestApp {
	@Autowired
	EngineCore engineCore;
	@Autowired
	IOTGatewayRepo iotGatewayRepo;

	public void doExecute() {
		String[][] result = { 
				{ "Parle-G", "Food", "2017-07-23 13:10:00", "3" },
				{ "Parle-G", "Food", "2017-07-23 13:11:00", "3" },
				{ "Parle-G", "Food", "2017-07-23 13:12:00", "3" },
				{ "Parle-G", "Food", "2017-07-23 13:13:00", "3" },
				{ "Parle-G", "Food", "2017-07-23 13:15:00", "3" },
				{ "Parle-G", "Food", "2017-07-23 13:18:00", "3" },
				};


		List<RawItemInsight> items = iotGatewayRepo.getItemList(result);
		try {
			List<?> output = engineCore.doProcess(items, 1);
			System.out.println(output.size());
			System.out.println(output);
		} catch (Throwable e) {
		}

	}
}
