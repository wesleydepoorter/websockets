package com.wesley.streamgame;


import java.util.Date;

public class GameDatapoint {
	private String uuid;
	private int colorCode;
	private int colorTeam;
	private Date timestamp;


	public GameDatapoint() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getColorCode() {
		return colorCode;
	}

	public void setColorCode(int colorCode) {
		this.colorCode = colorCode;
	}

	public int getColorTeam() {
		return colorTeam;
	}

	public void setColorTeam(int colorTeam) {
		this.colorTeam = colorTeam;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
