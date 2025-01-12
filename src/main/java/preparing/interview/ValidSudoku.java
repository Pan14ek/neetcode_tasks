package preparing.interview;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

  public static void main(String[] args) {
    char[][] sudoku = {{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
        {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
        {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
        {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    ValidSudoku validSudoku = new ValidSudoku();

    boolean isValidSudoku = validSudoku.isValidSudoku(sudoku);

    System.out.println(isValidSudoku);
  }

  public boolean isValidSudoku(char[][] board) {
    if (isNotUniqueRow(board)) {
      return false;
    }

    if (isNotUniqueColumn(board)) {
      return false;
    }

    for (int i = 0; i < board.length; i++) {
      Set<Character> uniqueSquareElement = new HashSet<>();
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          int row = (i / 3) * 3 + j;
          int col = (i % 3) * 3 + k;

          if (uniqueSquareElement.contains(board[row][col])) {
            return false;
          } else if (board[row][col] != '.') {
            uniqueSquareElement.add(board[row][col]);
          }
        }
      }
    }

    return true;
  }

  private static boolean isNotUniqueColumn(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      Set<Character> uniqueColumn = new HashSet<>();
      for (char[] chars : board) {
        char columnElement = chars[i];

        if (uniqueColumn.contains(columnElement)) {
          return true;
        } else if (columnElement != '.') {
          uniqueColumn.add(columnElement);
        }
      }
    }

    return false;
  }

  private static boolean isNotUniqueRow(char[][] board) {
    for (char[] chars : board) {
      Set<Character> uniqueRow = new HashSet<>();

      for (char aChar : chars) {
        if (uniqueRow.contains(aChar)) {
          return true;
        } else if (aChar != '.') {
          uniqueRow.add(aChar);
        }
      }
    }
    return false;
  }

}
