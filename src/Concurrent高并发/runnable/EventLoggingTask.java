package Concurrent¸ß²¢·¢.runnable;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yichangkong
 * @create 2020-08-09-16:25
 */
public class EventLoggingTask implements Runnable{

    private Logger logger= LoggerFactory.getLogger(EventLoggingTask.class);


    @Override
    public void run() {
        String message="Message read from the event queue";
        logger.info("Message read from the event queue"+message);
    }
}
