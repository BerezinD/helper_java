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
            Customer customer = new Customer();
            customer.setFirstName("John");
            customer.setLastName("Adams");
            customer.setEmail("jadams.wh.gov");
            customer.setAddress("1234 Main St");
            customer.setCity("Arlington");
            customer.setState("VA");
            customer.setPhone("(555) 555-9845");
            customer.setZipCode("01234");

            Customer customerFromDB = customerDAO.create(customer);
            log.println(customerFromDB.toString());
            customerFromDB = customerDAO.findById(customerFromDB.getId());
            log.println(customerFromDB.toString());
            customerFromDB.setEmail("j@j.com");
            customerDAO.update(customerFromDB);
            log.println(customerFromDB.toString());
            customerDAO.delete(customerFromDB.getId());
            log.println(customerDAO.findById(customerFromDB.getId()));
        } catch (SQLException e) {
            log.println(e.getMessage());
        }
    }
}
