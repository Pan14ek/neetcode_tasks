package preparing.interview;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

  public static void main(String[] args) {
    SimplifyPath simplifyPath = new SimplifyPath();

    System.out.println(simplifyPath.simplifyPath("/../"));
    System.out.println(simplifyPath.simplifyPath("/.../a/../b/c/../d/./"));
  }

  public String simplifyPath(String path) {
    String[] directories = path.split("/");

    Deque<String> queue = new ArrayDeque<>();

    for (String directory : directories) {
      if (".".equals(directory) || directory.isEmpty()) {
        continue;
      }

      if ("..".equals(directory)) {
        if (!queue.isEmpty()) {
          queue.removeLast();
        }
      } else {
        queue.addLast(directory);
      }
    }

    if (queue.isEmpty()) {
      return "/";
    }

    StringBuilder pathBuilder = new StringBuilder();

    while (!queue.isEmpty()) {
      pathBuilder.append("/").append(queue.removeFirst());
    }

    return pathBuilder.toString();
  }

}
