package com.multi.artConnect.member;

public class AuthVO {
	
	private String memberID;
	private String auth;
	

	public String getMemberID() {
		return memberID;
	}



	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}



	public String getAuth() {
		return auth;
	}



	public void setAuth(String auth) {
		this.auth = auth;
	}



	@Override
	public String toString() {
		return "AuthVO [memberID=" + memberID + ", auth=" + auth + "]";
	}


	
	
}
