package org.comet4j.demo.talker;

import java.util.HashMap;
import java.util.Map;

/**
 * @description AppStore
 * @author 不了了之之了之
 * @data 2013-5-29
 */
public class AppStore {
	private static Map<String, String> map;
	private static AppStore instance;

	public static AppStore getInstance() {
		if (instance == null) {
			instance = new AppStore();
			map = new HashMap<String, String>();
		}
		return instance;
	}

	public void put(String key, String value) {
		map.put(key, value);
	}

	public String get(String key) {
		return (String) map.get(key);
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void destroy() {
		map.clear();
		map = null;
	}
}