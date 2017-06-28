package com.myproject.springmvc.model;

import java.util.Date;

public class TodoList {
	private long id;
	private String todoListDetail;
	private String createName;
	private Date createDate;
	private int isStatus;
	private Date stopDate;
	
	public TodoList() {
		id=0;
	}
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTodoListDetail() {
		return todoListDetail;
	}
	public void setTodoListDetail(String todoListDetail) {
		this.todoListDetail = todoListDetail;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
 
	public Date getStopDate() {
		return stopDate;
	}
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	public int getIsStatus() {
		return isStatus;
	}

	public void setIsStatus(int isStatus) {
		this.isStatus = isStatus;
	}

	@Override
	public String toString() {
		return "TodoList [id=" + id + ", todoListDetail=" + todoListDetail + ", createName=" + createName
				+ ", createDate=" + createDate + ", isStatus=" + isStatus + ", stopDate=" + stopDate + "]";
	}

	public TodoList(long id, String todoListDetail, String createName, Date createDate, int isStatus, Date stopDate) {
		this.id = id;
		this.todoListDetail = todoListDetail;
		this.createName = createName;
		this.createDate = createDate;
		this.isStatus = isStatus;
		this.stopDate = stopDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((createName == null) ? 0 : createName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + isStatus;
		result = prime * result + ((stopDate == null) ? 0 : stopDate.hashCode());
		result = prime * result + ((todoListDetail == null) ? 0 : todoListDetail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TodoList other = (TodoList) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (createName == null) {
			if (other.createName != null)
				return false;
		} else if (!createName.equals(other.createName))
			return false;
		if (id != other.id)
			return false;
		if (isStatus != other.isStatus)
			return false;
		if (stopDate == null) {
			if (other.stopDate != null)
				return false;
		} else if (!stopDate.equals(other.stopDate))
			return false;
		if (todoListDetail == null) {
			if (other.todoListDetail != null)
				return false;
		} else if (!todoListDetail.equals(other.todoListDetail))
			return false;
		return true;
	}
	
	
}
