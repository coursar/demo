package tech.itpark;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (var conn = DriverManager.getConnection("jdbc:postgresql://localhost:5400/db?user=app&password=db")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT 1");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
