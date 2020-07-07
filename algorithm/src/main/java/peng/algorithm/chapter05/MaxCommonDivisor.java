package peng.algorithm.chapter05;

/**
 * 求最大公约数
 *
 * 辗转相除法
 * 欧几里得算法
 * 两个正整数a和b（a>b）,它们的最大公约数等于a除以b的余数c和b之间的最大公约数
 *  %取余性能较差
 *
 *  九章算术
 *  两个正整数a和b（a>b），它们的最大公约数等于a-b的差值c和较小的数b的最大公约数
 *
 */
public class MaxCommonDivisor {
    /**
     * 暴力法
     * @param a
     * @param b
     * @return
     */
    public static int getMaxCommonDivisor(int a,int b){
        int big = a > b? a:b;
        int small = a<b?a:b;
        if (big%small == 0){
            return small;
        }
        for (int i = small/2;i>1;i--){
            if (small%i == 0&&big%i == 0){
                return i;
            }
        }
        return 1;
    }
    /**
     *  辗转相除法
     *  *  (位移)
     * @param a
     * @param b
     * @return
     */
    public static int getMaxCommonDivisor2(int a,int b){
        int big = a > b? a:b;
        int small = a<b?a:b;
        if (big%small == 0){
            return small;
        }
        return getMaxCommonDivisor2(big%small,small);
    }
    /**
     *  九章算术
     * @param a
     * @param b
     * @return
     */
    public static int getMaxCommonDivisor3(int a,int b){
        if( a== b){
            return a;
        }
        int big = a > b? a:b;
        int small = a<b?a:b;
        return getMaxCommonDivisor3(big - small,small);
    }

    /**
     *   九章算术（位移）
     * @param a
     * @param b
     * @return
     *
     * 终极算法
     */
    public static int getMaxCommonDivisor4(int a,int b){
        if( a== b){
            return a;
        }
        if((a&1)==0 && (b&1) == 0){//a是偶数 b也是偶数
            return getMaxCommonDivisor4(a>>1,b>>1)<<1;
        }else if ((a%1) == 0 && (b&1)!=0){//a是偶数 b是奇数
            return getMaxCommonDivisor4(a>>1,b);
        }else if ((a%1) != 0 && (b&1)==0){//a是奇数 ，b是偶数
            return getMaxCommonDivisor4(a,b>>1);
        }else {//a是奇数 b也是奇数
            int big = a > b? a:b;
            int small = a<b?a:b;
            return getMaxCommonDivisor4(big - small,small);
        }
    }
}
