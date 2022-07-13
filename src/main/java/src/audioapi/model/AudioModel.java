package src.audioapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AudioModel {

    @NotNull
    String audioId;
    @NotNull
    String audioFile;

}
