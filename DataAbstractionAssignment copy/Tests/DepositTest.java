import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DepositTest {
    Deposit test1;
    Deposit test2;
    Date date;

    @Before
    public void setup (){
        date = new Date();
        test1 = new Deposit(400, "Saving");
        test2 = new Deposit(400, "Checking");
    }
    @Test
    public void testToString(){
        assertEquals("Deposit of: $400.0 Date: " + date + " Into account: Saving", test1.toString());
        assertEquals("Deposit of: $400.0 Date: " + date + " Into account: Checking", test2.toString());
    }
}
