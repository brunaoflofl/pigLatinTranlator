import java.util.Objects;

public class PigLatin {

    private String sentence;

    public PigLatin(String sentence) {
        this.sentence = sentence;
    }

    public PigLatin() {
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PigLatin pigLatin = (PigLatin) o;
        return Objects.equals(sentence, pigLatin.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }

    @Override
    public String toString() {
        return "PigLatin{" +
                "sentence='" + sentence + '\'' +
                '}';
    }
}
