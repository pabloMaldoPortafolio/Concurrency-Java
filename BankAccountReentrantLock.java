import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountReentrantLock {

    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccountReentrantLock(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
       lock.lock();
       try{
           balance += amount;
       } finally {
            lock.unlock();
       }
    }

    public  void withdraw(double amount) {
        lock.lock();
        try{
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account number = " + accountNumber);
    }

}
