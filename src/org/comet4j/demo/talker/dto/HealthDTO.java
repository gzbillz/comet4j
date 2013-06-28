package org.comet4j.demo.talker.dto;

/**
 * @description HealthDTO
 * @author 不了了之之了之
 * @data 2013-5-29
 */
public class HealthDTO {
//	private final String type = "health";
	private String totalMemory;
	private String freeMemory;
	private String maxMemory;
	private String usedMemory;
	private String connectorCount;
	private String startup;
//	private final long divider = 1048576L;

	public String getTotalMemory() {
		return this.totalMemory;
	}

	public void setTotalMemory(long totalMemory) {
		Long result = Long.valueOf(totalMemory / 1048576L);
		this.totalMemory = result.toString();
	}

	public String getFreeMemory() {
		return this.freeMemory;
	}

	public void setFreeMemory(long freeMemory) {
		Long result = Long.valueOf(freeMemory / 1048576L);
		this.freeMemory = result.toString();
	}

	public String getMaxMemory() {
		return this.maxMemory;
	}

	public void setMaxMemory(long maxMemory) {
		Long result = Long.valueOf(maxMemory / 1048576L);
		this.maxMemory = result.toString();
	}

	public String getUsedMemory() {
		return this.usedMemory;
	}

	public void setUsedMemory(long usedMemory) {
		Long result = Long.valueOf(usedMemory / 1048576L);
		this.usedMemory = result.toString();
	}

	public String getConnectorCount() {
		return this.connectorCount;
	}

	public void setConnectorCount(String connectorCount) {
		this.connectorCount = connectorCount;
	}

	public String getType() {
		return "health";
	}

	public String getStartup() {
		return this.startup;
	}

	public void setStartup(String startup) {
		this.startup = startup;
	}
}