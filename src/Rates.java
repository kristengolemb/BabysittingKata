import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.HashMap;

import main.StartTime;
import main.EndTime;

public class Rates {
	StartTime start = new StartTime();
	LocalTime bed = LocalTime.of(20,00);
	LocalTime midnight = LocalTime.of(00, 00);
	EndTime end = new EndTime();
	int invoice = 0;

	long rateBetweenStartandBed = 12;
	long rateBetweenBedandMidnight = 8;
	long rateBetweenMidnightandDeparture = 16;

	public long getHoursBetweenArrivalandBedtime() {
		long hoursBetweenArrivalandBedtime = ChronoUnit.HOURS.between((Temporal) start, bed);
		return hoursBetweenArrivalandBedtime;
	}
	
	public long getHoursBetweenBedandMidnight() {
		long hoursBetweenBedandMidnight = ChronoUnit.HOURS.between((Temporal) bed, midnight);
		return hoursBetweenBedandMidnight;
	}
	
	public long getHoursBetweenMidnightandEndTime(int lateNightHours) {
		long hoursBetweenMidnightandEnd = 4;
//		return hoursBetweenBedandMidnight;
		long payRate3 = (hoursBetweenMidnightandEnd*rateBetweenMidnightandDeparture);
		return payRate3;
	}

//public Integer getRate (int hours, int hourlyPay) {
//	int amtOwed = 0;
//	
//	if (hoursBetweenArrivalandBedtime > 0) {
//		amtOwed += hoursBetweenArrivalandBedtime * rateBetweenStartandBed;
//	}
//	
//	return amtOwed;
//}
}
