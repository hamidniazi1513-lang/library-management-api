package repository;

import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorRepository {
    public void create(int id, String name) {
        String sql = "INSERT INTO authors(id, name) VALUES (?, ?) ON CONFLICT (id) DO NOTHING";
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
