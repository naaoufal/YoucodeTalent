package models;

import java.time.LocalDateTime;

public class ParticipationModels {

	private long userID;
	private Long categoryID;
	private String descParti;
	private LocalDateTime timeStart;
	private LocalDateTime timeEnd;
	private String attachedFile;
	private boolean isAccepted;
	
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userId) {
		this.userID = userId;
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
	public String getDescParti() {
		return descParti;
	}
	public void setDescParti(String descParti) {
		this.descParti = descParti;
	}
	public LocalDateTime getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(LocalDateTime timeStart) {
		this.timeStart = timeStart;
	}
	public LocalDateTime getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(LocalDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getAttachedFile() {
		return attachedFile;
	}
	public void setAttachedFile(String attachedFile) {
		this.attachedFile = attachedFile;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	@Override
	public String toString() {
		return "ParticipationModels [userID=" + userID + ", categoryID=" + categoryID + ", descParti=" + descParti
				+ ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", attachedFile=" + attachedFile
				+ ", isAccepted=" + isAccepted + "]";
	}
}
