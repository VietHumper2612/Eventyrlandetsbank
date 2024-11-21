import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankRepository repository = new BankRepository();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Eventyrlandets Bank ---");
            System.out.println("1. Create account");
            System.out.println("2. Show account");
            System.out.println("3. Update account");
            System.out.println("4. Delete account");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Account Number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Account name: ");
                    String accountName = scanner.nextLine();
                    System.out.print("Balance: ");
                    double balance = scanner.nextDouble();

                    BankAccount BankAccount = new BankAccount(accountNumber, accountName, balance);
                    repository.createAccount(BankAccount);
                }
                case 2 -> {
                    List<BankAccount> accounts = repository.readAccounts();
                    accounts.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Account number: ");
                    int AccountNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("New account name: ");
                    String accountName = scanner.nextLine();
                    System.out.println("New balance: ");
                    double balance = scanner.nextDouble();

                    BankAccount bankAccount = new BankAccount(AccountNumber, accountName, balance);
                    repository.updateAccount(bankAccount);
                }
                case 4 -> {
                    System.out.print("Account number to be deleted: ");
                    int accountNumber = scanner.nextInt();
                    repository.deleteAccounts(accountNumber);
                }
                case 5 -> {
                    System.out.println("Exiting!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice");

            }
        }
    }
}