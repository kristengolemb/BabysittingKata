package main;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Rates {
	
	LocalTime start = LocalTime.of(17,00);
	LocalTime bed = LocalTime.of(20,00);
	LocalTime midnight = LocalTime.of(00, 00);
	LocalTime end = LocalTime.of(04, 00);
	int invoiceTotal = 0;

	long rateBetweenStartandBed = 12;
	long rateBetweenBedandMidnight = 8;
	long rateBetweenMidnightandDeparture = 16;

	public long getHoursBetweenArrivalandBedtime() {
		long hoursBetweenArrivalandBedtime = ChronoUnit.HOURS.between(start, bed);
		long earlyNightPay = (hoursBetweenArrivalandBedtime*rateBetweenStartandBed);
		return earlyNightPay;
	}
	
	public long getHoursBetweenBedandMidnight() {
		long hoursBetweenBedandMidnight = ChronoUnit.HOURS.between(bed,midnight);
		long middleNightPay = (hoursBetweenBedandMidnight*rateBetweenBedandMidnight);
		return middleNightPay;
	}
	
	public long getHoursBetweenMidnightandEndTime() {
		long hoursBetweenMidnightandEnd = ChronoUnit.HOURS.between(midnight, end);
		long lateNightPay = (hoursBetweenMidnightandEnd*rateBetweenMidnightandDeparture);
		return lateNightPay;
	}
}