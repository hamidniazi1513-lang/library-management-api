package repository;

import model.Author;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorRepository {
    public void save(Author author) throws SQLException {
        String sql = "INSERT INTO authors (name) VALUES (?) ON CONFLICT DO NOTHING";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, author.getName());
            pstmt.executeUpdate();
        }
    }
}