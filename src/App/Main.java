package App;

import Commandline.DictionaryManagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("view.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Mini dictionary");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}