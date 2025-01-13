package preparing.interview;

public class MinimumStack {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(10);
    minStack.pop();
    minStack.push(20);
    System.out.println(minStack.top());    // return 2
    minStack.push(-20);
    System.out.println(minStack.getMin()); // return 0
  }

  public static class MinStack {
    private Node root;
    private Integer minValue;

    public MinStack() {
    }

    public void push(int val) {
      if (root == null) {
        root = new Node(val);
        minValue = val;
      } else {
        Node newNode = new Node(val);
        newNode.next = root;
        root = newNode;

        if (minValue > val) {
          minValue = val;
        }
      }
    }

    public void pop() {
      if (root.val == minValue) {
        minValue = null;
      }

      root = root.next;

      Node temp = root;

      while (temp != null) {
        if (minValue == null || minValue > temp.val) {
          minValue = temp.val;
        }
        temp = temp.next;
      }
    }

    public int top() {
      return root.val;
    }

    public int getMin() {
      return minValue;
    }

    private class Node {
      int val;
      Node next;

      public Node(int val) {
        this.val = val;
      }
    }
  }

}
