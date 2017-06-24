package main;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Rates {

	LocalDateTime start = LocalDateTime.of(2017, 06, 01, 17,00);
	LocalDateTime bed = LocalDateTime.of(2017, 06, 01, 20,00);
	LocalDateTime midnight = LocalDateTime.of(2017, 06, 02, 00,00);
	LocalDateTime end = LocalDateTime.of(2017, 06, 02, 04, 00);

	long rateBetweenStartandBed = 12;
	long rateBetweenBedandMidnight = 8;
	long rateBetweenMidnightandDeparture = 16;
	
	public String testArrival(LocalDateTime start) {
		if (start.isAfter(LocalDateTime.of(2017, 06, 01, 17, 00))) {
			return "Acceptable start time.";
		}
		else return "Unacceptable start time.";
	}
	
	public String testDeparture(LocalDateTime depart) {
		if (depart.isBefore(LocalDateTime.of(2017, 06, 02, 04, 00))) {
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