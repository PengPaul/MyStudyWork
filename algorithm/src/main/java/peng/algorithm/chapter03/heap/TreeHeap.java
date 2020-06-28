package peng.algorithm.chapter03.heap;

/***
 *  二叉堆
 *   最大堆
 *      任何一个节点的父节点的值都大于或者等于它左右孩子节点的值
 *   最小堆
 *      任何一个节点的父节点的值都小于或者等于它左右孩子节点的值
 *   二叉堆的根点叫堆顶
 *
 *  插入节点
 *      上浮
 *  删除节点
 *      下沉
 *  构建二叉堆
 *     二叉堆存在数组中(广度优先存储)
 *      假设父节点是parent
 *      那么左孩子2*parent+1
 *      右孩子2*parent+2
 */
public class TreeHeap {
    /**
     * 上浮调整
     */
   public void upAdjust(int[] array){
       int childIndex = array.length - 1;
       int parentIndex = (childIndex -1)/2;
       int temp = array[childIndex];
       while (childIndex > 0 && temp < array[parentIndex]){
           array[childIndex] = array[parentIndex];
           childIndex = parentIndex;
           parentIndex = (parentIndex -1)/2;
       }
       array[childIndex] = temp;

   }

    /**
     * 下沉调整
     */
   public void downAdjust(int[] array,int parentIndex,int length){
       int temp = array[parentIndex];
       int childIndx = 2*parentIndex + 1;
       while (childIndx < length){
           //右边小于左边
           if (childIndx + 1 <length && array[childIndx + 1] < array[childIndx]){
                childIndx ++ ;
           }
           if (temp <= array[childIndx]){
               break;
           }
           array[parentIndex] = array[childIndx];
           parentIndex = childIndx;
           childIndx = 2*parentIndex +1;
       }
       array[parentIndex] = temp;
   }

    /**
     * 构建堆
     * @param array
     */
   public void buildHeap(int[] array){
       for (int i = (array.length - 2)/2;i >= 0;i--){
           downAdjust(array,i,array.length);
       }
   }
}
