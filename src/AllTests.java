import static org.junit.Assert.*;

import java.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import main.Rates;


public class AllTests {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testArrivalTimeisNotBeforeFive() {
		Rates startTime = new Rates();
		LocalTime actualStart = LocalTime.of(17,30);
		LocalTime fivepm = LocalTime.of(17,00);
		equals(actualStart.isAfter(fivepm));
	}
	
	@Test
	public void testEndTimeisBeforeFourAM() {
		LocalTime actualEnd = LocalTime.of(03, 30);
		LocalTime fouram = LocalTime.of(04, 00);
		equals(actualEnd.isBefore(fouram));
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
}
