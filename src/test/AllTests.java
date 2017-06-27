package test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Test;
import main.Rates;


public class AllTests {	
	LocalDateTime midnight = LocalDateTime.of(2017, 06, 02, 00,00);
	@Test
	public void testArrivalTimeisNotBeforeFive() {
		Rates startTime = new Rates();		
		assertEquals("Unacceptable start time.",startTime.testArrival(LocalDateTime.of(2017, 06, 01, 16, 30)));
	}
	
	@Test
	public void testArrivalTimeisRightOnTime() {
		Rates startTime = new Rates();		
		assertEquals("Right on time!",startTime.testArrival(LocalDateTime.of(2017, 06, 01, 17,00)));
	}
	
	@Test
	public void testArrivalTimeisAfterFive() {
		Rates startTime = new Rates();
		assertEquals("Acceptable start time.",startTime.testArrival(LocalDateTime.of(2017, 06, 01, 18,00)));

	}
	
	@Test
	public void testEndTimeisBeforeFourAM() {
		Rates endTime = new Rates();
		assertEquals("Acceptable end time.",endTime.testDeparture(LocalDateTime.of(2017, 06, 02, 02,00)));
	}
	
	@Test
	public void testLeavingRightOnTime() {
		Rates endTime = new Rates();
		assertEquals("Leaving right on time.",endTime.testDeparture(LocalDateTime.of(2017, 06, 02, 04, 00)));
	}
	
	@Test
	public void testLeavingAfterFourAM() {
		Rates endTime = new Rates();
		assertEquals("Unacceptable end time.",endTime.testDeparture(LocalDateTime.of(2017, 06, 02, 04,30)));
	}
	
	//testing partial hour math
	@Test
	public void testRateBetweenStartandBed() {
		Rates betweenStartandBed = new Rates();
		LocalDateTime start = LocalDateTime.of(2017, 06, 01, 18,30);
		LocalDateTime bed = LocalDateTime.of(2017, 06, 01, 20,00);
		assertEquals(12,betweenStartandBed.getTotalBetweenArrivalandBedtime(start, bed, midnight));
	}
	
	@Test
	public void testRateWhenStartisAfterBed() {
		Rates startAfterBed = new Rates();
		LocalDateTime start = LocalDateTime.of(2017, 06, 01, 21,00);
		LocalDateTime bed = LocalDateTime.of(2017, 06, 01, 20,00);
		assertEquals(24,startAfterBed.getTotalBetweenArrivalandBedtime(start, bed, midnight));
	}
	
	//again testing partial hours
	@Test
	public void testRBetweenBedandMidnight() {
		Rates betweenBedandMidnight = new Rates();
		LocalDateTime bed = LocalDateTime.of(2017,  06, 01, 20,45);
		LocalDateTime midnight = LocalDateTime.of(2017, 06, 02, 00,00);
		LocalDateTime end = LocalDateTime.of(2017, 06, 02, 04,00);
		assertEquals(24,betweenBedandMidnight.getTotalBetweenBedandMidnight(bed, midnight, end));
	}
	
	@Test 
	public void testBedtimeAfterMidnight() {
		Rates bedAfterMidnight = new Rates();
		LocalDateTime bed = LocalDateTime.of(2017, 06, 02, 01, 00);
		LocalDateTime midnight = LocalDateTime.of(2017, 06, 02, 00,00);
		LocalDateTime end = LocalDateTime.of(2017, 06, 02, 04,00);
		assertEquals(48,bedAfterMidnight.getTotalBetweenBedandMidnight(bed, midnight, end));
	}
		
	@Test
	public void testHoursBetweenMidnightandEndTime() {
		Rates betweenMidnightandEndTime = new Rates();
		LocalDateTime bed = LocalDateTime.of(2017, 06, 01, 20, 00);
		LocalDateTime midnight = LocalDateTime.of(2017, 06, 02, 00,00);
		LocalDateTime end = LocalDateTime.of(2017, 06, 02, 02,01);
		assertEquals(32,betweenMidnightandEndTime.getTotalBetweenMidnightandEndTime(bed, midnight, end));
	}
	
	@Test
	public void testLeavingBeforeMidnight() {
		Rates leavingBeforeMidnight = new Rates();
		LocalDateTime bed = LocalDateTime.of(2017, 06, 01, 20, 00);
		LocalDateTime midnight = LocalDateTime.of(2017, 06, 02, 00,00);
		LocalDateTime end = LocalDateTime.of(2017, 06, 01, 23,00);
		assertEquals(24,leavingBeforeMidnight.getTotalBetweenMidnightandEndTime(bed, midnight, end));
	}

//start @ 5, bedtime @ 8pm, end @ 4am	
	@Test
	public void totalOwedtoBabysitter() {
		Rates totalOwed = new Rates();
		assertEquals(132,totalOwed.calculateTotal(32, 36,
				64));
	}	
}
