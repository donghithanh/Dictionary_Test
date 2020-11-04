package App;

import java.io.IOException;
import java.util.ArrayList;

import Commandline.DictionaryCommandline;
import Commandline.Word;

public class Connection {
    public ArrayList<Word> getData (String word, boolean TF) throws IOException {
        ArrayList<Word> data = new ArrayList<Word>();
        JSOUPDecoder decoder = new JSOUPDecoder();
        if(TF){
            if(DictionaryCommandline.dictionarySearcher(word, TF).isEmpty()){
                decoder.deCoderEV(word);
                data.addAll(DictionaryCommandline.dictionarySearcher(word, TF));
            }else{
                return DictionaryCommandline.dictionarySearcher(word, TF);
            }
        }else{
                if(DictionaryCommandline.dictionarySearcher(word, TF).isEmpty()){
                    decoder.deCoderVE(word);
                    data.addAll(DictionaryCommandline.dictionarySearcher(word, TF));
                }else{
                    return DictionaryCommandline.dictionarySearcher(word, TF);
                }
        }
        return data;
    }
}