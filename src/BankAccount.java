public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount: " +
                "Account Number = " + accountNumber +
                ", Account Name = " + accountName +
                ", balance = " + balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount");
        } else {
            balance += amount;
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds");
        } else if (amount <= 0) {
            throw new InvalidAmountException("Invalid amount");
        } else {
            balance -= amount;
        }
    }

    public void getAccountInfo() throws AccountNotFoundException {
        if (accountNumber == -1 || accountName == null) {
            throw new AccountNotFoundException("Account not found");
        } else {
            System.out.println("Account Information");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Name: " + accountName);
            System.out.println("Balance: " + balance);
        }
    }
}
