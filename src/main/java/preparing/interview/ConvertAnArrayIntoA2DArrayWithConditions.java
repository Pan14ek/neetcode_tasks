package preparing.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertAnArrayIntoA2DArrayWithConditions {

  public static void main(String[] args) {

    int[] arr = {1, 3, 4, 1, 2, 3, 1};

    ConvertAnArrayIntoA2DArrayWithConditions convertAnArrayIntoA2DArrayWithConditions =
        new ConvertAnArrayIntoA2DArrayWithConditions();

    List<List<Integer>> matrix = convertAnArrayIntoA2DArrayWithConditions.findMatrix(arr);

    System.out.println(matrix.toString());

  }

  public List<List<Integer>> findMatrix(int[] nums) {
    Map<Integer, Integer> numCounts = new HashMap<>();

    List<List<Integer>> matrix = new ArrayList<>();

    for (int num : nums) {
      if (numCounts.containsKey(num)) {
        int count = numCounts.get(num);
        numCounts.put(num, count + 1);

        if (matrix.size() <= count) {
          List<Integer> newMatrixElement = new ArrayList<>();
          newMatrixElement.add(num);
          matrix.add(newMatrixElement);
        } else {
          List<Integer> matrixElement = matrix.get(count);
          matrixElement.add(num);
        }
      } else {
        numCounts.put(num, 1);

        if (!matrix.isEmpty()) {
          List<Integer> matrixElement = matrix.get(0);
          matrixElement.add(num);
        } else {
          List<Integer> newMatrixElement = new ArrayList<>();
          newMatrixElement.add(num);
          matrix.add(0, newMatrixElement);
        }
      }
    }

    return matrix;
  }

}
