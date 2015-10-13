package ph.txtdis.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import ph.txtdis.dto.Backup;
import ph.txtdis.exception.FailedBackupException;
import ph.txtdis.util.Binary;
import ph.txtdis.util.Temporal;

@Service
public class BackupService extends AbstractReadService<Backup> {

    public byte[] getBackup() throws ResourceAccessException {
        return getOne("").getFile();
    }

    public String writeBackup(File folder) throws IOException,
            FailedBackupException {
        String pathname = folder + "\\\n" + Temporal.toFileName(ZonedDateTime
                .now()) + ".backup";
        String filename = pathname.replace("\n", "");
        Path path = Binary.toPath(filename);
        Files.write(path, getBackup());
        return pathname;
    }
}
