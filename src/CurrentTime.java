import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {
	//public static String time() {
		//Date date=new Date();
		//SimpleDateFormat time=new SimpleDateFormat("MM/dd");
		//return time.format(date);
	//}
	public static String time1() {
		LocalDateTime today= LocalDateTime.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedDateTime = today.format(formatter);
		//<10/17>
		return formattedDateTime;
	}
	public static String time2(int bb) {
		LocalDateTime today= LocalDateTime.now();
		LocalDateTime tomorrow= today.plusDays(bb);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
		String formattedDateTime1 = tomorrow.format(formatter);
		return formattedDateTime1;
	}
	public static String time3() {
		LocalDateTime today= LocalDateTime.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formattedDateTime = today.format(formatter);
		//<10/17>
		return formattedDateTime;
	}
}
