import static org.junit.Assert.*;

import java.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import main.Rates;


public class AllTests {	
	@Test
	public void testArrivalTimeisNotBeforeFive() {
		Rates startTime = new Rates();		
		assertEquals("Acceptable start time.",startTime.testArrival(LocalTime.of(17, 00)));
	}
	
	@Test
	public void testEndTimeisBeforeFourAM() {
		Rates endTime = new Rates();
		assertEquals("Acceptable end time.",endTime.testDeparture(LocalTime.of(02,00)));
	}
	
	@Test
	public void test12RateBetweenStartandBed() {
		Rates betweenStartandBed = new Rates();
		assertEquals(36,betweenStartandBed.getHoursBetweenArrivalandBedtime());
	}
	
	@Test
	public void test8RateBetweenBedandMidnight() {
		Rates betweenBedandMidnight = new Rates();
		assertEquals(32,betweenBedandMidnight.getHoursBetweenBedandMidnight());
	}
	
	@Test
	public void test16RateBetweenMidnightandEndTime() {
		Rates betweenMidnightandEndTime = new Rates();
		assertEquals(64,betweenMidnightandEndTime.getHoursBetweenMidnightandEndTime());
	}
	
	@Test
	public void totalOwedtoBabysitter() {
		Rates totalOwed = new Rates();
		assertEquals(132,totalOwed.calculateTotal(36, 32,
				64));
	}
}
