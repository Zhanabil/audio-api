package src.audioapi.conn;

import java.sql.*;

public class ConnectionDB {

    private String url = "jdbc:mysql://127.0.0.1:3306";
    private String user = "root";
    private String password = "root";
    public Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected int resultSet;
    public ConnectionDB() {

        try {

            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public int getResultSet() {
        return this.resultSet;
    }
}
