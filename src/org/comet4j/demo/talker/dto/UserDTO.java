package org.comet4j.demo.talker.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description UserDTO
 * @author 不了了之之了之
 * @data 2013-5-29
 */
public class UserDTO {
	private final String transtime;
	private String id;
	private String name;

	public UserDTO(String id, String name) {
		this.id = id;
		this.name = name;
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat f = new SimpleDateFormat("HH:mm");
		this.transtime = f.format(d);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTranstime() {
		return this.transtime;
	}
}