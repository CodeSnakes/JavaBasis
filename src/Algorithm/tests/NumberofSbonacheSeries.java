package Algorithm.tests;

/**
 * @author yichangkong
 * @create 2020-04-28-15:59
 */
public class NumberofSbonacheSeries {

  public static void main(String[] args) {
    System.out.println(ladder(11));
  }
  public static int ladder(int n){//梯子

    if (n == 1) {
      return 1;
      }else if (n==2){
        return 2;
    }else {
        return ladder(n-1)+ladder(n-2);
    }
  }
//    链接：https://www.nowcoder.com/questionTerminal/db34a72925124e2b8483154a4934a19b
//    来源：牛客网
//
//    你需要爬11楼的时候，你倒回去一步只能待在第10楼或者第9楼。换句话说就是到达第9楼的方法次数加上第10楼的方法次数。
//    如果你待在第10楼，就得待在第9楼或者第8楼
//    如果你待在第9楼，就得待在第8楼或者第7楼
//......
//    如果你待在第3楼，就得待在第1楼或者第2楼
//    爬1楼一种方法，
//    爬2楼两种方法。
//    爬3楼就是爬1楼方法次数加2楼的方法次数。
//    用数学表达就是：
//    a（11）=a（10）+a（9）=144
//    a（10）=a（9）+a（8）=89
//    a（9）=a（8）+a（7）=55
//    a（8）=a（7）+a（6）=34
//    a（7）=a（6）+a（5）=21
//    a（6）=a（5）+a（4）=13
//    a（5）=a（4）+a（3）=8
//    a（4）=a（3）+a（2）=5
//    a（3）=a（2）+a（1）=3
//    a（2）=2
//    a（1）=1
}
