public class main {
    public static void main(String[] args) {
        Customer Bob = new Customer("Bob");
        Bob.deposit(100.00, "Saving");
        Bob.deposit(200.00, "Saving");
        System.out.println(Bob.getSavingBalance());
        Bob.displayDeposits();
        Bob.withdraw(100.00, "Checking");
        Bob.withdraw(100.00, "Checking");
        Bob.displayWithdraws();
    }
}
