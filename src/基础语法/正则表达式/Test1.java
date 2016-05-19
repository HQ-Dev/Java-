package 基础语法.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.omg.CORBA.NO_IMPLEMENT;

public class Test1 {

	/*
	 * 正则表达式定义了字符串的模式，
	 * 它可以用来搜索、编辑或者处理文本
	 * 
	 * java.util.regex 包主要包括以下三个类
	 * 
	 * Pattern类：
	 * Pattern对象是一个正则表达式的编译解释。Pattern类没有公共构造方法。要创建一个Pattern
	 * 对象，你必须调用其公共静态编译方法，它返回一个Pattern对象。该方法接受一个正则表达式作为她的
	 * 第一个参数。
	 * 
	 * Matcher类：
	 * Matcher对象是对输入字符串进行解释和匹配操作的引擎。与Pattern类一样，Matcher也没有公共
	 * 构造方法。你需要调用Pattern对象的matcher方法来获得一个Matcher对象。
	 * 
	 * PatternSyntaxException:
	 * PatternSyntaxException是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 捕获组
		
		// 按指定模式在字符串中查找
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(.*)(\\d+)(.*)";
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);
		// 现在创建 matcher 对象
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
			System.out.println("Found value: " + m.group(3));
		} else {
			System.out.println("NO MATCH");
		}
		
		// 上述代码表示：0下标表示整串字符串，1下标表示最后一个数字0之前的字符串，2表示最后一个数字
		// 3位表示最后一个数字之后的字符串。
	}

}
