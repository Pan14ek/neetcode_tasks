package preparing.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShortestDistanceCharacter {

  public static void main(String[] args) {
    String s = "loveleetcode";

    char c = 'e';

    ShortestDistanceCharacter shortestDistanceCharacter = new ShortestDistanceCharacter();

    int[] ints = shortestDistanceCharacter.shortestToChar(s, c);

    System.out.println(Arrays.toString(ints));
  }

  public int[] shortestToChar(String s, char c) {
    int[] distances = new int[s.length()];

    List<Integer> indexesWithChar = new ArrayList<>();

    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == c) {
        indexesWithChar.add(i);
      }
    }

    for(int i = 0; i < distances.length; i++) {
      List<Integer> distance = new ArrayList<>();

      for (Integer integer : indexesWithChar) {
        distance.add(Math.abs(i - integer));
      }

      int closestDistance = Collections.min(distance);

      distances[i] = closestDistance;
    }

    return distances;
  }

}
