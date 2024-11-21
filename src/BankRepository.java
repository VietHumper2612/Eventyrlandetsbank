import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankRepository {

    // (CREATE i CRUD).
    public void createAccount(BankAccount BankAccount) {

        String sql = "INSERT INTO bank (accountNumber, accountName, balance) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, BankAccount.getAccountNumber());
            preparedStatement.setString(2, BankAccount.getAccountName());
            preparedStatement.setDouble(3, BankAccount.getBalance());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("New account created!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // (READ i CRUD).
    public List<BankAccount> readAccounts() {
        List<BankAccount> accounts = new ArrayList<>();
        String sql = "SELECT * FROM bank";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int accountNumber = resultSet.getInt("accountNumber");
                String accountName = resultSet.getString("accountName");
                double balance = resultSet.getDouble("balance");

                accounts.add(new BankAccount(accountNumber, accountName, balance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // UPDATE i CRUD).
    public void updateAccount(BankAccount bankAccount) {
        String sql = "UPDATE bank SET accountName = ?, balance = ? WHERE accountNumber = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bankAccount.getAccountName());
            preparedStatement.setDouble(2, bankAccount.getBalance());
            preparedStatement.setInt(3, bankAccount.getAccountNumber());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Account has been updated!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // (DELETE i CRUD).
    public void deleteAccounts(int accountNumber) {
        String sql = "DELETE FROM bank WHERE accountNumber = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, accountNumber);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Account has been deleted!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
