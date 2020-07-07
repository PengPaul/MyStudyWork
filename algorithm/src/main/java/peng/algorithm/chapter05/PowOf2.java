package peng.algorithm.chapter05;

/**
 * 判断一个数是否是2的整数次幂
 */
public class PowOf2 {
    public static boolean isPowOfTwo(int num){
        int temp = 1;
        while (temp <= num){
            if (temp == num){
                return true;
            }
            temp = temp*2;
        }
        return false;
    }

    public static boolean isPowOfTwo2(int num){
        int temp = 1;
        while (temp <= num){
            if (temp == num){
                return true;
            }
            temp = temp<<1;
        }
        return false;
    }

    public static boolean isPowOfTwo3(int num){
        return (num & num-1) == 0;
    }
}
