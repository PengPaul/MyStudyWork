#核心数据结构
##List
ArrayList    数组实现
Vector       数组实现 线程安全
LinkedList   循环双向链表

###添加元素
#### ArrayList
public boolean add(E var1) {
     this.ensureCapacityInternal(this.size + 1);  //确保内部有足够的空间
     this.elementData[this.size++] = var1; //将元素加入到末尾完成添加
     return true;
}

private void ensureCapacityInternal(int var1) {
     this.ensureExplicitCapacity(calculateCapacity(this.elementData, var1));
}

private void ensureExplicitCapacity(int var1) {
     ++this.modCount;
     if (var1 - this.elementData.length > 0) {
         this.grow(var1);
     }
}

private void grow(int var1) {
    int var2 = this.elementData.length;  //原来的长度
    int var3 = var2 + (var2 >> 1);  //原来的1.5倍
    if (var3 - var1 < 0) { 
        var3 = var1;
    }
    if (var3 - 2147483639 > 0) {
        var3 = hugeCapacity(var1);
    }
    this.elementData = Arrays.copyOf(this.elementData, var3);
}

private static int hugeCapacity(int var0) {
    if (var0 < 0) {
           throw new OutOfMemoryError();
    } else {
          return var0 > 2147483639 ? 2147483647 : 2147483639;
    }
}
#### LinkedList
public boolean add(E var1) {
     this.linkLast(var1);
     return true;
}
void linkLast(E var1) {
     LinkedList.Node var2 = this.last;
     LinkedList.Node var3 = new LinkedList.Node(var2, var1, (LinkedList.Node)null);
     this.last = var3;
     if (var2 == null) {
         this.first = var3;
     } else {
         var2.next = var3;
     }
     ++this.size;
     ++this.modCount;
}
###增加元素到任意位置
  