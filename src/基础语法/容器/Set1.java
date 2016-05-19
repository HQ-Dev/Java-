package 基础语法.容器;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set1 {

	/*
	 * Set(集)：集合中的对象不按特定方式排列，并且没有重复对象，它的有些实现类对
	 * 集合中的对象按特定方式排列;
	 * Set 接口的主要有两个实现类 HashSet TreeSet,前者按照哈希算法来存取集合中的对象，存取
	 * 速度比较快，它还有一个 LinkedHashSet 类，不仅实现了哈希算法，而且实现了
	 * 链表数据结构，TreeSet实现了 SortedSet 接口，具有排序功能。
	 */
	public static void main(String[] args) {

		Set set = new HashSet();
		set.add("a");
		set.add("b");
		set.add("c");
		Iterator it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		// 结果是无序的
	}

}
