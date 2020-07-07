# leetcode
***``my leetcode practice``***
## ``问题汇总(基础类)``

1. 包装类存在的意义是什么? int 和 integer的区别

2. 短路运算符 && 、|| 和逻辑运算符 & 、| 的区别 

3. 位运算 & | ^ ~  >> <<  >>>  <<< 的含义

4. == 和 equals。( == 数值相同也相同)

5. 运算符优先级

6. for循环执行顺序

7. label + break/continue 的使用

8. 二维数组的初始化

9. String 相关(不可变、安全、常量池...)

10. StringBuilder/StringBuffer

11. 正则表达式

12. ArrayList 和 LinkedList <br/>
对比：数组实现，按下标查找效率高，删除添加效率低；
     链表实现，查找效率低，删除添加效率高（重新设置链表头尾）
     
13 .HashMap结构和原理<br/>
 结构：主干为数组，相同hash值碰撞为链表，链表长度超过8转为红黑树(1.8新增，查找效率更高)
 
 
 14 . HashMap 的resize 和 负载因子<br/>
 负载因子大  时间开销大 空间开销小   负载因子小 时间开销小 空间开销大 <br/>
 如果负载因子过大，会造成碰撞几率变高，底层红黑树链表的查询会复杂；反之，底层数组内存大了，但碰撞降低。
 负载因子是resize的阈值，如果大于了 cap*loadfactor 则会执行resize<br/>
  先说结论：初始值设定大小为 cap =  ( 需要存储的大小 / 负载因子 ) + 1<br/>
 threshold ：HashMap内部变量，若 元素数量 > threshold,则执行 resize
 threshold 及 HashMap内部的变化步骤：
 1. 执行 new HashMap(cap) 的构造器时，会执行 threshold  = tableSizeFor（cap） 方法， threshold 会赋值为 cap 向上最近的 2的 n次方 
 2. 第一次put 元素的时候，会执行resize方法（实际没有rehash），仅执行  threshold   =  threshold  * 负载因子（默认）<br/>
 3. 等到put元素的size大于 threshold   时， 会执行resize方法(这时方法内部执行了 rehash，性能损耗很大)。
 
 15 . HashMap 的 tableSizeFor方法解析(1.8后优化) <br/>
 
      /**
       * Returns a power of two size for the given target capacity.
       */
     static final int tableSizeFor(int cap) {
         int n = cap - 1;
         n |= n >>> 1;
         n |= n >>> 2;
         n |= n >>> 4;
         n |= n >>> 8;
         n |= n >>> 16;
         return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
     }
当初始化HashMap时，如果指定了初始容量，由于哈希桶的数目必须是2的n次幂，因此要把initialCapacity向上转成最近的2的n次幂数，例如cap = 10 ，那就返回16<br/>
做法是将cap减1，然后右移和或操作执行5次。目的是让初始最高位1的低位0都转为1（最多32位int），最后再加1，变为2的n次幂。 
cap减1 是为了防止一开始 cap就是2的n次幂，导致会增加到2的n+1次幂。  

16 HashMap 的计算hash方法<br/>
        
        //无符号右移16位然后异或，即高低位异或(本身32位)。整合高位和低位的数据，加大低位的随机性，
        //低位保留高位的部分特征。使更均匀，hash碰撞更少发生
        计算hash: hash() : (h = key.hashCode()) ^ (h >>> 16);
        计算hash索引：putval方法时: hash() & n-1 
        

17.红黑树、AVL。<br/>
共同点：都是二叉查找树(左< 中 <右)，都有平衡性。都能通过左旋、右旋改变结构，保持平衡。 查找删除插入都是 O(logn)<br/>
不同点：AVL平衡性更好，每个节点左右子树高度差最多为1；查找效率AVL > 红黑树，插入删除效率 红黑树> AVL（旋转效率 红黑树>AVL）。红黑树高度最多为 2log(n+1)；<br>

红黑树特性：1.根节点黑色 2.叶节点黑色且为null 3.节点非红即黑 4.红节点的子节点都为黑 5.从任意节点到每个叶子的路径黑色节点数相同 6.最长路径不会大于最小路径2倍

AVL: 高度平衡二叉树，每个节点左右子树高度差最多为1。

2棵树插入和删除 需要：<br/> 1》旋转操作 LL->右旋  RR->左旋  双向旋转(先左后右，先右后左) <br/>2》变色(仅红黑树)