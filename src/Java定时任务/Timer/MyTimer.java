package Java定时任务.Timer;

import javax.swing.*;
import java.util.Timer;

/**
 * @author Archy
 **/
public class MyTimer {

    public static void main(String[] args) {
        Timer myTimer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask("定时任务1");
        // 设置定时任务： 2秒后执行，之后没2秒执行一次
        myTimer.schedule(myTimerTask, 2000l, 2000l);
    }
}
