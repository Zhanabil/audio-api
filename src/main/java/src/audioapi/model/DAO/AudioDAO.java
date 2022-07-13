package src.audioapi.model.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AudioDAO  {

    private String audio_id = null;
    private String audio_file_name = null;

}
