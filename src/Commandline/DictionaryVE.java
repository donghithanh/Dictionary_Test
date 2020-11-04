package Commandline;

import java.util.ArrayList;

public class DictionaryVE {
    public static ArrayList<Word> dictionaries = new ArrayList<Word>();

    /**
     * tao tu thu i trong mang tu.
     * @param word_target tu.
     * @param word_explain nghia cua tu.
     */
    public static void addDictionary(String word_target, String word_explain) {
        Word word = new Word(word_target,word_explain);
        dictionaries.add(word);
    }

    public static void changeWord(String word_target, String word_explain){
        for (int i = 0; i < dictionaries.size(); i++) {
            if(dictionaries.get(i).getWord_target().equals(word_target)){
                Word word = new Word(word_target,word_explain);
                dictionaries.set(i,word);
            }
        }
    }

    public static void removeWord(String word_target){
        for (int i = 0; i < dictionaries.size(); i++) {
            if(dictionaries.get(i).getWord_target().equals(word_target)){
                dictionaries.remove(i);
            }
        }
    }
}
