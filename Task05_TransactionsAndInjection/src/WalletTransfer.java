import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WalletTransfer {

    public static void transfer(Connection con, int fromId, int toId, double amount)
            throws SQLException {

        String debitSQL = "UPDATE Wallet SET balance = balance - ? WHERE wallet_id = ?";
        String creditSQL = "UPDATE Wallet SET balance = balance + ? WHERE wallet_id = ?";

        try {
            con.setAutoCommit(false);

            try (PreparedStatement debit = con.prepareStatement(debitSQL);
                 PreparedStatement credit = con.prepareStatement(creditSQL)) {

                debit.setDouble(1, amount);
                debit.setInt(2, fromId);

                int debitRows = debit.executeUpdate();

                if (debitRows != 1) {
                    throw new SQLException("Invalid source wallet");
                }

                credit.setDouble(1, amount);
                credit.setInt(2, toId);

                int creditRows = credit.executeUpdate();

                if (creditRows != 1) {
                    throw new SQLException("Invalid destination wallet");
                }

                con.commit();
                System.out.println("Transfer completed successfully.");
            }

        } catch (SQLException e) {
            con.rollback();
            System.out.println("Transfer failed. Transaction rolled back.");
            throw e;

        } finally {
            con.setAutoCommit(true);
        }
    }
}