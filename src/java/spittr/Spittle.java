package spittr;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.sql.Date;

public class Spittle {
	private final Long id;
	private final String message;
	private final String time;
	private Double latitude;
	private Double longtitude;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public String getTime() {
		return time;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public Spittle(String message,Date time){
		this(message,time,null,null);
	}
	
	public Spittle(String message,Date time,Double latitude,Double longtitude){
		this.id =null;
		this.message=message;
		this.time =dateFormat.format(time);
		this.longtitude=longtitude;
		this.latitude=latitude;
	}
	
	public Spittle(String message,Date time,Double latitude,Double longtitude,Long id){
		this.id =id;
		this.message=message;
		this.time =dateFormat.format(time);
		this.longtitude=longtitude;
		this.latitude=latitude;
	}
}
