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
	
	public long getHoursBetweenBedandMidnight(int bedAndMidnightHours) {
		long hoursBetweenBedandMidnight = 4;
		long payrate2 = (hoursBetweenBedandMidnight*rateBetweenBedandMidnight);
		return payrate2;
	}
	
	
	public long getHoursBetweenMidnightandEndTime(int lateNightHours) {
		long hoursBetweenMidnightandEnd = 4;
//		return hoursBetweenBedandMidnight;
		long payRate3 = (hoursBetweenMidnightandEnd*rateBetweenMidnightandDeparture);
		return payRate3;
	}
}
