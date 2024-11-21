import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(int accountNumber, String accountHolder, double balance) {
        BankAccount account = new BankAccount(accountNumber, accountHolder, balance);
        accounts.add(account);
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found");
    }

    public void deposit(int accountNumber, double amount) throws AccountNotFoundException, InvalidAmountException {
        BankAccount account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) throws AccountNotFoundException, InsufficientFundsException, InvalidAmountException {
        BankAccount account = findAccount(accountNumber);
        account.withdraw(amount);
    }
}
