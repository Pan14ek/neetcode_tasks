package preparing.interview;

public class LexicographicallySmallestPalindrome {

  public String makeSmallestPalindrome(String s) {
    char[] words = s.toCharArray();

    StringBuilder builder = new StringBuilder();

    for(int i = 0; i < words.length; i++) {
      char letter = (char) Math.min(words[i], words[words.length - i - 1]);

      builder.append(letter);
    }

    return builder.toString();
  }

}
