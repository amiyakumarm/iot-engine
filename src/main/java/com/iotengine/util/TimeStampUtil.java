package com.iotengine.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeStampUtil {
	protected TimeStampUtil() {

	}

	public static long timestampDiff(String from, String to) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

		Date d1 = null;
		Date d2 = null;
		try {
			d2 = format.parse(from);
			d1 = format.parse(to);

			long diff = d2.getTime() - d1.getTime();

			long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
			return minutes;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static String increment(String timestamp, int val) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		try {
			Date date = format.parse(timestamp);
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(date.getTime());

			cal.add(Calendar.MINUTE, val);

			return format.format(cal.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}
}
