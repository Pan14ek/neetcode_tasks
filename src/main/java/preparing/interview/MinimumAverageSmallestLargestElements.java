package preparing.interview;

import java.util.ArrayList;
import java.util.List;

public class MinimumAverageSmallestLargestElements {

  public static void main(String[] args) {
    int[] arr = {7, 8, 3, 4, 15, 13, 4, 1};

    MinimumAverageSmallestLargestElements minimumAverageSmallestLargestElements =
        new MinimumAverageSmallestLargestElements();

    double v = minimumAverageSmallestLargestElements.minimumAverage(arr);

    System.out.println(v);
  }

  public double minimumAverage(int[] nums) {
    List<Double> averages = new ArrayList<>();

    while (nums.length != 0) {

      int min = nums[0];
      int max = nums[0];
      int indexMin = 0;
      int indexMax = 0;

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] < min) {
          min = nums[i];
          indexMin = i;
        }
      }

      nums = removeElementByIndex(nums, indexMin);

      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > max) {
          max = nums[i];
          indexMax = i;
        }
      }

      nums = removeElementByIndex(nums, indexMax);

      double averageValue = (double) (min + max) / 2;

      averages.add(averageValue);
    }

    double smallestAverageElement = averages.get(0);

    for (double element : averages) {
      if (smallestAverageElement > element) {
        smallestAverageElement = element;
      }
    }

    return smallestAverageElement;
  }

  private int[] removeElementByIndex(int[] arr, int removedIdx) {
    List<Integer> numbers = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      if (i != removedIdx) {
        numbers.add(arr[i]);
      }
    }

    return numbers.stream().mapToInt(i -> i).toArray();
  }

}
