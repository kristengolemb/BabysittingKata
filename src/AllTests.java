import static org.junit.Assert.*;

import java.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import main.StartTime;
import main.EndTime;


public class AllTests {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testArrivalTimeisNotBeforeFive() {
		StartTime st = new StartTime();
		assertEquals("Start time accepted",st.getStartTime(LocalTime.of(17, 00)));
	}
	
	@Test
	public void testEndTimeisBeforeFourAM() {
		EndTime et = new EndTime();
		assertEquals("End time accepted",et.getEndTime(LocalTime.of(04, 00)));
	}
	
	@Test
	public void test8RateBetweenBedandMidnight() {
		Rates betweenBedandMidnight = new Rates();
		assertEquals(32,betweenBedandMidnight.getHoursBetweenBedandMidnight());
	}
	
	@Test
	public void test16RateBetweenMidnightandEndTime() {
		Rates betweenMidnightandEndTime = new Rates();
		assertEquals(64,betweenMidnightandEndTime.getHoursBetweenMidnightandEndTime(4));
	}
	
	@Test
	public void testTotalOwed() {
		Rates newRate = new Rates();
		assertEquals(132,newRate.totalOwed(36, 32, 64));
	}
}
