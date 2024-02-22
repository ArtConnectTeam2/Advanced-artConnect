package com.multi.artConnect.member;

import java.sql.Date;
import java.util.List;

public class MemberVO {
	private String memberID;
	private String memberPW;
	private String memberName;
	private Date memberBirth;
	private String memberGender;
	private String memberAddr;
	private String memberTel;
	private String memberEmail;
	private boolean enabled;
	
	private java.util.Date regDate;
	private java.util.Date updateDate;
	private List<AuthVO> authList;
	
	public java.util.Date getRegDate() {
		return regDate;
	}
	public void setRegDate(java.util.Date regDate) {
		this.regDate = regDate;
	}
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<AuthVO> getAuthList() {
		return authList;
	}
	public void setAuthList(List<AuthVO> authList) {
		this.authList = authList;
	}
	
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	private String memberAlarm;
	
	public String getmemberID() {
		return memberID;
	}
	public void setmemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getmemberPW() {
		return memberPW;
	}
	public void setmemberPW(String memberPW) {
		this.memberPW = memberPW;
	}
	public String getmemberName() {
		return memberName;
	}
	public void setmemberName(String memberName) {
		this.memberName = memberName;
	}
	public Date getmemberBirth() {
		return memberBirth;
	}
	public void setmemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getmemberGender() {
		return memberGender;
	}
	public void setmemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getmemberAddr() {
		return memberAddr;
	}
	public void setmemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getmemberTel() {
		return memberTel;
	}
	public void setmemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getmemberAlarm() {
		return memberAlarm;
	}
	public void setmemberAlarm(String memberAlarm) {
		this.memberAlarm = memberAlarm;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "MemberVO [memberID=" + memberID + ", memberPW=" + memberPW + ", memberName=" + memberName
				+ ", memberBirth=" + memberBirth + ", memberGender=" + memberGender + ", memberAddr=" + memberAddr
				+ ", memberTel=" + memberTel + ", memberEmail=" + memberEmail + ", regDate=" + regDate + ", updateDate="
				+ updateDate + ", authList=" + authList + ", memberAlarm=" + memberAlarm + "]";
	}
	
	
	
	
	
	
}
