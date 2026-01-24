package repository;

import model.Author;
import model.Book;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    // ===== CREATE =====
    public void create(Book book) {
        String sql =
                "INSERT INTO books(name, author, available) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());              // -> name
            ps.setString(2, book.getAuthor().getName());  // -> author
            ps.setBoolean(3, !book.isBorrowed());         // -> available

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Insert failed", e);
        }
    }

    // ===== READ =====
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String authorName = rs.getString("author");
                boolean available = rs.getBoolean("available");

                Author author = new Author(0, authorName);
                Book book = new Book(id, name, author);

                // available=false → borrowed=true
                if (!available) {
                    book.borrow();
                }

                books.add(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Fetch failed", e);
        }

        return books;
    }

    // ===== DELETE =====
    public void delete(int id) {
        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Delete failed", e);
        }
    }
}