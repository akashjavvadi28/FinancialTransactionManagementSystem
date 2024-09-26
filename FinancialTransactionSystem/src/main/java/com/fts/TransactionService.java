package com.fts;

import java.sql.*;

public class TransactionService {

    public boolean performTransaction(int userId, double amount, String transactionType) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            String sqlUpdateBalance;
            if ("DEPOSIT".equalsIgnoreCase(transactionType)) {
                sqlUpdateBalance = "UPDATE Users SET balance = balance + ? WHERE user_id = ?";
            } else if ("WITHDRAWAL".equalsIgnoreCase(transactionType)) {
                sqlUpdateBalance = "UPDATE Users SET balance = balance - ? WHERE user_id = ?";
            } else {
                return false;
            }

            PreparedStatement pstmt = conn.prepareStatement(sqlUpdateBalance);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, userId);
            pstmt.executeUpdate();

            String sqlTransaction = "INSERT INTO Transactions (user_id, amount, transaction_type) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sqlTransaction);
            pstmt.setInt(1, userId);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, transactionType);
            pstmt.executeUpdate();

            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

