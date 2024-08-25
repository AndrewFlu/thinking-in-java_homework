package chapters.eleven.containers.map.wordscount;

public class WordContainer {
    private String word;
    private int wordEntryCount = 1;

    public WordContainer(String word) {
        this.word = word;
    }

    public int getWordEntryCount() {
        return wordEntryCount;
    }

    private void setWordEntryCount(int wordEntryCount) {
        this.wordEntryCount = wordEntryCount;
    }



    @Override
    public String toString() {
        return "Слово [" + word + "] встречается " + wordEntryCount + " раз";
    }

    public void incrementCount() {
        setWordEntryCount(getWordEntryCount() + 1);
    }

    public String getWord() {
        return word;
    }
}
