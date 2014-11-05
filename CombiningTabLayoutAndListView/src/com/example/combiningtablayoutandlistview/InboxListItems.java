package com.example.combiningtablayoutandlistview;


public class InboxListItems {
	public String from;
	public String subject;
	public String date;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public InboxListItems(String from, String subject, String date) {
		this.from = from;
		this.subject = subject;
		this.date = date;
	}
	
}
