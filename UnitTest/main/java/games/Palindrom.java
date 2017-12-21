package games;

public class Palindrom {

    private static String reverse(String word) {
        StringBuilder reverse = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; --i)
            reverse.append(word.charAt(i));
        return reverse.toString();
    }

    public static boolean checkWord(String someWord) {
        someWord = someWord.toLowerCase();
        return someWord.equals(reverse(someWord));
    }

    public static boolean checkPhrase(String somePhrase) {
        somePhrase = somePhrase.toLowerCase();
        somePhrase = somePhrase.replace(" ", "");
        return somePhrase.equals(reverse(somePhrase));
    }
}





