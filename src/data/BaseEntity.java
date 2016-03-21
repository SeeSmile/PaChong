package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseEntity {
	private String type;
	private String time;
	
	public BaseEntity(String type) {
		this.type = type;
		initTime();
	}
	
	public void initTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.time = format.format(new Date());
	}
	
	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
		
	}
}
