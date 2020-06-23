package peng.algorithm.chapter02.array;

public class MyArray {
    private int[] array;
    private int size;
    private final static int DEFAULTSIZE = 10;
    private int capacity = 2;

    public MyArray() {
        this.array = new int[DEFAULTSIZE];
        size = 0;
    }

    /**
     * 检查index合法性
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >=  this.size) {
            throw new IndexOutOfBoundsException("over index");
        }
    }

    /**
     * 根据下标读取数组
     *
     * @param index
     * @return
     */
    public int read(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * 根据下标g更新数据
     *
     * @param index
     * @param value
     */
    public void update(int index, int value) {
        checkIndex(index);
        array[index] = value;
    }

    /**
     * 插入数据
     * 三种情况：尾部插入/中间插入/超范围插入
     *
     * 中间插入
     * @param index
     * @param value
     */
    public void insert(int index, int value) {
        //这里插入时index可以为size
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("over index");
        }
        ensuresize();
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = value;
        size++;
    }

    /**
     * 尾部插入
     */
    public void insert(int value) {
        ensuresize();
        array[size] = value;
        size++;
    }

    /**
     * 扩容
     */
    private void ensuresize() {
        if (size >= array.length){
            resize();
        }
    }

    private void resize() {
        int newCapacity = array.length + array.length / capacity;
        int[] arrayNew = new int[newCapacity];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * 删除数组元素
     * @param index
     * @return
     */
    public int delete(int index){
        checkIndex(index);
        int deleteValue = array[index];

        for (int i = index;i<size-1;i++){
            array[i] = array[i+1];
        }
        size --;
        return deleteValue;
    }

    public void outPrint() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i] + " size = " + size);

        }
        System.out.println("=================");
    }
}
