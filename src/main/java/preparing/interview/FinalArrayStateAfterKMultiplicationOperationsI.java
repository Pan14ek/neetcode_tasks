package preparing.interview;

import java.util.Arrays;

public class FinalArrayStateAfterKMultiplicationOperationsI {

  public static void main(String[] args) {
    FinalArrayStateAfterKMultiplicationOperationsI finalArrayStateAfterKMultiplicationOperationsI =
        new FinalArrayStateAfterKMultiplicationOperationsI();

    int[] finalState =
        finalArrayStateAfterKMultiplicationOperationsI.getFinalState(new int[] {2, 1, 3, 5, 6}, 5,
            2);

    System.out.println(Arrays.toString(finalState));
  }

  public int[] getFinalState(int[] nums, int k, int multiplier) {
    for (int i = 0; i < k; i++) {

      int min = nums[0];
      int minIndex = 0;

      for (int j = 0; j < nums.length; j++) {
        if (min > nums[j]) {
          min = nums[j];
          minIndex = j;
        }
      }

      nums[minIndex] = nums[minIndex] * multiplier;
    }

    return nums;
  }

}
