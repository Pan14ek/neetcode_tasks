package preparing.interview;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

  public static void main(String[] args) {
    int[] nums = {0, 3, 2, 5, 4, 6, 1, 1};

    LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();

    int counter = longestConsecutiveSequence.longestConsecutive(nums);

    System.out.println(counter);
  }

  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    Set<Integer> set = new HashSet<>();

    int longestConsecutive = 0;

    for (int num : nums) {
      set.add(num);
    }

    for (int num : nums) {
      if (!set.contains(num - 1)) {
        int length = 1;

        while (set.contains(num + length)) {
          length++;
        }

        longestConsecutive = Math.max(longestConsecutive, length);
      }
    }

    return longestConsecutive;
  }

}
