package preparing.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {
    TwoSum twoSum = new TwoSum();

    int[] nums = {3, 2, 3};
    int target = 6;

    int[] sumIndexes = twoSum.twoSum(nums, target);

    System.out.println(Arrays.toString(sumIndexes)); //0, 1
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numbers = new HashMap<>();

    for(int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];

      if(numbers.containsKey(diff)) {
        return new int[]{numbers.get(diff), i};
      }

      numbers.put(nums[i], i);
    }

    return new int[0];
  }


}
