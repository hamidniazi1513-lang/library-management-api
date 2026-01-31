package repository;

import model.Book;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookRepository {
    public void save(Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author_name, is_borrowed) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getName());
            // We use author name for now, or an ID if your DB uses foreign keys
            pstmt.setString(2, "Unknown");
            pstmt.setBoolean(3, false);
            pstmt.executeUpdate();
        }
    }
}