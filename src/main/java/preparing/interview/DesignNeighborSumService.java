package preparing.interview;

public class DesignNeighborSumService {

  public static void main(String[] args) {

    //DesignNeighborSumService.NeighborSum neighborSum = new DesignNeighborSumService.NeighborSum();
  }

  static class NeighborSum {

    private int[][] grid;

    public NeighborSum(int[][] grid) {
      this.grid = grid;
    }

    public int adjacentSum(int value) {
      int valueX = 0;
      int valueY = 0;

      for(int i = 0; i < grid.length; i++) {
        for(int j = 0;j < grid[i].length; j++) {
          if(grid[i][j] == value) {
            valueX = i;
            valueY = j;
            break;
          }
        }
      }

      int sum = 0;

      int topValue = valueY == 0 ? 0 : grid[valueX][valueY + 1];
      int leftValue = valueX == 0 ? 0 : grid[valueX - 1][valueY];
      int rightValue = valueY == grid.length - 1 ? 0 : grid[valueX][valueY + 1];
      int bottomValue = valueX == 0 ? 0 : grid[valueX - 1][valueY];

      return topValue + leftValue + rightValue + bottomValue;
    }

    public int diagonalSum(int value) {
      int valueX = 0;
      int valueY = 0;

      for(int i = 0; i < grid.length; i++) {
        for(int j = 0;j < grid[i].length; j++) {
          if(grid[i][j] == value) {
            valueX = i;
            valueY = j;
            break;
          }
        }
      }

      int sum = 0;

      int topLeftValue = valueY == 0 ? 0 : grid[valueX - 1][valueY + 1];
      int leftBottomValue = valueX == 0 ? 0 : grid[valueX + 1][valueY - 1];
      int rightTopValue = valueY == grid.length - 1 ? 0 : grid[valueX + 1][valueY + 1];
      int bottomRightValue = valueX == 0 ? 0 : grid[valueX - 1][valueY + 1];

      return topLeftValue + leftBottomValue + rightTopValue + bottomRightValue;
    }
  }

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */

}
