package oop;

public class BankAccount {

    private int accountNumber;
    private double balance;
    private String name;
    private String email;
    private int phoneNumber;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    private void deposit(double amount) {
        this.setBalance(this.getBalance() + amount);
    }

    private double withdraw(double amount) {

        // instructor version
        if (this.balance - amount < 0) {
            return 0;
        } else {
            this.balance -= amount;
            return amount;
        }

        /*
        what I would have done

        double balance = this.getBalance();
        if (balance - amount >= 0) {
            this.setBalance(balance - amount);
            return amount;
        } else {
            return 0;
        }
         */
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(3.04);
        System.out.println(bankAccount.getBalance());
        System.out.println(bankAccount.withdraw(5.00));
        System.out.println(bankAccount.withdraw(3.04));
        System.out.println(bankAccount.getBalance());
    }
}
