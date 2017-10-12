package Java定时任务.Timer;

import java.util.TimerTask;

/**
 * @author Archy
 **/
public class MyTimerTask extends TimerTask {

    private String name;
    public MyTimerTask(String inputName) {
        name = inputName;
    }

    @Override
    public void run() {
        System.out.println("Current exec name is " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
