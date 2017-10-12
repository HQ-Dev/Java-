package coreJava.四_对象与类;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import static java.lang.System.*;

import java.text.DateFormatSymbols;

public class _4_2_3_打印日历代码 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.CHINA);
		
		// construct d as current date
		GregorianCalendar d = new GregorianCalendar();
		
		int today = d.get(Calendar.DAY_OF_MONTH);
		out.println("今天是 " + today + " 号");
		int month = d.get(Calendar.MONTH);
		out.println("现在是 " + (month + 1) + " 月");
		
		// 将变量d设置为这个月的第一天
		d.set(Calendar.DAY_OF_MONTH, 1);
		out.println("设置为本月的第一天："+d.getTime());
		
		int weekday = d.get(Calendar.DAY_OF_WEEK);
		out.println("这个月的第一天是 " + weekday);
		
		// 获取每个星期的第一天是哪一天
		int firstDayOfWeek = d.getFirstDayOfWeek();
		out.println("每个星期的第一天是： " + firstDayOfWeek + "  (1代表星期天)");
		
		out.println();
		out.println("--------------------------");
		out.println();
		
		
		// 决定日历的第一行应该缩进多少
		int indent = 0;
		while (weekday != firstDayOfWeek) {
			indent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}
		
		// 打印出星期几的名称
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		do {
			out.printf("%4s", weekdayNames[weekday]);
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
			
		} while (weekday != firstDayOfWeek);
		
		out.println();
		
		for (int i = 1; i <= indent; i++) 
			out.print("    ");
		
		d.set(Calendar.DAY_OF_MONTH, 1);
		do {
			// print day
			int day = d.get(Calendar.DAY_OF_MONTH);
			out.printf("%5d", day);
			
			// mark current day with *
			if (day == today) 
				out.print("*");
			else 
				out.print(" ");
			
			// advance d to the next day
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
			
			//Start a new line at the start of the week
			if (weekday == firstDayOfWeek)
				out.println();
		} 
		while(d.get(Calendar.MONTH) == month);
		
		// print final end of line if necessary
		if (weekday != firstDayOfWeek)
			out.println();
	}

}
