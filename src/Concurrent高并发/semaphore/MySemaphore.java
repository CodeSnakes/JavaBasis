package Concurrent�߲���.semaphore;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

/**
 * @author yichangkong
 * @create 2020-08-08-16:17
 * ��Ԫ�ź���
 */
public class MySemaphore {

    Logger LOG = Logger.getLogger("LOG1");

    static Semaphore semaphore = new Semaphore(10);

    public void execute() throws InterruptedException {

        LOG.info("Available permit : " + semaphore.availablePermits());
        LOG.info("Number of threads waiting to acquire: " +
                semaphore.getQueueLength());

        if (semaphore.tryAcquire()) {
            try {
                // perform some critical operations
                // ����һЩ�ؼ�����
            }
            finally {
                semaphore.release();
            }
        }

    }
}
