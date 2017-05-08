package be.thibaulthelsmoortel.navigationbuilder;

import com.vaadin.server.Page;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Class responsible for performing a already built navigation.
 *
 * @author Thibault Helsmoortel
 */
public class NavigateExecutor {

    private static final String TARGET_BLANK = "_blank";

    private final NavigateSpecs navigateSpecs;

    NavigateExecutor(NavigateSpecs navigateSpecs) {
        this.navigateSpecs = navigateSpecs;
    }

    /**
     * Performs the already built navigation.
     */
    public void perform() {
        String windowName;
        if (!navigateSpecs.isInNewTab()) {
            windowName = Page.getCurrent().getWindowName();
        } else {
            windowName = TARGET_BLANK;
        }
        if (!navigateSpecs.isToLocation()) {
            Page.getCurrent().open(navigateSpecs.getUrl(), windowName, navigateSpecs.isTryAsPopup());
        } else {
            Page.getCurrent().setLocation(navigateSpecs.getUrl());
        }

        if (!navigateSpecs.getNavigationListeners().isEmpty()) {
            navigateSpecs.getNavigationListeners().forEach(l -> l.navigationPerformed(new NavigationEvent(this)));
        }
    }

    /**
     * Performs the already built navigation after amount of time.
     *
     * @param time the time value
     * @param timeUnit the time unit
     */
    public void performAfter(long time, TimeUnit timeUnit) {
        NavigationTimerTask timerTask = new NavigationTimerTask(this);
        Timer timer = new Timer();
        timer.schedule(timerTask, timeUnit.convert(time, TimeUnit.MILLISECONDS));
    }

    protected NavigateSpecs getNavigateSpecs() {
        return navigateSpecs;
    }
}