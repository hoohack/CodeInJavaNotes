package chapter16;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Objects;

public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setSqlVal(PreparedStatement statement, int index, Object arg) throws SQLException {
        if (arg instanceof Integer) {
            statement.setInt(index, (Integer) arg);
        } else if (arg instanceof String) {
            statement.setString(index, (String)arg);
        } else if (arg instanceof Boolean) {
            statement.setBoolean(index, (Boolean)arg);
        } else if (arg instanceof Byte) {
            statement.setByte(index, (Byte)arg);
        } else if (arg instanceof Short) {
            statement.setShort(index, (Short)arg);
        } else if (arg instanceof Long) {
            statement.setLong(index, (Long)arg);
        } else if (arg instanceof Float) {
            statement.setFloat(index, (Float)arg);
        } else if (arg instanceof Double) {
            statement.setDouble(index, (Double)arg);
        } else if (arg instanceof BigDecimal) {
            statement.setBigDecimal(index, (BigDecimal)arg);
        } else if (arg instanceof Time) {
            statement.setTime(index, (Time)arg);
        } else if (arg instanceof Timestamp) {
            statement.setTimestamp(index, (Timestamp)arg);
        } else if (arg instanceof Date) {
            statement.setDate(index, (Date)arg);
        } else if (arg instanceof byte[]){
            statement.setBytes(index, (byte[]) arg);
        } else {
            System.out.print("Wrong type...");
        }
    }

    public void update(String sql, Object... args) throws SQLException {
        if (Objects.isNull(args)) {
            return;
        }

        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);

        int argCount = args.length;
        for (int i = 0;i < argCount; i++) {
            setSqlVal(statement, i + 1, args[i]);
        }

        statement.executeUpdate();
    }

    // other method
    // TODO
}
