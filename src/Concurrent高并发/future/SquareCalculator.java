package Concurrent高并发.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author yichangkong
 * @create 2020-08-08-23:07
 * Calculator计算器
 */
public class SquareCalculator {
    private final ExecutorService executorService;

    public SquareCalculator(ExecutorService executorService) {
        this.executorService = executorService;
    }
    Future<Integer> calculator(Integer input){
        return executorService.submit(()->{
           Thread.sleep(1000);
           return input*input;
        });
    }

}
