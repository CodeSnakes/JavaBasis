package Concurrent�߲���.threadsafety.services;

/**
 * @author yichangkong
 * @create 2020-08-10-22:14
 * ������Ϣ
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
