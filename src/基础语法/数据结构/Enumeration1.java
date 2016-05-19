package 基础语法.数据结构;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class Enumeration1 {

	/*
	 * Enumeration 接口定义了一些方法，通过这些方法可以枚举（一次获得一个）对象
	 * 集合中的ansu。这种传统接口已经被迭代器取代，但它还未被遗弃。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 例子
		Enumeration<String[]> days;
		Vector dayNames = new Vector();
		dayNames.add("Sunday");
		dayNames.add("Monday");
		days = dayNames.elements();
		while (days.hasMoreElements()) {
			System.out.println(days.nextElement());
		}
	}

}
