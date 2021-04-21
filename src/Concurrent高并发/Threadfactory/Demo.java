package Concurrent¸ß²¢·¢.Threadfactory;

/**
 * @author yichangkong
 * @create 2020-08-09-17:18
 */
public class Demo {
  public static void execute() {
    BaeldungThreadFactory factory = new BaeldungThreadFactory("BaeldungThreadFactory");
    for (int i = 0; i < 10; i++) {
        Thread t=factory.newThread(new Task());
        t.start();
    }
  }

  public static void main(String[] args) {
      execute();
  }
}
