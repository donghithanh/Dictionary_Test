package App;

import Commandline.DictionaryCommandline;
import Commandline.DictionaryEV;
import Commandline.DictionaryManagement;
import Commandline.Word;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;



public class Setting {
    @FXML
    private TextArea wordSet;
    @FXML
    private TextArea transSet;
    @FXML
    private Button button;

    public void presentText(){
        Word word = DictionaryCommandline.dictionarySearcher(Controller.present,true).get(0);
        wordSet.setText(word.getWord_target());
        transSet.setText(word.getWord_explain());
    }

    @FXML
    private void doSet(javafx.event.ActionEvent event){
        String word = wordSet.getText();
        String trans = transSet.getText();
        if(!word.equals("")&&!trans.equals("")){
            if(!DictionaryCommandline.dictionarySearcher(word,true).isEmpty()){
                DictionaryEV.changeWord(word,trans);
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
