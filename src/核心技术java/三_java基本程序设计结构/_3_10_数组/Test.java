package 核心技术java.三_java基本程序设计结构._3_10_数组;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class Test {

	public static void main(String[] args) {

		/*
		 * 数组拷贝
		 */
		
		// 1. 如果希望将一个数组中的值都拷贝到一个新的数组中去，可以使用Arrays类的copyOf()
		int[] aArray = {1,2,3,4,5};
		int[] bArray = Arrays.copyOf(aArray, 2*aArray.length);
		// 后面的参数通常用来设置新的数组的长度
		System.out.println(Arrays.toString(bArray));
		// 注意快捷打印数组中的内容，需要用类 Arrays 的 toString() 方法，使用对象的 toString() 方法打印的是一个地址
		
		
		/*
		 * 数组排序
		 */
		// 调用一个抽奖程序，从n个数字中抽取k个，然后排序显示
		
		//lotteryDrawing();
		
		
		/*
		 * Arrays 的一些常用API
		 */
		
		// 1. static String toString(type[] a)
		char[] charArray = {'a','v','d','w','z'};
		out.println(Arrays.toString(charArray));
		
		// 2. static type copyOf(type[] a, int length)
		// 3. static type copyOf(type[] a, int start, int end)
		
		// 4. static void sort(type[] a) 采用优化的快速排序算法对数组进行排序
		
		// 5. static int binarySearch(type[] a, type v)
		// 6. static int binarySearch(type[] a, int start, int end, type v)
		int[] intArray = {2363,4543,123,54,7,21321,645,72,231,53242,222,99,223,0};
		Arrays.sort(intArray);//使用二分查找前必须进行sort()排序
		int resultIndex = Arrays.binarySearch(intArray, 7);
		out.println(resultIndex);
		
		// 7. static void fill(type[] a, type v) 将数组的所有元素都设置为v
		Arrays.fill(intArray, 100);
		out.println(Arrays.toString(intArray));
		
		// static boolean equals(type[] a, type b)
		/* 如果两个数组大小相同，并且下标相同的元素都对应相等，返回true
		 * 参数：a,b  类型为int,long,short,char,byte,boolean,float&double
		 * 的两个数组
		 * 
		 */
	
	}

	static void lotteryDrawing() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("你可以抽取几次?");
		int k = in.nextInt();
		
		System.out.println("你最多可以从多少个数字中进行抽取?");
		int n = in.nextInt();
		
		// fill an array with numbers 1 2 3 ... n
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = i+1;
		}
		
		// 抽取k次，并且把抽到的数字放到新的数组中
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			// 随机抽取到的数字下标
			int a = (int) (Math.random() * n);
			
			// 将抽取到的数字放到 result 数组中
			result[i] = numbers[a];
			
			// 抽到的那个数字用number数组中的最后一个数字替换，防止抽到重复的数字
			numbers[a] = numbers[n-1];
			
			// 下一次循环前减少可抽取数字的数量
			n--;
		}
		
		// 打印抽到的数字
		Arrays.sort(result);
		System.out.println("中奖的是下列数字！");
		System.out.println(Arrays.toString(result));
	}
	
	
}
