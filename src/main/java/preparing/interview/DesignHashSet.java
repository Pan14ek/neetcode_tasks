package preparing.interview;

import java.util.ArrayList;
import java.util.List;

public class DesignHashSet {

  public static void main(String[] args) {
    MyHashSet myHashSet = new MyHashSet();

    myHashSet.add(1);
    myHashSet.add(2);

    System.out.println(myHashSet.contains(1));
    System.out.println(myHashSet.contains(3));

    myHashSet.add(2);

    System.out.println(myHashSet.contains(2));

    myHashSet.remove(2);

    System.out.println(myHashSet.contains(2));
  }

  static class MyHashSet {

    private final int BUCKET_SIZE = 520;
    private List<Integer>[] buckets;

    public MyHashSet() {
      buckets = new ArrayList[BUCKET_SIZE];

      for (int i = 0; i < BUCKET_SIZE; i++) {
        buckets[i] = new ArrayList<>();
      }
    }

    public void add(int key) {
      int index = calculateHashIndex(key);

      List<Integer> bucket = buckets[index];
      if (!bucket.contains(key)) {
        bucket.add(key);
      }
    }

    public void remove(int key) {
      int index = calculateHashIndex(key);

      List<Integer> bucket = buckets[index];
      bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
      int index = calculateHashIndex(key);

      List<Integer> bucket = buckets[index];
      return bucket.contains(key);
    }

    private int calculateHashIndex(int key) {
      return key % BUCKET_SIZE;
    }
  }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

}
