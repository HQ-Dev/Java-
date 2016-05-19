package 基础语法.数据结构;

import java.util.Vector;

public class Vector1 {

	/*
	 * Vector 响亮类实现了动态数组，也能通过索引来访问，这和 ArrayList
	 * 相似，但是两者还是有区别的：
	 * 1. Vector 是同步访问的;
	 * 2. Vector 包含了许多传统的方法，这些方法是不属于集合框架的;
	 * 3. Vector 主要用在事先不知道数组的大小，或者只是需要一个可以改变大小的数组的情况
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vector vector = new Vector(3,2);
		System.out.println("Initial size:" + vector.size());
		System.out.println("Initial capacity: "+vector.capacity());
	}

}
