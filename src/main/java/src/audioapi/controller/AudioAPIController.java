package src.audioapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import src.audioapi.conn.DataFunctionInteraction;
import src.audioapi.model.AudioModel;
import src.audioapi.service.AudioAPIService;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/audioapi")
public class AudioAPIController {

    @Autowired
    private AudioAPIService audioAPIService;
    private DataFunctionInteraction dataFunctionInteraction = new DataFunctionInteraction();

    @PostMapping("/add-audio")
    public ResponseEntity<String> addAudioToList(@Valid @RequestBody @RequestParam(value = "audio_id") String audioId,
                                                 @Valid @RequestBody @RequestParam(value = "audio_file") MultipartFile audioFile) {
        audioAPIService.addAudioToList(audioId, audioFile);
        try {
            dataFunctionInteraction.insertDataToSQL();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Audio successfully added", HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public List<String> getAllAudioFile() {
        return audioAPIService.getAllAudioFile();
    }
    
    @GetMapping("/{audioId}")
    public String getAudioById(@Valid @RequestParam String audioId) {
        return audioAPIService.getAudioById(audioId);
    }
    
    @DeleteMapping("/{audioId}")
    public ResponseEntity<String> deleteAudioById(@Valid @RequestParam String audioId) {
        audioAPIService.deleteAudioById(audioId);
        return new ResponseEntity<String>("Audio successfully deleted", HttpStatus.OK);
    }
}
