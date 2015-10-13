package ph.txtdis.fx.button;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import ph.txtdis.exception.FailedBackupException;
import ph.txtdis.fx.dialog.ErrorDialog;
import ph.txtdis.fx.dialog.InfoDialog;
import ph.txtdis.service.BackupService;

@Component
public class BackupButton extends FontButton {

    @Autowired
    private BackupService backup;

    @Autowired
    private ErrorDialog error;

    @Autowired
    private InfoDialog info;

    public BackupButton() {
        super("\ue821", "Backup", 44);
    }

    public BackupButton stage(Stage stage) {
        setOnAction(event -> setBackupOnChosenFolder(stage));
        return this;
    }

    private void setBackupOnChosenFolder(Stage stage) {
        try {
            File folder = chooseFolder(stage);
            if (folder != null)
                writeBackup(stage, folder);
        } catch (IOException | FailedBackupException e) {
            e.printStackTrace();
            error.message("Backup unsuccessful;"
                    + "\ncheck server, network and backup storage;\nthen retry.")
                    .stage(stage).showAndWait();
        }
    }

    private void writeBackup(Stage stage, File folder) throws IOException,
            FailedBackupException {
        String path = backup.writeBackup(folder);
        info.message("Backup saved as\n" + path).stage(stage).showAndWait();
    }

    private File chooseFolder(Stage stage) {
        return new DirectoryChooser().showDialog(stage);
    }
}
