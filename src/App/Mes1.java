package App;

import Commandline.DictionaryManagement;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Mes1 {
    @FXML
    private Button messB;
    @FXML
    private Label label;
    @FXML
    private void clickButton(javafx.event.ActionEvent event){
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
