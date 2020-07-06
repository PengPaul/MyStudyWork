package peng.algorithm.chapter04;

import java.util.Arrays;

/**
 * 冒泡排序
 *    稳定的排序
 *    优化1 前面顺序的
 *    优化2 后面是顺序的
 *
 *    鸡尾酒排序
 *      先正着冒泡，再反过来这一过程
 */
public class BubbleSort {

    public static void sort(int array[]){
        for (int i = 0;i<array.length;i++){
            for (int j = 0;j<array.length -i-1;j++){
                int tmp = 0;
                if (array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
    //优化1
    public static void sortOp1(int array[]){
        for (int i = 0;i<array.length;i++){
            boolean isSort = true;
            for (int j = 0;j<array.length -i-1;j++){
                int tmp = 0;
                if (array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSort = false;
                }
            }
            if (isSort){
                break;
            }
        }
    }
    //优化2
    public static void sortOp2(int array[]){
        int lastExchangeIndex = 0;
        int sortBorder = array.length -1;
        for (int i = 0;i<array.length;i++){
            boolean isSort = true;
            for (int j = 0;j<array.length -i-1;j++){
                int tmp = 0;
                if (array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSort = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSort){
                break;
            }
        }
    }

    //鸡尾酒排序
    public static void cocktailSort(int array[]){
        for (int i = 0;i<array.length/2;i++){
            boolean isSort = true;
            for (int j = i;j<array.length -i-1;j++){
                int tmp = 0;
                if (array[j] > array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    isSort = false;
                }
            }
            if (isSort){
                break;
            }
            isSort = true;
            for (int j = array.length -i-1;j>i;j--){
                int tmp = 0;
                if (array[j] < array[j-1]){
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    isSort = false;
                }
            }
            if (isSort){
                break;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        sortOp2(array);
        System.out.println(Arrays.toString(array));

        int[] array2 = new int[]{2,3,4,5,6,7,8,1};
        cocktailSort(array2);
        System.out.println(Arrays.toString(array2));
    }

}
