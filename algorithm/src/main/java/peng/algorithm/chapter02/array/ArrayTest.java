package peng.algorithm.chapter02.array;

public class ArrayTest {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.insert(0,2);
        myArray.outPrint();
        myArray.insert(1,6);
        myArray.outPrint();
        myArray.insert(2,8);
        myArray.outPrint();
        myArray.insert(3,3);
        myArray.outPrint();
        myArray.insert(1,5);
        myArray.outPrint();
    }
}
