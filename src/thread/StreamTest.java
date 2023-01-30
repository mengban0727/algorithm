package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjie
 */
public class StreamTest {

  public static void main(String[] args) {
    List<Integer> integerList= new ArrayList<Integer>();

    for (int i = 0; i <100; i++) {
      integerList.add(i);
    }

    List<Integer> parallelList = new ArrayList<>() ;
    integerList.stream()
        .parallel()
        .filter(i->i%2==1)
        .forEach(parallelList::add);

    System.out.println(integerList);
  }
}
