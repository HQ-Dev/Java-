package 基础语法.接口;


// 接口的方法都是隐含 abstract 的
interface interface1 {
	final String name = "22";
	int height = 144;
	void dosomething();
}

interface interface2 {
	
}

// 一个接口可以继承另一个接口
// 接口可以多重继承多个接口
interface interface3 extends interface1, interface2 {
	void dosth2();
}


public class Interface {

}
