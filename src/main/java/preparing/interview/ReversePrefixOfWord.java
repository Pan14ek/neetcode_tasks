package preparing.interview;

public class ReversePrefixOfWord {

  public static void main(String[] args) {
    String word = "abcdefd";

    char ch = 'd';

    ReversePrefixOfWord reversePrefixOfWord = new ReversePrefixOfWord();

    System.out.println(reversePrefixOfWord.reversePrefix(word, ch));
  }

  public String reversePrefix(String word, char ch) {

    int index = 0;

    char[] words = word.toCharArray();

    for(int i = 0; i < words.length; i++) {
      if(words[i] == ch) {
        index = i;
        break;
      }
    }

    int lastIndex = index;

    for(int i = 0; i <= index / 2; i++) {
      char temp = words[i];
      words[i] = words[lastIndex];
      words[lastIndex] = temp;
      lastIndex--;
    }

    return String.valueOf(words);
  }

}
