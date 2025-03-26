package preparing.interview;

import java.util.Arrays;

public class MinimumNumberGame {

  public static void main(String[] args) {
    MinimumNumberGame minimumNumberGame = new MinimumNumberGame();

    int[] nums = {5,4,2,3};

    int[] ints = minimumNumberGame.numberGame(nums);

    System.out.println(Arrays.toString(ints));
  }

  public int[] numberGame(int[] nums) {
    Arrays.sort(nums);

    for(int i = 1; i < nums.length; i += 2) {
      int temp = nums[i];

      nums[i] = nums[i - 1];

      nums[i - 1] = temp;
    }

    return nums;
  }

}
