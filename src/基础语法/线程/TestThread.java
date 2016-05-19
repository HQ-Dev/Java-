package 基础语法.线程;

public class TestThread {

	public static void main(String[] args) {
		Runner1 runner1 = new Runner1();
		Thread thread1 = new Thread(runner1);
		
		thread1.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("main thread = " + i);
		}
	}

}

class Runner1 implements Runnable {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Runner1 : " + i);
		}
	}
}