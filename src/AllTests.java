import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import main.StartTime;

public class AllTests {

	@Before
	public void setUp() throws Exception {
	}

StartTime st = new StartTime();	
	@Test
	public void testArrivalTime() {	  
		assertEquals(st,StartTime.getStartTime());
	}

}
