package preparing.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

  public static void main(String[] args) {
    // 1,2,2,3,3,3

    //counts -> 2 - 2; 3 - 3; 1 - 1
  }

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> counts = new HashMap<>();

    for (int num : nums) {
      if (counts.containsKey(num)) {
        counts.put(num, counts.get(num) + 1);
      } else {
        counts.put(num, 1);
      }
    }

    List<int[]> frequentElements = new ArrayList<>();

    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      frequentElements.add(new int[] {entry.getValue(), entry.getKey()});
    }

    frequentElements.sort((a, b) -> b[0] - a[0]);

    int[] result = new int[k];

    int index = 0;

    for (int[] element : frequentElements) {
      if (index < k) {
        result[index++] = element[1];
      } else {
        break;
      }
    }

    return result;
  }

}
