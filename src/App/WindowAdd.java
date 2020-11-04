package App;

import Commandline.DictionaryCommandline;
import Commandline.DictionaryEV;
import Commandline.DictionaryManagement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;


public class WindowAdd {
    @FXML
    private TextArea wordAdd;
    @FXML
    private TextArea transAdd;
    @FXML
    private Button addButton;
    @FXML
    private void doAdd(javafx.event.ActionEvent event){
        String word = wordAdd.getText();
        String trans = transAdd.getText();
        if(!word.equals("")&&!trans.equals("")){
            if(DictionaryCommandline.dictionarySearcher(word,true).isEmpty()){
                DictionaryEV.addDictionary(word,trans);
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mes.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("messenger");
                    stage.setScene(new Scene(root));
                    stage.show();
                }catch (Exception e){
                    System.out.println("can't load new window");
                }
            }else{
                try{
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mes1.fxml"));
                    Parent root = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("messenger");
                    stage.setScene(new Scene(root));
                    stage.show();
                }catch (Exception e){
                    System.out.println("can't load new window");
                }
            }
        }else{
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mes1.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("messenger");
                stage.setScene(new Scene(root));
                stage.show();
            }catch (Exception e){
                System.out.println("can't load new window");
            }
        }
    }
}
