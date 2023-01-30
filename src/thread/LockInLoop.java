package thread;

/**
 * @author zhangjie
 */
public class LockInLoop {

  public static void main(String[] args) {
    Runnable task = ()->{
      for(int i = 0; i < 10; i++){
        synchronized (LockInLoop.class){
          try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"----");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    };


    new Thread(task).start();
    new Thread(task).start();

  }
}
