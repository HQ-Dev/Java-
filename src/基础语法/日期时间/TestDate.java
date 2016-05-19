package 基础语法.日期时间;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {

	    Date date1 = new Date();
		System.out.println(date1);
		
		/*
		 * 第二个构造函数接收一个参数，该参数从1970年1月1日的微秒数
		 */
		long date2 = new Date().getTime();
		Date date3 = new Date(date2);
		System.out.println(date3);
		
		Date date4 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(date4));
	}

}
