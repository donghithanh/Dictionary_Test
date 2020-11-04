package Commandline;

public class Word {

    private String word_target;
    private String  word_explain;

    /**
     * phuong thuc tra ve tu.
     * @return: tu.
     */
    public String getWord_explain() {
        return word_explain;
    }

    /**
     * set tu.
     * @param word_explain: nghia cua tu.
     */
    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    /**
     * phuong thuc tra ve nghia cua tu.
     * @return: nghia cua tu
     */
    public String getWord_target() {
        return word_target;
    }

    /**
     * set nghia.
     * @param word_target: nghia.
     */
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    /**
     * phuong thuc khoi tao tu moi.
     * @param word_target tu moi.
     * @param word_explain nghia.
     */
    public Word(String word_target, String word_explain){
        this.word_explain = word_explain;
        this.word_target = word_target;
    }
}