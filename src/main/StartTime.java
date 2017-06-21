package main;
import java.time.*;

public class StartTime {
	public LocalTime getStartTime() {
		LocalTime startTime = LocalTime.of(17,00);
		LocalTime actualArrivalTime = LocalTime.of(16, 30);
		if (actualArrivalTime.isBefore(startTime)) {
			System.out.println("Too early to clock in!");
		}
		else {
			System.out.println("Start time accepted.");
		}
		return actualArrivalTime;
	}
}