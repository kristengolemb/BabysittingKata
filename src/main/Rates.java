package main;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Rates {

	LocalTime start = LocalTime.of(17,00);
	LocalTime bed = LocalTime.of(20,00);
	LocalTime midnight = LocalTime.of(00,00);
	LocalTime end = LocalTime.of(04, 00);

	long rateBetweenStartandBed = 12;
	long rateBetweenBedandMidnight = 8;
	long rateBetweenMidnightandDeparture = 16;
	
	public String testArrival(LocalTime start) {
		if (start.isAfter(LocalTime.of(16, 59))) {
			return "Acceptable start time.";
		}
		else return "Unacceptable start time.";
	}
	
	public String testDeparture(LocalTime depart) {
		if (depart.isBefore(LocalTime.of(03, 59))) {
			return "Acceptable end time.";
		}
		else return "Unacceptable end time.";
	}

	public long getHoursBetweenArrivalandBedtime() { 
		long hoursBetweenArrivalandBedtime = ChronoUnit.HOURS.between(start, bed);
		long earlyNightPay = (hoursBetweenArrivalandBedtime*rateBetweenStartandBed);
		return earlyNightPay;
	}


	public long getHoursBetweenBedandMidnight() {
		long hoursBetweenBedandMidnight = ChronoUnit.HOURS.between(bed,midnight);
		hoursBetweenBedandMidnight = (hoursBetweenBedandMidnight*(-1));
		long middleNightPay = (hoursBetweenBedandMidnight*rateBetweenBedandMidnight);
		return middleNightPay;
	}

	public long getHoursBetweenMidnightandEndTime() {
		long hoursBetweenMidnightandEnd = ChronoUnit.HOURS.between(midnight, end);
		long lateNightPay = (hoursBetweenMidnightandEnd*rateBetweenMidnightandDeparture);
		return lateNightPay;
	}

	public long calculateTotal(long earlyNightPay, long middleNightPay, long lateNightPay) {
		long totalOwed = (earlyNightPay + middleNightPay + lateNightPay);
		return totalOwed;
	}
}