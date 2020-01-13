package jdbc.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class JDBCExecutor {

    public static void main(String[] args) {
        DataBaseConnectionManager dataBaseConnectionManager =
                new DataBaseConnectionManager("localhost", "hplussport",
                        "postgres", "password");
        try (Connection connection = dataBaseConnectionManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select count(*) from customer")) {
            while (resultSet.next()) {
                log.println(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            log.println(e.getMessage());
        }
    }
}
