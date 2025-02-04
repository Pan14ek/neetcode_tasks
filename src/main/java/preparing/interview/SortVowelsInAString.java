package preparing.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowelsInAString {

  public static void main(String[] args) {
    String s = "lEetcOde";

    SortVowelsInAString sortVowelsInAString = new SortVowelsInAString();

    String sortVowels = sortVowelsInAString.sortVowels(s);

    System.out.println(sortVowels);
  }

  public String sortVowels(String s) {
    List<Character> vowels = new ArrayList<>();

    char[] charArray = new char[s.length()];

    int index = 0;

    for(char sChar : s.toCharArray()) {
      char charInLowerCase = Character.toLowerCase(sChar);

      if(charInLowerCase == 'a' || charInLowerCase == 'e' ||
          charInLowerCase == 'i' || charInLowerCase == 'o' || charInLowerCase == 'u') {
        vowels.add(sChar);

        charArray[index] = ' ';
      } else {
        charArray[index] = sChar;
      }
      index++;
    }

    if(vowels.isEmpty()) {
      return s;
    }

    vowels.sort(Character::compareTo);

    int vowelIndex = 0;

    for(int i = 0; i < charArray.length; i++) {
      if(charArray[i] == ' ') {
        charArray[i] = vowels.get(vowelIndex++);
      }
    }

    return String.valueOf(charArray);
  }

}
