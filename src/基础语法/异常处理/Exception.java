package 基础语法.异常处理;

public class Exception {

	/*
	 * 在Java中你可以自定义异常，注意以下几点：
	 * 1.所有异常都必须是 Throwable 类
	 * 2.如果希望写一个检查性异常类，则需要继承 Exception
	 * 3.如果想写一个运行时异常类，那么需要继承 RuntimeException
	 */
	
}

class MyException extends Exception {
	/*
	 * 一个异常类和其它任何类一样，包含变量和方法
	 */
}
