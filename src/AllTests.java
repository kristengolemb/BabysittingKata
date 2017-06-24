import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Test;
import main.Rates;


public class AllTests {	
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
	public void testEndTimeisBeforeFourAM() {
		Rates endTime = new Rates();
		assertEquals("Acceptable end time.",endTime.testDeparture(LocalDateTime.of(2017, 06, 02, 02,00)));
	}
	
	@Test
	public void test$12RateBetweenStartandBed() {
		Rates betweenStartandBed = new Rates();
		assertEquals(36,betweenStartandBed.getHoursBetweenArrivalandBedtime());
	}
	
	@Test
	public void test$8RateBetweenBedandMidnight() {
		Rates betweenBedandMidnight = new Rates();
		assertEquals(32,betweenBedandMidnight.getHoursBetweenBedandMidnight());
	}
	
	@Test
	public void test$16RateBetweenMidnightandEndTime() {
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
