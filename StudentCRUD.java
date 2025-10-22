package sectionb;

import java.sql.*;

/**
 * StudentCRUD
 * -------------
 * Demonstrates basic CRUD operations using JDBC and PreparedStatement.
 *
 * NOTE: Update the DB URL, user and password constants before running.
 */
public class StudentCRUD {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database.");

            insertStudent(conn, 1, "Alice", 85);
            insertStudent(conn, 2, "Bob", 91);

            System.out.println("\nAll Students:");
            readStudents(conn);

            updateMarks(conn, "Bob", 95);
            deleteStudent(conn, "Alice");

            System.out.println("\nFinal Records:");
            readStudents(conn);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    public static void insertStudent(Connection conn, int id, String name, int marks) {
        String sql = "INSERT INTO student (id, name, marks) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, marks);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Student " + name + " inserted successfully");
        } catch (SQLException e) {
            System.err.println("Error inserting student: " + e.getMessage());
        }
    }

    public static void readStudents(Connection conn) {
        String sql = "SELECT * FROM student";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getInt("marks"));
            }
        } catch (SQLException e) {
            System.err.println("Error reading students: " + e.getMessage());
        }
    }

    public static void updateMarks(Connection conn, String name, int newMarks) {
        String sql = "UPDATE student SET marks = ? WHERE name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newMarks);
            pstmt.setString(2, name);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Record updated successfully for " + name);
        } catch (SQLException e) {
            System.err.println("Error updating marks: " + e.getMessage());
        }
    }

    public static void deleteStudent(Connection conn, String name) {
        String sql = "DELETE FROM student WHERE name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Record deleted successfully for " + name);
        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }
}
