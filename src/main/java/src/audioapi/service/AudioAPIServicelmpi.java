package src.audioapi.service;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import src.audioapi.model.AudioModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/*
*  Основной класс, выполняющий все функции от интерфейса AudioAPIService
*
* */

@Service
public class AudioAPIServicelmpi implements AudioAPIService {
    private HashMap<String, String> audioMap = new HashMap<>();
    @Override
    public void addAudioToList(String audioId, MultipartFile audioFile) {
        /*AudioModel audioModel = new AudioModel();
        audioModel.setAudioId(UUID.randomUUID().toString());*/

        audioMap.put(audioId, audioFile.getOriginalFilename());
    }
    @Override
    public List<String> getAllAudioFile() {

        // Создает новый лист со значениями, которые находятся в Map.
        // Думаю, это необходимо для того, чтобы не засорять имеющуюся память. Ведь по сути мы нигде больше не используем список с названиями песен
        // кроме вывода на экран.
        return new ArrayList<>(audioMap.values());
    }
    @Override
    public String getAudioById(String audioId) {
        return audioMap.get(audioId);
    }
    @Override
    public void deleteAudioById(String audioId) {
        audioMap.remove(audioId);
    }
}
