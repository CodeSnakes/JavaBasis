package DataStructures.recursion;

/**
 * @author yichangkong
 * @create 2020-04-08-23:46
 */
class mapForShortestPath {

    public static void main(String[] args) {

        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("初始化迷宫：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("找路完成： 》 " + setWay(map, 1, 1));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "   ");
            }
            System.out.println();
        }

    }


    static public boolean setWay(int[][] map, int i, int j) {

        if (map[6][5] == 2) {
            return true;
        } else if (map[i][j] == 0) {//起点
            map[i][j] = 2;
            if (setWay(map, i + 1, j)) {//下
                return true;
            } else if (setWay(map, i, j + 1)) {//右
                return true;
            } else if (setWay(map, i - 1, j)) {//上
                return true;
            } else if (setWay(map, i, j - 1)) {//左
                return true;
            } else {//多不能走通
                map[i][j] = 3;
                return false;
            }
        } else if (map[i][j] == 1) {
            map[i][j] = 1;
            return false;
        } else {
            map[i][j] = 3;
            return false;
        }
    }
}
