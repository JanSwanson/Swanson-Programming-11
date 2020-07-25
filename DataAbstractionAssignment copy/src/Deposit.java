import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, String account){
        this.amount = amount;
        this.date = new Date();
        this.account = account;
    }
    //Effects: when Deposit printed out, the correctly formatted information is printed instead
    public String toString(){
        return "Deposit of: $" + amount + " Date: " + date + " Into account: " + account;
    }
}
