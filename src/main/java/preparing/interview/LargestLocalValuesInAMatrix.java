package preparing.interview;

public class LargestLocalValuesInAMatrix {

  public static void main(String[] args) {
    LargestLocalValuesInAMatrix largestLocalValuesInAMatrix = new LargestLocalValuesInAMatrix();

    int[][] matrix = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};

    int[][] ints = largestLocalValuesInAMatrix.largestLocal(matrix);

    for (int[] row : ints) {
      for (int col : row) {
        System.out.println(col);
      }
    }
  }

  public int[][] largestLocal(int[][] grid) {
    int size = grid.length - 2;
    int[][] maxLocal = new int[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {

        int maxElement = 0;

        for(int k = i; k < i + 3; k++) {
          for(int l = j; l < j + 3; l++) {
            maxElement = Math.max(maxElement, grid[k][l]);
          }
        }

        maxLocal[i][j] = maxElement;

      }
    }

    return maxLocal;
  }

}
