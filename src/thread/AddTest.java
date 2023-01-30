package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangjie
 */
public class AddTest {

  private static int count = 0;
  private static Thread thread1;
  private static Thread thread2;

  private static int[] cache = new int[200000];

  public static void main(String[] args) throws InterruptedException {

    thread1 = new Thread(() -> {
      for (int i = 0; i < 100000; i++) {
        count++;
        synchronized (AddTest.class){
          if(cache[count]==1){
            System.out.println(count);
          }else{
            cache[count]=1;
          }
        }
      }
    });
    thread1.start();

    thread2 = new Thread(() -> {
      for (int i = 0; i < 100000; i++) {
        count++;
        synchronized (AddTest.class){
          if(cache[count]==1){
            System.out.println(count);
          }else{
            cache[count]=1;
          }
        }
      }
    });
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println(count);


  }
}
