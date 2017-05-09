package be.thibaulthelsmoortel.navigationbuilder;

import com.vaadin.server.Page;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.UI;

import java.util.HashSet;
import java.util.Set;

/**
 * Class responsible for performing a already built navigation.
 *
 * @author Thibault Helsmoortel
 */
public class NavigationExecutor {

    private static final String TARGET_BLANK = "_blank";
    private final Set<NavigationListener> navigationListeners;
    private NavigationSpecs navigationSpecs;

    NavigationExecutor() {
        this.navigationListeners = new HashSet<>();
    }

    /**
     * Performs the already built navigation.
     */
    public void perform() {
        String windowName;
        UI ui = UI.getCurrent();
        Page page = ui.getPage();
        JavaScript js = JavaScript.getCurrent();
        if (navigationSpecs.isReload()) {
            ui.access(page::reload);
        } else if (navigationSpecs.isToPrevious()) {
            js.execute("window.history.back();");
        } else if (navigationSpecs.isToNext()) {
            js.execute("window.history.forward();");
        } else {
            if (!navigationSpecs.isInNewTab()) {
                String[] wName = new String[1];
                ui.access(() -> wName[0] = ui.getPage().getWindowName());
                windowName = wName[0];
            } else {
                windowName = TARGET_BLANK;
            }
            if (!navigationSpecs.isToLocation()) {
                ui.access(() -> page.open(navigationSpecs.getUrl(), windowName, navigationSpecs.isTryAsPopup()));
            } else {
                ui.access(() -> page.setLocation(navigationSpecs.getUrl()));
            }
        }

        notifyListenersOnNavigationPerformed();
    }

    /**
     * Notifies added listeners of an executed navigation.
     */
    private void notifyListenersOnNavigationPerformed() {
        if (!navigationListeners.isEmpty()) {
            navigationListeners.forEach(l -> l.navigationPerformed(new NavigationEvent(this)));
        }
    }

    /**
     * Adds a listener to the list.
     *
     * @param listener the listener to add
     */
    void addListener(NavigationListener listener) {
        navigationListeners.add(listener);
    }

    /**
     * Removes a listener from the list.
     *
     * @param listener the listener to remove
     */
    void removeListener(NavigationListener listener) {
        navigationListeners.remove(listener);
    }

    protected NavigationSpecs getNavigationSpecs() {
        return navigationSpecs;
    }

    void setNavigationSpecs(NavigationSpecs navigationSpecs) {
        this.navigationSpecs = navigationSpecs;
    }
}