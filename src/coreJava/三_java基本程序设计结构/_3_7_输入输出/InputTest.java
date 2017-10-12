package coreJava.三_java基本程序设计结构._3_7_输入输出;

import java.util.Scanner;
import static java.lang.System.*;

public class InputTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		out.println("What is your name?");
		String name = in.nextLine();
		
		out.println("How old are you?");
		int age = in.nextInt();
		
		out.println("Hello, " +name + ". Next year, you'll be " + (age+1));
		
		in.close();
		
	}
	
	
	// 由于 Scanner 类的输入是可见的，所以密码的输入并不适合使用此类，可以考虑使用
	// Console 类
	// 下载代码为关键部分代码，并不完整，所以运行会出现异常。
//	public static void loginIn() {
//		Console cons = System.console();
//		String username = cons.readLine("Username: ");
//		char[] passwd = cons.readPassword("Password: ");
//	}

}
