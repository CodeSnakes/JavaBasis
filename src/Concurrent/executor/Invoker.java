package Concurrent.executor;

import java.util.concurrent.Executor;

/**
 * @author yichangkong
 * @create 2020-08-08-21:24
 * Invoker ������
 */
public class Invoker implements Executor {

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
