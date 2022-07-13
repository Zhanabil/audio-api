package src.audioapi.conn;

import src.audioapi.model.DAO.AudioDAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataFunctionInteraction {

    public static ConnectionDB conn;
    protected String url = "jdbc:mysql://127.0.0.1:3306";
    protected String user = "root";
    protected String password = "root";
    public List<AudioDAO> insertDataToSQL() throws SQLException {

        String sql = "SELECT audio_file_name FROM audio_files";
        List<AudioDAO> audioDataList = new ArrayList<>();
        conn = new ConnectionDB();

        String audio_id = "";
        String audio_file_name = "";

        if(conn.connection == null) {
            conn.connection = DriverManager.getConnection(url, user, password);
        }

        conn.preparedStatement = conn.connection.prepareStatement(sql);
        conn.resultSet = conn.preparedStatement.executeQuery();

        while(conn.resultSet.next()) {
            audio_id = conn.resultSet.getString("audio_id");
            audio_file_name = conn.resultSet.getString("audio_file_name");

            AudioDAO audioDAO = new AudioDAO(audio_id, audio_file_name);

            audioDataList.add(audioDAO);
        }

        return audioDataList;

    }
}
