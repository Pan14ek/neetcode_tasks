package preparing.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeleteGreatestValueInEachRow {

  public static void main(String[] args) {
    int[][] matrix = {{10}};

    DeleteGreatestValueInEachRow deleteGreatestValueInEachRow = new DeleteGreatestValueInEachRow();

    int answer = deleteGreatestValueInEachRow.deleteGreatestValue(matrix);

    System.out.println(answer);
  }

  public int deleteGreatestValue(int[][] grid) {
    int answer = 0;

    while (grid[0].length != 0) {
      List<Integer> maxNumbers = new ArrayList<>();

      for (int i = 0; i < grid.length; i++) {
        Arrays.sort(grid[i]);

        if(grid[i].length == 0) {
          break;
        }

        maxNumbers.add(grid[i][grid[i].length - 1]);

        grid[i] = Arrays.copyOf(grid[i], grid[i].length - 1);
      }
      if(!maxNumbers.isEmpty()) {
        answer += Collections.max(maxNumbers);
      }

    }

    return answer;
  }

}
