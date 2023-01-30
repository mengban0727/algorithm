package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjie
 */
public class SynchronousThreadPool {

  public static void main(String[] args) {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS,
        new SynchronousQueue<>());
//    CountDownLatch countDownLatch = new CountDownLatch(10);

    for(int i = 0; i < 20; i++){
      int finalI = i;
      threadPoolExecutor.execute(() -> {
        System.out.println(finalI);
        try {
          Thread.sleep(5000000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }
    threadPoolExecutor.shutdown();
  }
}
