package preparing.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindXSumOfAllKLongSubarraysI {

  public static void main(String[] args) {
    int[] arr = {3,8,7,8,7,5};
    int k = 2;
    int x = 2;

    FindXSumOfAllKLongSubarraysI findXSumOfAllKLongSubarraysI = new FindXSumOfAllKLongSubarraysI();

    int[] xSum = findXSumOfAllKLongSubarraysI.findXSum(arr, k, x);

    System.out.println(Arrays.toString(xSum));
  }

  public int[] findXSum(int[] nums, int k, int x) {
    int length = nums.length - k + 1;

    int[] answer = new int[length];
    int index = 0;

    for (int i = 0; i < length; i++) {

      Map<Integer, Integer> maps = new HashMap<>();

      for (int j = i; j < i + k; j++) {
        if (maps.containsKey(nums[j])) {
          maps.put(nums[j], maps.get(nums[j]) + 1);
        } else {
          maps.put(nums[j], 1);
        }
      }

      Map<Integer, Integer> sortedElements =  maps.entrySet()
          .stream()
          .sorted((e1, e2) -> {
            if (!e1.getValue().equals(e2.getValue()))
              return e2.getValue() - e1.getValue();
            else
              return e2.getKey() - e1.getKey();
          })
          .collect(Collectors.toMap(
              Map.Entry::getKey,
              Map.Entry::getValue,
              (oldValue, newValue) -> oldValue, LinkedHashMap::new));

      int sum = 0;
      int counter = 0;

      for(Map.Entry<Integer, Integer> entry : sortedElements.entrySet()) {
        if(counter == x) {
          break;
        }

        sum += entry.getKey() * entry.getValue();
        counter++;
      }

      answer[index++] = sum;
    }

    return answer;
  }

}
/*

LinkedHashMap<Integer, Integer> sortedMap = maps.entrySet()
    .stream()
    .sorted((e1, e2) -> {
        if (!e1.getValue().equals(e2.getValue()))
            return e2.getValue() - e1.getValue(); // спочатку за частотою (спадання)
        else
            return e2.getKey() - e1.getKey();     // потім за числом (спадання)
    })
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (oldVal, newVal) -> oldVal,
        LinkedHashMap::new
    ));


 */