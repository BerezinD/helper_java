package jdbc.example;

import java.sql.Connection;
import java.sql.SQLException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class JDBCExecutor {

    public static void main(String[] args) {
        DataBaseConnectionManager dataBaseConnectionManager =
                new DataBaseConnectionManager("localhost", "hplussport",
                        "postgres", "password");
        try (Connection connection = dataBaseConnectionManager.getConnection()) {
            CustomerDAO customerDAO = new CustomerDAO(connection);
            Customer customer = customerDAO.findById(10000);
            log.println(customer.getFirstName() + " " + customer.getLastName());
            customer.setFirstName("Georgii");
            customerDAO.update(customer);
            log.println(customer.getFirstName() + " " + customer.getLastName());
        } catch (SQLException e) {
            log.println(e.getMessage());
        }
    }
}
