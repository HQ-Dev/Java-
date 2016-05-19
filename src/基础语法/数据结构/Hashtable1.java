package 基础语法.数据结构;

import java.util.Enumeration;
import java.util.Hashtable;

public class Hashtable1 {

	/*
	 * Hashtable 是原始的java.util的一部分，是一个Dictionary具体的实现。它和 HashMap 类很相似，
	 * 但它时候i支持同步的。
	 */
	public static void main(String[] args) {

		Hashtable balance = new Hashtable();
		Enumeration names;
		String string;
		balance.put("Zara", new Double(3213.23));
		balance.put("Mahs", new Double(2321.32));
		names = balance.keys();
		while(names.hasMoreElements()) {
			string = (String) names.nextElement();
			System.out.println(string + ":"+balance.get(string));
		}
	}

}
