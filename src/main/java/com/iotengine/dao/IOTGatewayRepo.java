package com.iotengine.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iotengine.dto.DemoClientItemInsight;
import com.iotengine.dto.RawItemInsight;


@Repository
public class IOTGatewayRepo {

	public List<RawItemInsight> getItemList(String[][] items) {
		List<RawItemInsight> list = new LinkedList<>();
		
		for (String[] rawItem : items) {
			RawItemInsight item = new DemoClientItemInsight();
			list.add(item);
			item.setName(rawItem[0]);
			item.setCategory(rawItem[1]);
			item.setTimestamp(rawItem[2]);
			item.setCount(Integer.valueOf(rawItem[3]));
		}
		return list;
	}
}