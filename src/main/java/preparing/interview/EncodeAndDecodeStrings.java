package preparing.interview;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

  public static void main(String[] args) {
    EncodeAndDecodeStrings encodeAndDecodeStrings = new EncodeAndDecodeStrings();

    List<String> list = new ArrayList<>();

    list.add("we");
    list.add("say");
    list.add(":");
    list.add("yes");
    list.add("!@#$%^&*()");

    String line = encodeAndDecodeStrings.encode(list);
    System.out.println(line);

    List<String> decode = encodeAndDecodeStrings.decode(line);

    System.out.println(decode);
  }

  public String encode(List<String> strs) {
    if (strs.isEmpty()) return "";
    StringBuilder res = new StringBuilder();
    List<Integer> sizes = new ArrayList<>();
    for (String str : strs) {
      sizes.add(str.length());
    }
    for (int size : sizes) {
      res.append(size).append(',');
    }
    res.append('#');
    for (String str : strs) {
      res.append(str);
    }
    return res.toString();
  }

  public List<String> decode(String str) {
    if (str.length() == 0) {
      return new ArrayList<>();
    }
    List<String> res = new ArrayList<>();
    List<Integer> sizes = new ArrayList<>();
    int i = 0;
    while (str.charAt(i) != '#') {
      StringBuilder cur = new StringBuilder();
      while (str.charAt(i) != ',') {
        cur.append(str.charAt(i));
        i++;
      }
      sizes.add(Integer.parseInt(cur.toString()));
      i++;
    }
    i++;
    for (int sz : sizes) {
      res.add(str.substring(i, i + sz));
      i += sz;
    }
    return res;
  }

}
