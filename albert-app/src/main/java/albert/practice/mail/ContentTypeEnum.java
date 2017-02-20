package albert.practice.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ContentTypeEnum {

    TIFF("image/tiff"), GIF("image/gif"), JPG("image/jpeg"), PNG("image/png");
    
    @Getter
    private String contentType;

}
