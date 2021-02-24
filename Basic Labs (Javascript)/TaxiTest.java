import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;

public class TaxiTest {


    //calculateFare() test #1
    @Test(timeout=100)
    public void testPickUpSuccess() {
        Taxi t = new Taxi(12.00, 5);
        assertTrue(t.pickUp(5));
    }
    
    //calculateFare() test #2
    @Test(timeout=100)
    public void testCalculateFare() {
        Taxi t = new Taxi(10.00, 4);
        assertEquals(t.calculateFare(4, 5), 50.00, .1);
    }

    // pickUp() test #1
    @Test(timeout=100)
    public void testPickUpEnoughRoom() {
    	 Taxi t = new Taxi(10.00, 4);
    	 assertTrue(t.pickUp(3));
    }
    
    @Test(timeout=100)
    public void testPickUpEnoughRoom2() {
    	 Taxi t = new Taxi(10.00, 4);
    	 assertFalse(t.pickUp(5));
    }
}
