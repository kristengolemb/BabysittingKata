package main;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Rates {

	LocalDateTime start = LocalDateTime.of(2017, 06, 01, 17,00);
	LocalDateTime bed = LocalDateTime.of(2017, 06, 01, 20,00);
	LocalDateTime midnight = LocalDateTime.of(2017, 06, 02, 00,00);
	LocalDateTime end = LocalDateTime.of(2017, 06, 02, 04, 00);
	
	long rate1 = 12;
	long rate2 = 8;
	long rate3 = 16;
		
	public String testArrival(LocalDateTime start) {
		if (start.isAfter(LocalDateTime.of(2017, 06, 01, 17, 00))) {
			return "Acceptable start time.";
		}
		else if (start.equals(LocalDateTime.of(2017, 06, 01, 17,00))) {
			return "Right on time!";
		}
		else return "Unacceptable start time.";
	}
	
	public String testDeparture(LocalDateTime depart) {
		if (depart.isBefore(LocalDateTime.of(2017, 06, 02, 04, 00))) {
			return "Acceptable end time.";
		}
		else if (depart.equals(LocalDateTime.of(2017, 06, 02, 04, 00))) {
			return "Leaving right on time.";
		}
		else return "Unacceptable end time.";
	}

	public long getHoursBetweenArrivalandBedtime(LocalDateTime start, LocalDateTime bed) {
		long hoursBetweenArrivalandBedtime = ChronoUnit.HOURS.between(start, bed);
		long totalBetweenStartandBed = (hoursBetweenArrivalandBedtime * rate1);
		return totalBetweenStartandBed;
	}

	public long getHoursBetweenBedandMidnight(LocalDateTime bed, LocalDateTime midnight) {
		long hoursBetweenBedandMidnight = ChronoUnit.HOURS.between(bed,midnight);
		long totalBetweenBedandMidnight = (hoursBetweenBedandMidnight * rate2);
		return totalBetweenBedandMidnight;
	}

	public long getHoursBetweenMidnightandEndTime(LocalDateTime midnight, LocalDateTime end) {
		long hoursBetweenMidnightandEnd = ChronoUnit.HOURS.between(midnight, end);
		long totalBetweenMidnightandEnd = (hoursBetweenMidnightandEnd * rate3);
		return totalBetweenMidnightandEnd;
	}

	public long calculateTotal(long totalBetweenStartandBed, long totalBetweenBedandMidnight, long totalBetweenMidnightandEnd) {
		long totalOwed = totalBetweenStartandBed + totalBetweenBedandMidnight + totalBetweenMidnightandEnd;
		return totalOwed;
	}
}