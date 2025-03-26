package preparing.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

  public static void main(String[] args) {
    SortCharactersByFrequency sortCharactersByFrequency = new SortCharactersByFrequency();

    String value = sortCharactersByFrequency.frequencySort("tree");

    System.out.println(value);
  }

  public String frequencySort(String s) {
    char[] sChars = s.toCharArray();

    Map<Character, Integer> counts = new HashMap<>();

    for (char sChar : sChars) {
      counts.put(sChar, counts.getOrDefault(sChar, 0) + 1);
    }

    List<Character> characters = new ArrayList<>(counts.keySet());
    characters.sort((a, b) -> counts.get(b) - counts.get(a));

    StringBuilder builder = new StringBuilder();

    for (Character character : characters) {
      int count = counts.get(character);

      builder.append(String.valueOf(character).repeat(Math.max(0, count)));
    }

    return builder.toString();
  }

}
