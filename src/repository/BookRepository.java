package repository;

import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookRepository {

    // CREATE (Insert Book)
    public void create(String title, int pages, int authorId) {

        String sql =
                "INSERT INTO books(title, pages, author_id) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setInt(2, pages);
            ps.setInt(3, authorId);

            ps.executeUpdate();
            System.out.println("Book added successfully.");

        } catch (Exception e) {
            System.out.println("Book already exists.");
        }
    }

    // READ (Select All Books)
    public void findAll() {

        String sql = """
                    SELECT b.id, b.title, a.name
                    FROM books b
                    JOIN authors a ON b.author_id = a.id
                    ORDER BY b.id
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("ID | Title | Author");
            System.out.println("---------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE (By ID)
    public void delete(int id) {

        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Book deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}