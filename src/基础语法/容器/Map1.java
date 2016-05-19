package 基础语法.容器;

import java.util.HashMap;
import java.util.Map;

public class Map1 {

	/*
	 * Map: 一组成对的“键值对”对象，及其元素是成对的对象。它可以返回其所有键组成的SET和其所有值
	 * 组成的 Collection，或其键值对组成的 Set,并且可以像数组一样扩展多维Map,只要让 Map中键值对
	 * 的每个“值”是一个 Map 即可。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new HashMap<>();
		map.put("a", "a1");
		map.put("b", "b1");
		map.put("c", "c1");
		map.put("d", "d1");
		System.out.println(map);
		// 结果也是无序的
	}

}
