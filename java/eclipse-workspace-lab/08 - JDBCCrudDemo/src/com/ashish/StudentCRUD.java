package com.ashish;
import java.sql.*;

public class StudentCRUD {
	private static final String URL = "jdbc:mysql://localhost:3306/CRUD";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ashish420";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            createTable(conn);
            insertStudent(conn, 1, "Ashish", 20, "Computer Science");
            insertStudent(conn, 2, "Shailendra", 21, "Mathematics");
            updateDepartment(conn, 1, "Physics");
            deleteStudent(conn, 2);
            retrieveAndDisplayAllStudents(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable(Connection conn) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Students (" +
                "StudentID INT PRIMARY KEY, " +
                "Name VARCHAR(50), " +
                "Age INT, " +
                "Department VARCHAR(50))";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table Students created or already exists.");
        }
    }

    private static void insertStudent(Connection conn, int id, String name, int age, String department) throws SQLException {
        String insertSQL = "INSERT INTO Students (StudentID, Name, Age, Department) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, department);
            pstmt.executeUpdate();
            System.out.println("Inserted student: " + name);
        }
    }

    private static void updateDepartment(Connection conn, int id, String newDepartment) throws SQLException {
        String updateSQL = "UPDATE Students SET Department = ? WHERE StudentID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, newDepartment);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Updated department for StudentID " + id + ": " + (rowsAffected > 0 ? "Success" : "Failed"));
        }
    }

    private static void deleteStudent(Connection conn, int id) throws SQLException {
        String deleteSQL = "DELETE FROM Students WHERE StudentID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Deleted student with StudentID " + id + ": " + (rowsAffected > 0 ? "Success" : "Failed"));
        }
    }

    private static void retrieveAndDisplayAllStudents(Connection conn) throws SQLException {
        String selectSQL = "SELECT * FROM Students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            System.out.println("Students Table:");
            while (rs.next()) {
                int studentID = rs.getInt("StudentID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String department = rs.getString("Department");
                System.out.println("ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Department: " + department);
            }
        }
    }
}