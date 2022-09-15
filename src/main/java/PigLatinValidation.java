public class PigLatinValidation {

    //verification methods
    public boolean isUpperCase(String letter) {
        String capitalLetter = letter.toUpperCase();
        return letter.charAt(0) == capitalLetter.charAt(0);
    }

    public boolean isVowel(char letter) {
        String vowel = "aeiouyAEIOUY";
        return vowel.indexOf(letter) != -1;
    }

    public boolean existsConsonants(char letter) {
        return "bcdefghjklmnpqrstvxzw".indexOf(letter) != -1;
    }

    public boolean existsPunctuation(String word) {
        String punctuation = "?!:;,.";
        return punctuation.indexOf(word.charAt(word.length() - 1)) != -1;
    }

    public String excludePunc(String word) {
        String punctuation = "?!:;,.";
        for (char c : punctuation.toCharArray()) {
            word = word.replace(String.valueOf(c), "");
        }
        return word;
    }
}
