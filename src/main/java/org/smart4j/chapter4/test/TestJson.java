package org.smart4j.chapter4.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.smart4j.framework.util.JsonUtil;
/**
 * json转换测试
 * @author Administrator
 *
 */
public class TestJson {
	
	public static void main(String[] args) {
		List<Map<String, Object>> list  = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		list.add(map);
		
		String json = JsonUtil.toJson(map);
		
		System.out.println(json);
		
		Map fromJson = JsonUtil.fromJson(json, Map.class);
		
		System.out.println(fromJson);
		
	}
	
	
	
}
