package DataStructures.recursion;

/**
 * @author yichangkong
 * @create 2020-04-10-19:50
 */

public class queenEight {

    static int[] queen = new int[8];
    static int count;

    public static void main(String[] args) {
        queenEight queenEight = new queenEight();
        queenEight.check(0);
        System.out.println("解决路径总数： " + count);
    }


    private void check(int n) {
        if (n == 8) {
            count++;
            print();
            return;
        }

        for (int i = 0; i < 8; i++) {

            queen[n] = i;

            if (judgment(n)) {

                check(n + 1);
            }

        }
    }

    public void print() {
        for (int i = 0; i < queen.length; i++) {

            System.out.print(queen[i] + "   ");

        }
        System.out.println();
    }

    public boolean judgment(int n) {


/**
 *@Description
 * queen[i] == queen[n]
 * Math.abs(n - i) == Math.abs(queen[n] - queen[i]
 *@Param [n]
 *@Return boolean
 *@Date 2020/4/10
 *@Time 21:31
 */
        for (int i = 0; i < n; i++) {

            if (queen[i] == queen[n] || Math.abs(n - i) == Math.abs(queen[n] - queen[i])) {
                return false;
            }
        }
        return true;
    }
}
