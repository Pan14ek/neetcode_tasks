package preparing.interview;

public class DesignAStackWithIncrementOperation {

  public static void main(String[] args) {
    CustomStack stk = new CustomStack(3);

    stk.push(1);                          // stack becomes [1]
    stk.push(2);                          // stack becomes [1, 2]
    stk.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
    stk.push(2);                          // stack becomes [1, 2]
    stk.push(3);                          // stack becomes [1, 2, 3]
    stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
    stk.increment(5, 100);                // stack becomes [101, 102, 103]
    stk.increment(2, 100);                // stack becomes [201, 202, 103]
    stk.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
    stk.pop();                            // return 202 --> Return top of the stack 202, stack becomes [201]
    stk.pop();                            // return 201 --> Return top of the stack 201, stack becomes []
    stk.pop();                            // return -1 --> Stack is empty return -1.

  }

  static class CustomStack {

    private final int[] array;
    private int topPointer = 0;

    public CustomStack(int maxSize) {
      this.array = new int[maxSize];
    }

    public void push(int x) {
      if(topPointer == this.array.length) {
        return;
      }

      this.array[topPointer++] = x;
    }

    public int pop() {
      if(topPointer == 0) {
        return -1;
      }

      int value = this.array[topPointer - 1];

      this.array[topPointer - 1] = 0;
      topPointer--;

      return value;
    }

    public void increment(int k, int val) {
      if(k > topPointer) {
        for(int i = 0; i < array.length; i++) {
          array[i] += val;
        }
      } else {
        for(int i = 0; i < k; i++) {
          array[i] += val;
        }
      }
    }
  }


}
