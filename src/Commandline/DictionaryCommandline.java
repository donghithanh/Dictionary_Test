package Commandline;

import java.util.ArrayList;

public class DictionaryCommandline {
    /**
     * phuong thuc show toan bo tu dien.
     */
    public static void showAllWords(){
        System.out.println("No  | English   | Vietnamese");
        for (int i = 0; i < DictionaryEV.dictionaries.size(); i++) {
            System.out.println((i+1) + "   |" + DictionaryEV.dictionaries.get(i).getWord_target() + "       |"
                    + DictionaryEV.dictionaries.get(i).getWord_explain());
        }
    }

    /**
     * phuong thuc goi ham show va insert.
     */
    public static void dictionaryBasic(){
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public static ArrayList<Word> dictionarySearcher(String word, Boolean TF){
        ArrayList<Word> searcher = new ArrayList<Word>();
        if(TF){
            for (int i = 0; i < DictionaryEV.dictionaries.size(); i++) {
                if(DictionaryEV.dictionaries.get(i).getWord_target().startsWith(word)){
                    searcher.add(DictionaryEV.dictionaries.get(i));
                }
            }
        }else{
            for (int i = 0; i < DictionaryVE.dictionaries.size(); i++) {
                if(DictionaryVE.dictionaries.get(i).getWord_target().startsWith(word)){
                    searcher.add(DictionaryVE.dictionaries.get(i));
                }
            }
        }
        return searcher;
    }
}
