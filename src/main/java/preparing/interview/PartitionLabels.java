package preparing.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

  public static void main(String[] args) {
    String case2 = "eccbbbbdec";
    String case1 = "ababcbacadefegdehijhklij";

    PartitionLabels partitionLabels = new PartitionLabels();

    List<Integer> partitionedLabels1 = partitionLabels.partitionLabels(case1);
    System.out.println(partitionedLabels1);

    List<Integer> partitionedLabels2 = partitionLabels.partitionLabels(case2);
    System.out.println(partitionedLabels2);
  }

  public List<Integer> partitionLabels(String s) {
    if(s.length() >= 1 && s.length() <= 3) {
      return List.of(s.length());
    }

    Map<Character, Integer> lastIndexes = new HashMap<>();
    char[] letters = s.toCharArray();

    for(int i = 0; i < letters.length; i++) {
      lastIndexes.put(letters[i], i);
    }

    List<Integer> sizeOfParts = new ArrayList<>();

    int max = 0;
    int counter = 0;

    for(int i = 0; i < s.length(); i++) {
      max = Math.max(max, lastIndexes.get(s.charAt(i)));
      counter++;

      if(max == i) {
        sizeOfParts.add(counter);
        counter = 0;
      }
    }

    return sizeOfParts;
  }

}
