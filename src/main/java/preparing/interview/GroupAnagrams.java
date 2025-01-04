package preparing.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    if(strs.length == 1) {
      return List.of(List.of(strs[0]));
    }

    Map<String, List<String>> map = new HashMap<>();

    for(String line: strs) {
      char[] chars = line.toCharArray();

      Arrays.sort(chars);

      if(map.containsKey(String.valueOf(chars))) {
        map.get(String.valueOf(chars)).add(line);
      } else {
        List<String> list = new ArrayList<>();
        list.add(line);
        map.put(String.valueOf(chars), list);
      }
    }

    return new ArrayList<>(map.values());
  }

}
