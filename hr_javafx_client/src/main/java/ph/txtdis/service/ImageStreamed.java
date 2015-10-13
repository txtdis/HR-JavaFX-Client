package ph.txtdis.service;

import java.io.InputStream;

public interface ImageStreamed {
    
    InputStream getImage();

    void setImage(InputStream imageStream);
}
