package main;
import java.time.*;

public class EndTime {
	public LocalTime getEndTime() {
		LocalTime endTime = LocalTime.of(04,00);
		LocalTime actualEndTime = LocalTime.of(03, 30);
		if (actualEndTime.isAfter(endTime)) {
			System.out.println("You are only paid until 4am!");
		}
		else {
			System.out.println("Have a good night!");
		}
		return actualEndTime;
	}
}