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

}
