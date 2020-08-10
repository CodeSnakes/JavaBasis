package Concurrent.threadsafety.services;

/**
 * @author yichangkong
 * @create 2020-08-10-22:42 XXXÓµÓÐÕß
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
