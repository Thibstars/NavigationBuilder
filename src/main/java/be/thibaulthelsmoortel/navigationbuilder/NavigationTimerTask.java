package be.thibaulthelsmoortel.navigationbuilder;

import java.util.TimerTask;

/**
 * Created by thibault.helsmoortel on 08-May-17.
 */
public class NavigationTimerTask extends TimerTask {

    private final NavigateExecutor navigateExecutor;

    public NavigationTimerTask(NavigateExecutor navigateExecutor) {
        this.navigateExecutor = navigateExecutor;
    }

    @Override
    public void run() {
        navigateExecutor.perform();
    }
}
