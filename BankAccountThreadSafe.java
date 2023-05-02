public class BankAccountThreadSafe {
    private double balance;
    private String accountNumber;

    public BankAccountThreadSafe(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    //synchronized whole method
    public synchronized void deposit(double amount) {
        balance += amount;
    }

    //synchronized only block code
    public  void withdraw(double amount) {
        synchronized (this){
            balance -= amount;
        }
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account number = " + accountNumber);
    }
}
