import java.sql.*;
import java.util.*;

public class StudentDAO {

    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getGrade());
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("grade"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getGrade());
            stmt.setInt(4, student.getId());
            stmt.executeUpdate();
            System.out.println("Student updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Student deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
