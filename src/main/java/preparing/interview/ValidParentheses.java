package preparing.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {
    String firstExample = "[]";
    String secondExample = "([{}])";
    String thirdExample = "[(])";

    ValidParentheses parentheses = new ValidParentheses();

    System.out.println(parentheses.isValid(firstExample));
    System.out.println(parentheses.isValid(secondExample));
    System.out.println(parentheses.isValid(thirdExample));
  }

  public boolean isValid(String s) {
    if (s.length() % 2 != 0) {
      return false;
    }

    Stack<Character> stack = new Stack<>();

    Map<Character, Character> map = new HashMap<>();

    map.put(']', '[');
    map.put('}', '{');
    map.put(')', '(');

    for(char symbol : s.toCharArray()) {
      if(map.containsKey(symbol)) {
        if(!stack.isEmpty() && Objects.equals(stack.peek(), map.get(symbol))) {
          stack.pop();
        } else {
          return false;
        }
      } else {
        stack.push(symbol);
      }
    }

    return stack.isEmpty();
  }

}
