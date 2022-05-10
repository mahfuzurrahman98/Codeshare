package com.noobs.codeshare;

import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class DT {

	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		//System.out.println(dateTime);
		LocalDateTime dt = dateTime.plusHours(24);
		//System.out.println(dt);
		
//---------------------------------------------------------
		
		java.sql.Timestamp sqlTime = java.sql.Timestamp.valueOf(dateTime);
		System.out.println(sqlTime.toString());
		java.sql.Timestamp sqlTime2 = java.sql.Timestamp.valueOf(dt);
		System.out.println(sqlTime2);
	}
}
