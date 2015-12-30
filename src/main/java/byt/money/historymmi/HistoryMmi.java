package byt.money.historymmi;

import byt.money.common.bar.IWorkingPanel;
import byt.money.common.service.IStartStop;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class HistoryMmi implements IStartStop, IWorkingPanel {

private static final Logger LOGGER = Logger.getLogger(HistoryMmi.class.getName());

    private Button button;
    private GridPane root;

    public HistoryMmi() {
        start();
    }
    
     @Override
    public void start() {
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/HistoryMmi.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            button = new Button();
            Image image = new Image(getClass().getResourceAsStream("/icons/history.png"));
            button.setGraphic(new ImageView(image));
        } catch (IOException ex) {
            LOGGER.log(Level.INFO, "Exception during activate history-mmi ", ex);
        }
    }

    @Override
    public GridPane getScene() {
        return root;
    }

    @Override
    public String getName() {
        return "History";
    }

    @Override
    public Button getButton() {
        return button;
    }

    @Override
    public void stop() {
    }

    @Override
    public int getOrder() {
        return 1;
    }

}
