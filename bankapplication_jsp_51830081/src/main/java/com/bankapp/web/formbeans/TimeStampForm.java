package com.bankapp.web.formbeans;

import java.time.LocalDateTime;

public class TimeStampForm {
	private LocalDateTime fromTime;
	private LocalDateTime toTime;
	public LocalDateTime getFromTime() {
		return fromTime;
	}
	public void setFromTime(LocalDateTime fromTime) {
		this.fromTime = fromTime;
	}
	public LocalDateTime getToTime() {
		return toTime;
	}
	public void setToTime(LocalDateTime toTime) {
		this.toTime = toTime;
	}
	

}
