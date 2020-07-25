import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class WithdrawTest {
    Withdraw test1;
    Withdraw test2;
    Date date;

    @Before
    public void setup (){

        date = new Date();
        test1 = new Withdraw(100, "Saving");
        test2 = new Withdraw (100, "Checking");
    }
    @Test
    public void testToString(){
        assertEquals("Withdrawal of: $100.0 Date: " + date + " From account: Saving", test1.toString());
        assertEquals("Withdrawal of: $100.0 Date: " + date + " From account: Checking", test2.toString());
    }
}
