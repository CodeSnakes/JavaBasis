package Concurrent高并发.threadsafety.services;

/**
 * @author yichangkong
 * @create 2020-08-10-22:14
 * 服务信息
 */
public class MessageService {
    private final String message;

    public MessageService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
