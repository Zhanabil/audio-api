package src.audioapi.conn;

import src.audioapi.model.DAO.AudioDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class DataFunctionInteraction {
    public static ConnectionDB conn;
    protected String url = "jdbc:mysql://127.0.0.1:3306/audio_db";
    protected String user = "root";
    protected String password = "root";
    public void insertDataToSQL(String audioIdToData, String audioFileNameToData) throws SQLException {

        int resultSet;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            String sql = "INSERT INTO audio_files (audio_id, audio_file_name) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, audioIdToData);
            preparedStatement.setString(2, audioFileNameToData);

            preparedStatement.executeUpdate();

        } catch (SQLException exc) {

            exc.printStackTrace();
        }
    }
}
