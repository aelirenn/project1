package com.aelirenn.pd.ksiazkolektyw.model;

public class UserShelfs {
	
	private String userName;
	
	private Long myShelfId;
	
	private Long toReadShelfId;
	
	private Long toBuyShelfId;
	
	private Long borrowedShelfId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getMyShelfId() {
		return myShelfId;
	}

	public void setMyShelfId(Long myShelfId) {
		this.myShelfId = myShelfId;
	}

	public Long getToReadShelfId() {
		return toReadShelfId;
	}

	public void setToReadShelfId(Long toReadShelfId) {
		this.toReadShelfId = toReadShelfId;
	}

	public Long getToBuyShelfId() {
		return toBuyShelfId;
	}

	public void setToBuyShelfId(Long toBuyShelfId) {
		this.toBuyShelfId = toBuyShelfId;
	}

	public Long getBorrowedShelfId() {
		return borrowedShelfId;
	}

	public void setBorrowedShelfId(Long borrowedShelfId) {
		this.borrowedShelfId = borrowedShelfId;
	}
	
	
}
