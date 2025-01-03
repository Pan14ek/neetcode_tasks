package preparing.interview;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

  public boolean hasDuplicate(int[] nums) {
    Set<Integer> numbers = new HashSet<>();

    for (int num : nums) {
      if (numbers.contains(num)) {
        return true;
      }
      numbers.add(num);
    }

    return false;
  }

}
