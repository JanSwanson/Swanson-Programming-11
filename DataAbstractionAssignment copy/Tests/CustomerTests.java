import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class CustomerTests {
    Customer test;

    @Before
    public void setup(){
        test = new Customer();
    }

    @Test
    public void testDepositCheck(){
        assertEquals(0.0, test.getCheckBalance());
        test.deposit(100.00, "Checking");
        assertEquals(100.00, test.getCheckBalance());
        test.deposit(200.00, "Checking");
        //Scenario: noSuchAccount
        test.deposit(100.00, "notChecking");
        assertEquals(300.00, test.getCheckBalance());
    }

    @Test
    public void testDepositSaving(){
        assertEquals(0.0, test.getSavingBalance());
        test.deposit(200.00, "Saving");
        assertEquals(200.00, test.getSavingBalance());
        test.deposit(100.00, "Saving");
        //Scenario: noSuchAccount
        test.deposit(100.00, "notSaving");
        assertEquals(300.00,test.getSavingBalance());
    }

    @Test
    public void testWithdrawCheck(){
        test.deposit(200.00, "Checking");
        assertEquals(200.00, test.getCheckBalance());
        test.withdraw(299.00, "Checking");
        //Scenario: noSuchAccount
        test.withdraw(100.00, "notChecking");
        assertEquals(-99.00, test.getCheckBalance());
        //Scenario: isOverdraft
        test.withdraw(300.00, "Checking");
        //Scenario: isOverdraft && noSuchAccount
        test.withdraw(300.00, "notChecking");
        assertEquals(-99.00, test.getCheckBalance());
    }

    @Test
    public void testWithdrawSaving(){
        test.deposit(200.00, "Saving");
        assertEquals(200.00, test.getSavingBalance());
        test.withdraw(299.00, "Saving");
        //Scenario: noSuchAccount
        test.withdraw(100.00, "notSaving");
        assertEquals(-99.00, test.getSavingBalance());
        //Scenario: isOverdraft
        test.withdraw(300.00, "Saving");
        //Scenario: isOverdraft && noSuchAccount
        test.withdraw(300.00, "notSaving");
        assertEquals(-99.00, test.getSavingBalance());
    }
}
