package Concurrent高并发.executor;

import java.util.concurrent.Executor;

/**
 * @author yichangkong
 * @create 2020-08-08-21:24
 * Invoker 调用者
 */
public class Invoker implements Executor {

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
