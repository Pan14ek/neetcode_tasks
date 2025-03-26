package preparing.interview;

import java.util.Stack;

public class RemoveOutermostParentheses {

  public static void main(String[] args) {
    RemoveOutermostParentheses removeOutermostParentheses = new RemoveOutermostParentheses();

    String line = removeOutermostParentheses.removeOuterParentheses("(()())(())");

    System.out.println(line);
  }

  public String removeOuterParentheses(String s) {
    Stack<Character> stack = new Stack<>();

    for(char sChar : s.toCharArray()) {
      if(sChar == '(') {
        if(!stack.empty() && stack.peek() == '(') {
          continue;
        } else {
          stack.push(sChar);
        }
      } else {
        if(!stack.empty() && stack.peek() == ')') {
          continue;
        } else {
          stack.push(sChar);
        }
      }
    }

    StringBuilder builder = new StringBuilder();

    while(!stack.empty()) {
      char left = stack.pop();
      char right = stack.pop();

      builder.append(right).append(left);
    }

    return builder.toString();
  }

}
