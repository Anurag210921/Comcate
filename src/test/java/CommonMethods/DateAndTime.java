package CommonMethods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {
	public static String date1;

	public static void dateTimeGenerator() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		date1 = dateFormat.format(date);
		System.out.println(date1);

	}
}