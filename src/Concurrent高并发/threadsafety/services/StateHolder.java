package Concurrent高并发.threadsafety.services;

/**
 * @author yichangkong
 * @create 2020-08-10-22:42 XXX拥有者
 */
public class StateHolder {
  private final String state;

  public StateHolder(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }
}
