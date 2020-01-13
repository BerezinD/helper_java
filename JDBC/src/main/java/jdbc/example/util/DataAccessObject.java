package jdbc.example.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public abstract class DataAccessObject<T extends DataTransferObject> {
    protected final Connection connection;
    protected static final String LAST_VAL = "SELECT last_value FROM ";
    protected static final String CUSTOMER_SEQUENCE = "hp_customer_seq";

    public DataAccessObject(Connection connection) {
        this.connection = connection;
    }

    public abstract T findById(long id);

    public abstract List<T> findAll();

    public abstract T update(T dto);

    public abstract T create(T dto);

    public abstract void delete(long id);

    protected long getLastVal(String sequence) {
        long key = 0;
        String sql = LAST_VAL + sequence;
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                key = rs.getInt(1);
            }
            return key;
        } catch (SQLException e) {
            log.println(e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }
}
