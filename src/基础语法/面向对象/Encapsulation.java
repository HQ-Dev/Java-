package 基础语法.面向对象;

// 封装 encapsulation


/**
 * @author archy
 * 这个abcd类进行了封装，它里面的属性name,height别的类不能直接访问，只能通过提供的相关借口进行设置和提取。
 */
class abcd {
	private String name;
	private int height;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}

public class Encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
