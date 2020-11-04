package Commandline;

import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {

    public static void insertFromFile() throws IOException {
        Reader reader = new FileReader("src\\data\\dictionaries.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String read = bufferedReader.readLine();
        while(read != null) {
            String[] values = read.split(" {4}");
            String word_target = values[0];
            String word_explain = values[1];
            DictionaryEV.addDictionary(word_target.toLowerCase(),word_explain.toLowerCase());
            read = bufferedReader.readLine();
        }
        bufferedReader.close();
        reader.close();
    }

    public static void insertFromCommandline(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số lượng từ:");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            addWord();
        }
    }

    public static void dictionaryLookup(){
        System.out.println("nhập từ cần tìm:");
        Scanner sc = new Scanner(System.in);
        String word_target = sc.nextLine();
        word_target.toLowerCase();
        for (int i = 0; i < DictionaryEV.dictionaries.size(); i++) {
            if(DictionaryEV.dictionaries.get(i).getWord_target().equals(word_target)){
                System.out.println((i+1) + "   |" + DictionaryEV.dictionaries.get(i).getWord_target() + "       |"
                        + DictionaryEV.dictionaries.get(i).getWord_explain());
                return;
            }
        }
        System.out.println("không tìm thấy từ!!!");
    }

    public static void dictionaryAdvanced() throws IOException {
        insertFromFile();
        DictionaryCommandline.showAllWords();
        dictionaryLookup();
    }

    public static void addWord(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap tu:");
        String word_target =sc.nextLine();
        System.out.println("nhap nghia:");
        String word_explain = sc.nextLine();
        Word word = new Word(word_target,word_explain);
        if(DictionaryEV.dictionaries.contains(word)){
            System.out.println("đã có từ này trong từ điển của bạn," +
                    " thao tác tiếp theo của bạn sẽ chỉnh sửa nghĩa của từ này.\n" +
                    "nhấn \"y + enter\" nếu đồng ý hoặc \"phím bất kỳ + enter\" nếu không.");
            String yesOrNo = sc.nextLine();
            if(yesOrNo.equals("y")){
                DictionaryEV.changeWord(word_target,word_explain);
            }else {
                System.out.println("từ được giữ nguyên!!!");
            }
        }else{
            DictionaryEV.addDictionary(word_target,word_explain);
        }
    }

    public static void editListWord(){
        System.out.println("nhập từ cần sửa:");
        Scanner sc = new Scanner(System.in);
        String word_target = sc.nextLine();
        for (int i = 0; i < DictionaryEV.dictionaries.size(); i++) {
            if(DictionaryEV.dictionaries.get(i).getWord_target().equals(word_target)){
                System.out.println("nhập nghĩa mới:");
                String word_explain = sc.nextLine();
                DictionaryEV.changeWord(word_target,word_explain);
                return;
            }
        }
        System.out.println("không tìm thấy từ!!!");
    }

    public static void removeAWord(){
        System.out.println("nhập từ cần xóa:");
        Scanner sc = new Scanner(System.in);
        String word_target = sc.nextLine();
        for (int i = 0; i < DictionaryEV.dictionaries.size(); i++) {
            if(DictionaryEV.dictionaries.get(i).getWord_target().equals(word_target)){
                DictionaryEV.removeWord(word_target);
                return;
            }
        }
        System.out.println("không tìm thấy từ!!!");
    }

    public static void dictionaryExportToFile() throws Exception{
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            Reader reader = new FileReader("src\\data\\dictionaries.txt");
            Writer writer = new FileWriter("src\\data\\dictionaries.txt");

            bufferedReader = new BufferedReader(reader);
            bufferedWriter = new BufferedWriter(writer);
            for(int i = 0; i < DictionaryEV.dictionaries.size(); i++){
                bufferedWriter.write(DictionaryEV.dictionaries.get(i).getWord_target() + "    " +
                        DictionaryEV.dictionaries.get(i).getWord_explain()+ "\n") ;
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
           }
        }
    }
}
