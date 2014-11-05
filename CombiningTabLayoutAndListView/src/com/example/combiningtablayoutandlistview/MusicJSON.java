package com.example.combiningtablayoutandlistview;

import org.json.JSONException;
import org.json.JSONObject;

public class MusicJSON {
		public String from;
		public String subject;
		public String date;
		public String id;
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
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
		public MusicJSON(JSONObject json) {
			try {
				this.from = json.getString("from");
				this.subject = json.getString("subject");
				this.date = json.getString("date");
				this.id = json.getString("id");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
