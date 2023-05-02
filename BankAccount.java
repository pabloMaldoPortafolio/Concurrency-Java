public class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void printAccountNumer(){
        System.out.println("Account number = " + accountNumber);
    }

}
