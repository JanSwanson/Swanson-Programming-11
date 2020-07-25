import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, String account){
        this.amount = amount;
        this.date = new Date();
        this.account = account;
    }

    //Effects: when Withdraw printed out, the correctly formatted information is printed instead
    public String toString(){
        return "Withdrawal of: $" + amount + " Date: " + date + " From account: " + account;
    }
}
