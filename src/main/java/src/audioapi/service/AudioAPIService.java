package src.audioapi.service;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import src.audioapi.model.AudioModel;

import java.util.List;

public interface AudioAPIService {

    void addAudioToList(String audioId, MultipartFile audioFile);
    List<String> getAllAudioFile();
    String getAudioById(String audioId);
    void deleteAudioById(String audioId);
}
