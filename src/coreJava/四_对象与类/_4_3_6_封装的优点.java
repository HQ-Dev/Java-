package coreJava.四_对象与类;

import java.util.Date;

public class _4_3_6_封装的优点 {

	public static void main(String[] args) {
		aClass newClass = new aClass();
		Date aDate = newClass.getaDate();
		aDate.setTime(200000000);
		
		// 通过方法调用后，修改clone的Date对象
		System.out.println(aDate);
		
		// 看看封装良好的aClass中的私有对象 aDate 的时间
		System.out.println(newClass.getaDate());
		
		// 通过两个打印可以看到，getaDate() 中使用 .clone()方法保证了数据的封装性
		// 你可以尝试去掉 .clone() 方法，结果就不会是你希望看到的了
	}

}

class aClass {
	private Date aDate = new Date();

	// 这个封装返回的是可变数据域的拷贝，不会破坏封装性
	public Date getaDate() {
		return (Date) aDate.clone();
	}

	public void setaDate(Date aDate) {
		this.aDate = aDate;
	}
	
	
}