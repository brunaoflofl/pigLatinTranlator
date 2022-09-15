public class PigLatinTranslator {

    PigLatinValidation pigLatinValidation = new PigLatinValidation();

    //breaks the sentence into words
    public String separateWords(String sentence) {
        String translatedSentence = "";
        int beginIndex = 0;

        //checks if the string is empty
        if (sentence.isEmpty()) {
            return "Error: please insert word to translate";
        }

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                String word = sentence.substring(beginIndex, i);
                String translation = translate(word).toLowerCase();

                //if the first letter of the initial word is capitalized, then the translated word must also be capitalized.
                if (pigLatinValidation.isUpperCase(word)) {
                    translation = translation.substring(0, 1).toUpperCase().concat(translation.substring(1));
                }

                //assembles the translated phrase.
                translatedSentence += translation + " ";
                beginIndex = i + 1;

            } else if (i == sentence.length() - 1) {
                String word = sentence.substring(beginIndex, i + 1);
                String translation = translate(word).toLowerCase();

                //if the first letter of the initial word is capitalized, then the translated word must also be capitalized.
                if (pigLatinValidation.isUpperCase(word)) {
                    translation = translation.substring(0, 1).toUpperCase().concat(translation.substring(1));
                }

                //assembles the translated phrase.
                translatedSentence += translation + " ";
                beginIndex = i++;
            }
        }
        return translatedSentence;
    }

    //translate to Pig Latin
    private String translate(String word) {
        String translated = "";
        int index = -1;

        //checks if the word has only vowels
        for (int i = 0; i < word.length(); i++) {
            if (pigLatinValidation.existsConsonants(word.charAt(i))) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return translateOnlyVowelsWord(word);
        }
        for (int i = 0; i < word.length(); i++) {
            String wordWithPunc = "";

            //checks if the word starts with a vowel
            if (pigLatinValidation.isVowel(word.charAt(i))) {

                //checks if the word has punctuation
                if (pigLatinValidation.existsPunctuation(word)) {
                    wordWithPunc = word.substring(i);
                    return translateWithPuncWord(word, wordWithPunc);
                }
                index = i;
                return translateWithoutPuncWord(word, index);
            }
        }
        for (int i = 0; i < word.length(); i++) {
            String wordWithPunc = "";

            //check if the word doesn't start with a vowel
            if (word.charAt(i) == 'y') {

                //checks if the word has punctuation
                if (pigLatinValidation.existsPunctuation(word)) {
                    wordWithPunc = word.substring(i);
                    return translateWithPuncWord(word, wordWithPunc);
                }
                index = i;
                return translateWithoutPuncWord(word, index);
            }
        }
        translated = word + "ay";

        //returns the translated word.
        return translated;
    }

    //method to translate words that contain only vowels
    private String translateOnlyVowelsWord(String word) {
        int index = -1;
        String translated = "";

        for (int i = 0; i < word.length(); i++) {
            String wordWithoutPunc = "";
            index = i;

            //checks if the word has punctuation
            if (pigLatinValidation.existsPunctuation(word)) {
                String wordWithPunc = word.substring(index);
                wordWithoutPunc = pigLatinValidation.excludePunc(wordWithPunc);
                translated = wordWithoutPunc + word.substring(0, index) + "yay" + word.substring(word.length() - 1);
                return translated;
            }
            translated = word.substring(index) + word.substring(0, index) + "yay";
            return translated;
        }
        return translated;
    }

    //method to translate words that contain punctuation ',.?!;:'
    private String translateWithPuncWord(String word, String wordWithPunc) {
        String wordWithoutPunc = "";
        String stem = "";
        String translated = "";

        //delete the punctuation
        wordWithoutPunc = pigLatinValidation.excludePunc(wordWithPunc);
        stem = word.substring(0, 1);
        translated = wordWithoutPunc;
        translated += (stem + "ay" + word.substring(word.length() - 1));
        return translated;
    }

    //method to translate words that do not contain punctuation
    private String translateWithoutPuncWord(String word, int index) {
        String stem = "";
        String translated = "";

        stem = word.substring(0, index);
        translated = word.substring(index);
        translated += (stem + "ay");
        return translated;
    }
}


