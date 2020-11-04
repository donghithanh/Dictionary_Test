package App;

import Commandline.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class Controller implements Initializable{
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            DictionaryManagement.insertFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadData("",true);
    }
    @FXML
    private TextField textField1;
    @FXML
    private Button searchBt1;
    Boolean TF = true;
    @FXML
    private void doSearch(javafx.event.ActionEvent event) throws IOException {
        String word = textField1.getText();
        if(checkEV.isSelected()){
            TF = true;
        }else{
            TF = false;
        }
        Connection ic = new Connection();
        ArrayList<Word> words = ic.getData(word,TF);
        loadData(word,TF);
        if(!words.isEmpty()){
            textArea1.setText(words.get(0).getWord_explain());
        }else{
            textArea1.setText("không tìm thấy");
        }
    }

    @FXML
    private TextArea textArea1;


    @FXML
    private ListView<String> listView1;
    ObservableList list = FXCollections.observableArrayList();

    public void loadData(String word, Boolean TF) {
        list.removeAll(list);
        listView1.getItems().removeAll(listView1.getItems());
        if (word.equals("") || word.isEmpty()) {
            if (TF) {
                for (int i = 0; i < DictionaryEV.dictionaries.size(); i++) {
                    System.out.println(DictionaryEV.dictionaries.get(i).getWord_target());
                    list.add(DictionaryEV.dictionaries.get(i).getWord_target());
                }
            } else {
                for (int i = 0; i < DictionaryVE.dictionaries.size(); i++) {
                    list.add(DictionaryVE.dictionaries.get(i).getWord_target());
                }
            }
        }else{
            ArrayList<Word> words = DictionaryCommandline.dictionarySearcher(word, TF);
            for (int i = 0; i < words.size(); i++) {
                if(words.get(i).getWord_target().isEmpty()) break;
                list.add(words.get(i).getWord_target());
            }
        }
        listView1.getItems().addAll(list);
    }

    public static String present = "no thing select!!";
    @FXML
    private void display_selected(MouseEvent event){
        String listView1_select = listView1.getSelectionModel().getSelectedItem();
        if(listView1_select != null && !listView1_select.isEmpty()){
            Word word = DictionaryCommandline.dictionarySearcher(listView1_select,TF).get(0);
            textArea1.setText(word.getWord_target()+ "\n" + word.getWord_explain());
            present = word.getWord_target();
        }else{
            present = "no thing select!!";
        }
    }


    @FXML
    private CheckBox checkVE;
    @FXML
    private CheckBox checkEV;
    @FXML
    private void checkEVBox(){
        if(checkEV.isSelected()){
            checkVE.setSelected(false);
            return;
        }
        if(!checkEV.isSelected() && !checkVE.isSelected()){
            checkEV.setSelected(true);
        }
    }

    @FXML
    private void checkVEBox(){
        if(checkVE.isSelected()){
            checkEV.setSelected(false);
            return;
        }
        if(!checkEV.isSelected() && !checkVE.isSelected()){
            checkVE.setSelected(true);
        }
    }

    @FXML
    private Button delete;
    @FXML
    private void deleteWord(javafx.event.ActionEvent event) throws IOException {
        if(!present.equals("no thing select!!") && TF == true){
            for(int j = 0; j < DictionaryEV.dictionaries.size(); j++){
                if(DictionaryEV.dictionaries.get(j).getWord_target().equals(present)){
                    DictionaryEV.dictionaries.remove(j);
                }
            }
            Reader reader = new FileReader("src\\data\\dictionaries.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String read = bufferedReader.readLine();
            ArrayList<Word> words = new ArrayList<Word>();
            while(read != null) {
                String[] values = read.split(" {4}");
                if(!values[0].equals(present)){
                    Word word = new Word(values[0],values[1]);
                    System.out.println(values[0] + values[1]);
                    words.add(word);
                }
                read = bufferedReader.readLine();
            }
            bufferedReader.close();
            reader.close();
            Writer writer = new FileWriter("src\\data\\dictionaries.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for(int i = 0; i < words.size(); i++){
                bufferedWriter.write(words.get(i).getWord_target() + "    " +
                        words.get(i).getWord_explain()+ "\n") ;
            }
            bufferedWriter.close();
            writer.close();
            loadData("",TF);
        }else{
            textArea1.setText("bạn không có quyền xóa từ trong main file");
        }
    }


    @FXML
    private Button add;
    @FXML
    private void addWord(javafx.event.ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("add word");
            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            System.out.println("can't load new window");
        }
    }

    @FXML
    private Button setWord;
    @FXML
    private void setWord1(javafx.event.ActionEvent event){
        try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("setting.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setTitle("delete word");
            stage1.setScene(new Scene(root1));
            stage1.show();
        }catch (Exception e){
            System.out.println("can't load new window");
        }
    }
}