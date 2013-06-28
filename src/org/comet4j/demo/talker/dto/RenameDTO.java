package org.comet4j.demo.talker.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description RenameDTO
 * @author 不了了之之了之
 * @data 2013-5-29
 */
public class RenameDTO {
	private final String transtime;
	private String type;
	private String id;
	private String newName;
	private String oldName;

	public RenameDTO(String id, String oldName, String newName) {
		this.type = "rename";
		this.id = id;
		this.oldName = oldName;
		this.newName = newName;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNewName() {
		return this.newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getOldName() {
		return this.oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getTranstime() {
		return this.transtime;
	}
}