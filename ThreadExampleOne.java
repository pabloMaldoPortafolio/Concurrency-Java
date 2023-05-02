public class ThreadExampleOne {
    public static void main(String[] args){

        BankAccount account = new BankAccount("123-456", 1000.00);

        Thread thread1 = new Thread(){
            public void run(){
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        };

        Thread thread2 = new Thread(){
            public void run(){
                account.deposit(200.00);
                account.withdraw(100.00);
            }
        };
        thread1.start();
        thread2.start();
    }
}
