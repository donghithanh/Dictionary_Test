package App;

import Commandline.DictionaryEV;
import Commandline.DictionaryVE;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class JSOUPDecoder {
    public void deCoderEV(String word) throws IOException {
        String fileURL1 = "src\\data\\E_V.txt";
        try {
            Reader reader = new FileReader(fileURL1);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String read = bufferedReader.readLine();

            while(read != null) {
                Document doc = Jsoup.parseBodyFragment(read);
                Elements element1 = doc.getElementsByTag("i");
                String st = element1.text().toLowerCase();
                if(st.startsWith(word)){
                    Elements element2= doc.getElementsByTag("b");
                    DictionaryEV.addDictionary(element1.text(),element2.text());
                }
                read = bufferedReader.readLine();
            }
            bufferedReader.close();
            reader.close();
        }catch (Exception e){
            System.out.println("can't open file url");
        }

    }

    public void deCoderVE (String word) throws IOException {
        String fileURL1 = "src\\data\\V_E.txt";
        Reader reader = new FileReader(fileURL1);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String read = bufferedReader.readLine();

        while(read != null) {
            Document doc = Jsoup.parseBodyFragment(read);
            Elements element1 = doc.getElementsByTag("i");
            String st = element1.text().toLowerCase();
            if(st.startsWith(word)){
                Elements element2= doc.getElementsByTag("b");
                DictionaryVE.addDictionary(element1.text(),element2.text());
            }
            read = bufferedReader.readLine();
        }
        bufferedReader.close();
        reader.close();
    }
}