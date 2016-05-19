package 基础语法;

public class Range {
	
	public static void main(String[] args) {
		// byte short int long 的范围
		System.out.printf("%d ~ %d%n", Byte.MIN_VALUE, Byte.MAX_VALUE);
		System.out.printf("%d ~ %d%n", Short.MIN_VALUE, Short.MAX_VALUE);;
		System.out.printf("%d ~ %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.printf("%d ~ %d%n", Long.MIN_VALUE, Long.MAX_VALUE);
		
		// float double精度范围
		System.out.printf("%d ~ %d%n", Float.MIN_EXPONENT, Float.MAX_EXPONENT);
		System.out.printf("%d ~ %d%n", Double.MIN_EXPONENT, Double.MAX_EXPONENT);
		
		// char 可表示的unicode范围
		System.out.printf("%h ~ %h%n", Character.MIN_VALUE, Character.MAX_VALUE);
		
		// boolean的两个值
		System.out.printf("%b ~ %b%n", Boolean.TRUE, Boolean.FALSE);
		
		// 可以确定输出值的精度
		System.out.printf("%.4f%n", 3.1415926);
		
		
		// 求阿姆斯特朗数
		int a =1;
		int b = 0;
		int c = 0;
		for (a=1;a<10;a++) 
			for (b=0;b<10;b++)
				for(c=0;c<10;c++)
					if (Math.pow(a,3)+Math.pow(b, 3)+Math.pow(c, 3) ==
							a*100+b*10+c){
						System.out.println(a*100+b*10+c);
					}
			
	
		String string1 = "Hello";
		System.out.println(string1.substring(0, 3));
	}

}
