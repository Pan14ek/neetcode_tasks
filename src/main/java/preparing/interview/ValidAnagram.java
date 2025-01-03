package preparing.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagram {

  public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) return false;

    Map<Character, Integer> firstLine = new HashMap<>();
    Map<Character, Integer> secondLine = new HashMap<>();

    char[] sChars = s.toCharArray();

    for (char sChar : sChars) {
      if (firstLine.containsKey(sChar)) {
        firstLine.put(sChar, firstLine.get(sChar) + 1);
      } else {
        firstLine.put(sChar, 1);
      }
    }

    char[] tChars = t.toCharArray();

    for (char tChar : tChars) {
      if (secondLine.containsKey(tChar)) {
        secondLine.put(tChar, secondLine.get(tChar) + 1);
      } else {
        secondLine.put(tChar, 1);
      }
    }

    for (Map.Entry<Character, Integer> entry : secondLine.entrySet()) {
      if (!firstLine.containsKey(entry.getKey())) {
        return false;
      }

      if (firstLine.containsKey(entry.getKey()) &&
          !Objects.equals(firstLine.get(entry.getKey()), entry.getValue())) {
        return false;
      }
    }

    return true;
  }

}
