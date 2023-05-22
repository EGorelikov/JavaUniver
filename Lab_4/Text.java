import java.util.ArrayList;
import java.util.List;

class Text {
    private List<Sentence> sentences;

    public Text() {
        this.sentences = new ArrayList<>();
    }

    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
