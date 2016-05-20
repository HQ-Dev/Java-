package 核心技术java.三_java基本程序设计结构._3_9_大数值;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 如果基本的整数和浮点数精度不能够满足需求，那么可以使用java.math包中的
 * 两个很有用的类：BigInteger和BigDecimal.这两个类可以处理包含任意长度数字序列
 * 的数值。前者是任意精度的整数计算，后者是任意精度的浮点数计算。
 * 遗憾的是，不能使用人们熟悉的算数运算符来处理大数值。而需要使用大数值类
 * 中的 add 和 multiply 方法。
 */
public class BigIntegerTest {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("How many numbers do you need to draw?");
		int k = in.nextInt();
		
		System.out.println("What is the highest number you can draw?");
		int n = in.nextInt();
		
		// 计算二项式系数 n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
		
		BigInteger lotteryOdds = BigInteger.valueOf(1);
		
		for (int i = 1; i <= k; i++) 
			lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)
					.divide(BigInteger.valueOf(i)));
		
		System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!" );
		
		in.close();
	}

}
