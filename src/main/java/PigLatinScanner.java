import java.util.Scanner;

public class PigLatinScanner {

    public static void main(String[] args) {
        Scanner inValue = new Scanner(System.in);

        PigLatinTranslator pigLatinTranslator = new PigLatinTranslator();
        PigLatin picLatin = new PigLatin();

        System.out.print("Insert word to translate: ");
        String word = inValue.nextLine();
        picLatin.setSentence(word);

        String duv = pigLatinTranslator.separateWords(picLatin.getSentence());
        System.out.print("Translation: " + duv);
    }
}
