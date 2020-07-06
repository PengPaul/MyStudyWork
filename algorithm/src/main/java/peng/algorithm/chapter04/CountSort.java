package peng.algorithm.chapter04;

/**
 * 计数排序
 *
 */
public class CountSort {

    public static int[] countSort(int[] array){
        int max = array[0];
        for (int i = 1;i<array.length;i++){
            if (array[i]>max){
                max = array[i];
            }
        }

        int[] countArray = new int[max];
        for (int i = 0;i<array.length;i++){
            countArray[array[i]]++;
        }
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0;i<countArray.length;i++){
            for (int j = 0;j<countArray[i];i++){
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }
}
