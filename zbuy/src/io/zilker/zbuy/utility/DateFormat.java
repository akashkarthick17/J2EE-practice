package io.zilker.zbuy.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static String getCurrentFormattedDate() {
		Date date = new Date();
		SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");

		return formatdate.format(date);
	}
}
