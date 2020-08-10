package Concurrent.threadsafety.callables;

import Concurrent.threadsafety.services.MessageService;

import java.util.concurrent.Callable;

/**
 * @author yichangkong
 * @create 2020-08-10-22:59
 */
public class MessageServiceCallable implements Callable<String> {

    private final MessageService messageService;

    public MessageServiceCallable(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public String call() throws Exception {
        return  messageService.getMessage();
    }
}
