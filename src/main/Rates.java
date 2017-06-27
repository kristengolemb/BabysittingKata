package main;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Rates {

	LocalDateTime earliestStart = LocalDateTime.of(2017, 06, 01, 17,00);
	LocalDateTime typicalBed = LocalDateTime.of(2017, 06, 01, 20,00);
	LocalDateTime midnight = LocalDateTime.of(2017, 06, 02, 00,00);
	LocalDateTime latestEnd = LocalDateTime.of(2017, 06, 02, 04, 00);

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
	public long getHoursBetweenArrivalandBedtime(LocalDateTime start, LocalDateTime bed, LocalDateTime midnight) {
		if (start.isBefore(bed)) {
			long hoursBetweenArrivalandBedtime = ChronoUnit.HOURS.between(start, bed);
			long totalBetweenStartandBed = (hoursBetweenArrivalandBedtime * rate1);
			return totalBetweenStartandBed; 
		}
		else if (start.isAfter(bed)) {
			long hoursBetweenStartandMidnight = ChronoUnit.HOURS.between(start, midnight);
			long totalBetweenStartandMidnight = (hoursBetweenStartandMidnight * rate2);
			return totalBetweenStartandMidnight;
		}
		else return 0; 
	}

	public long getHoursBetweenBedandMidnight(LocalDateTime bed, LocalDateTime midnight, LocalDateTime end) {
		if (bed.isBefore(midnight)) {
			long hoursBetweenBedandMidnight = ChronoUnit.HOURS.between(bed,midnight);
			long totalBetweenBedandMidnight = (hoursBetweenBedandMidnight * rate2);
			return totalBetweenBedandMidnight;
		}
		else if (bed.isAfter(midnight)) {
			long hoursBetweenBedandEnd = ChronoUnit.HOURS.between(bed,end);
			long totalBetweenBedandEnd = (hoursBetweenBedandEnd * rate3);
			return totalBetweenBedandEnd;
		}
		else return 0;
	}
	
	public long getHoursBetweenMidnightandEndTime(LocalDateTime bed, LocalDateTime midnight, LocalDateTime end) {
		if (end.isAfter(midnight)) {
			long hoursBetweenMidnightandEnd = ChronoUnit.HOURS.between(midnight, end);
			long totalBetweenMidnightandEnd = (hoursBetweenMidnightandEnd * rate3);
			return totalBetweenMidnightandEnd;
		}
		else if (end.isBefore(midnight)) {
			long hoursBetweenBedandEnd = ChronoUnit.HOURS.between(bed, end);
			long totalBetweenBedandEnd = (hoursBetweenBedandEnd * rate2);
			return totalBetweenBedandEnd;
		}
		else return 0;
	}

	public long calculateTotal(long totalBetweenStartandBed, long totalBetweenBedandMidnight, long totalBetweenMidnightandEnd) {
		long totalOwed = totalBetweenStartandBed + totalBetweenBedandMidnight + totalBetweenMidnightandEnd;
		return totalOwed;
	}
}