import java.util.ArrayList;

public class Customer {
    private static int accountSpecifier = 11111111;
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<Deposit>(0);
    private ArrayList<Withdraw> withdraws = new ArrayList<Withdraw>(0);
    private double checkBalance;
    private double savingBalance;
    private String name;
    public final String CHECKING = "Checking";
    public final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        name = "";
        accountNumber = accountSpecifier;
        accountSpecifier++;
    }
    Customer(String name){
        this.name = name;
        this.accountNumber = accountSpecifier;
        accountSpecifier++;
    }

    //Requires: double amt >=0, account name
    //Modifies: this, deposits
    //Effects: adds amt to appropriate balance, adds new deposit to deposits, if invalid account name then prints out warning
    public void deposit(double amt, String account){
        if(account.equals(CHECKING)){
            checkBalance += amt;
            deposits.add(new Deposit(amt,account));
        }
        else if(account.equals(SAVING)){
            savingBalance += amt;
            deposits.add(new Deposit(amt,account));
        }
        else{
            System.out.println("No such account exists");
        }
    }

    //Requires: double amt >=0, account name
    //Modifies: this, withdraws
    /* Effects: if appropriate balance - amt >= overdraft then removes amt from appropriate balance, else prints
    out warning, adds new withdraw to withdraws, if invalid account name then prints out warning
     */
    public void withdraw(double amt, String account){
        if(account.equals(CHECKING) && (checkOverdraft(amt, account)==false)) {
            checkBalance -= amt;
            withdraws.add(new Withdraw(amt, account));
        }
        else if (checkOverdraft(amt, account) == true){
            System.out.println("You are over your account limit");
        }
        else if(account.equals(SAVING) && (checkOverdraft(amt,account)==false)){
            savingBalance -= amt;
            withdraws.add(new Withdraw(amt,account));
        }
        else if(checkOverdraft(amt, account)==true){
            System.out.println("You are over your account limit");
        }
        else{
            System.out.println("No such account exists");
        }
    }
    //Requires: double amt >=0, valid account name
    /*Effects: if appropriate account balance - amt < overdraft limit return true, if appropriate account balance -
    amt >= overdraft limit return false */
     private boolean checkOverdraft(double amt, String account){
        if(account.equals(CHECKING) && checkBalance-amt<OVERDRAFT){
            return true;
        }
        else if(account.equals(CHECKING) && checkBalance-amt >= OVERDRAFT){
            return false;
        }
        else if(account.equals(SAVING)&& savingBalance-amt<OVERDRAFT){
            return true;
        }
        else if(account.equals(SAVING)&& savingBalance-amt >= OVERDRAFT){
            return false;
        }
        else{
            return false;
        }
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }
}
