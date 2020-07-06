package peng.algorithm.chapter04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序
 *
 * 分治法
 *
 * O(nlogn)===>O(n2)
 */
public class QuickSort {

    /**
     * 递归方式
     * 双边循环法
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort(int[] arr,int startIndex,int endIndex){
        //递归条件结束
        if (startIndex >= endIndex){
            return;
        }
        //获取基准位置
        int pivotIndex = parttion(arr,startIndex,endIndex);
        quickSort(arr,startIndex,pivotIndex - 1);
        quickSort(arr,pivotIndex+1,endIndex);
    }

    private static int parttion(int[] array,int startIndex,int endIndex){
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            while (left < right && array[right] > pivot){
                right -- ;
            }
            while (left < right && array[left] <= pivot){
                left ++;
            }
            if (left < right){
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        array[startIndex] = array[left];
        array[left] = pivot;
        return left;
    }

    /**
     * 递归方式
     * 单边循环法
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort2(int[] arr,int startIndex,int endIndex){
        if (startIndex >= endIndex){
            return;
        }
        int pivotIndex = parttion2(arr,startIndex,endIndex);
        quickSort2(arr,startIndex,pivotIndex-1);
        quickSort2(arr,pivotIndex+1,endIndex);
    }

    private static int parttion2(int[] arr,int startIndex,int endIndex){
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex +1;i <= endIndex;i++){
            if (arr[i] < pivot){
                mark ++;
                int tmp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = tmp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    /**
     * 非递归方式
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void quickSort3(int[] arr,int startIndex,int endIndex){
        Stack<Map<String,Integer>> quickStack = new Stack<>();
        Map map = new HashMap();
        map.put("startIndex",startIndex);
        map.put("endIndex",endIndex);
        quickStack.push(map);

        while (quickStack!=null){
            Map<String,Integer> parm = quickStack.pop();
            int piovtIndex = parttion3(arr,parm.get("startIndex"),parm.get("endIndex"));
            if (parm.get("startIndex") < piovtIndex -1){
                Map left = new HashMap();
                left.put("startIndex",startIndex);
                left.put("endIndex",piovtIndex -1);
                quickStack.push(left);
            }
            if (piovtIndex + 1 < parm.get("endIndex")){
                Map right = new HashMap();
                right.put("startIndex",piovtIndex + 1);
                right.put("endIndex",endIndex);
                quickStack.push(right);
            }
        }
    }

    private static int parttion3(int[] arr,int startIndex,int endIndex){
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex +1;i <= endIndex;i++){
            if (arr[i] < pivot){
                mark ++;
                int tmp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = tmp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}


