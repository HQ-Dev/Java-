package 核心技术java.三_java基本程序设计结构;

import static java.lang.System.*;

public class String_3_6 {

	public static void main(String[] args) {
		test1();
		
		String string1 = "celebrate";
		
		// 1. char charAt(int index)
		out.println("\n"+string1.charAt(2));
		
		// 2. int codePointAt(int index) 5.0     返回某个字符的unicode代码点
		out.println(string1.codePointAt(8));
		
		// 3. int offsetByCodePoint(int startIndex, int cpCount) 5.0
		// 返回从startIndex代码点开始，位移cpCount后的代码点的索引
		out.println(string1.offsetByCodePoints(2, 3)); // 应该是5
		
		// 4. int compareTo(String other)
		out.println(string1.compareTo("celebrata"));
		// 按顺序比较单个字符，与参数比较，在之前则返回负数，相等0,后面则正数
		
		// 5. boolean endsWith(String suffix)
		out.println(string1.endsWith("rate"));  //true
		out.println(string1.endsWith("cele"));  // false
		
		// 6. boolean equals(Object other)
		out.println(string1.equals("celebrate"));
		
		// 7. boolean equalsIgnoreCase(String other) 忽视大小写的比较 cool
		out.println(string1.equalsIgnoreCase("CELEBRATE"));
		
		// 8.  int indexOf(String str)
		// 9.  int indexOf(String str, int fromIndex)
		// 10. int indexOf(int cp)
		// 11. int indexOf(int cp, int fromIndex)
		out.println(string1.indexOf(101, 2));//101代码点代表e，从2开始寻找，最近的e在index3位置
		// 同样可以寻找一段字符中某个字符串的索引位置，并且可以设定寻找的起始位置索引
		
		// 12. int lastIndexOf(String str)
		// 13. int lastIndexOf(String str, int fromIndex)
		// 14. int lastIndexOf(int cp)
		// 15. int lastIndexOf(int cp, int fromIndex)
		
		// 16. int length()
		out.println(string1.length());
		
		// 17. int codePointCount(int startIndex, int endIndex) 5.0
		out.println(string1.codePointCount(0, 4)); // 返回这个range的代码点数量（当然每个代码点的表示是不同的）

		// 18. String replace(CharSequence oldString, CharSequence newString)
		out.println(string1.replace("brate", "_BRATE"));
		// 指定原字符串中的一部分，第二个参数是替换后的内容。
		
		// 19. boolean startWith(String prefix)
		out.println(string1.startsWith("cel"));  // true
		out.println(string1.startsWith("brate"));  // false
		
		// 20. String subString(int beginIndex)
		out.println(string1.substring(4));
		
		// 21. String subString(int beginIndex, int endIndex)
		out.println(string1.subSequence(2, 5));
		
		// 22. String toUpperCase()
		// 23. String toLowerCase()
		out.println(string1.toUpperCase());
		out.println(string1.toLowerCase());
		
		// 24. String trim()
		String string2 = "      festival     ";
		out.println(string2.trim());  // 会删除字符串的前部和尾部的空格
		
		
		
		
		
		/*
		 *  3.6.9 构建字符串
		 *  使用StringBuilder拼接构建字符串不耗时间且相对不耗空间（单线程）
		 *  多线程：使用 StringBuffer,它和 StringBuilder的API相同
		 */
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append('a');
		stringBuilder.append(" hello world!");
		String string3 = stringBuilder.toString();
		out.println(string3);
		
		/*
		 * StringBuilder 的重要 API 介绍
		 */
		
		// 1. StringBuilder 构造一个空的字符串构造器
		// 2. int length() 返回构建器或者缓冲器中的代码单元数量
		out.println(stringBuilder.length());
		
		// 3. StringBuilder append(String str) 追加一个字符串并返回this
		
		// 4. StringBuilder append(char c) 追加一个代码单元并返回this
		
		// 5. StringBuilder appendCodePoint(int cp) 追加一个代码点，将其转换为一个或者两个代码单元并返回this
		
		// 6. void setCharAt(int i, char c)
		
		// 7. StringBuilder insert(int offset, String str)
		out.println(stringBuilder.insert(2, " good "));
		
		// 8. StringBuilder insert(int offset, Char c)
		
		// 9. StringBuilder delete(int startIndex, int endIndex)
		
		// 10. String toString()
		// 返回一个与构建器或缓冲器内容相同的字符串
		
	}
	
	// 3.6.6 代码点与代码单元
	public static void test1() {
		String greeting = "Hello";
		int n = greeting.length();  // 显示代码单元数量
		out.println("'Hello' 的代码单元数量是 " + n);
		
		// 显示代码点数量
		int cpCount = greeting.codePointCount(0, greeting.length());
		out.println("'Hello' 的代码点数量 "+ cpCount);
		
		// 想得到第 i 个代码点的语句
		int index = greeting.offsetByCodePoints(0, 3);
		// 第一个参数表示偏移量的起始位置，第二个表示偏移量
		out.print(greeting.codePointAt(index));
	}

}
