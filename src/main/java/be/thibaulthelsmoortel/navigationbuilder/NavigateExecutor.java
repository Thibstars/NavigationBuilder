package be.thibaulthelsmoortel.navigationbuilder;

import com.vaadin.server.Page;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.UI;

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
        UI ui = UI.getCurrent();
        Page page = ui.getPage();
        JavaScript js = JavaScript.getCurrent();
        if (navigateSpecs.isReload()) {
            ui.access(page::reload);
        } else if (navigateSpecs.isToPrevious()) {
            js.execute("window.history.back();");
        } else if (navigateSpecs.isToNext()) {
            js.execute("window.history.forward();");
        } else {
            if (!navigateSpecs.isInNewTab()) {
                String[] wname = new String[1];
                ui.access(() -> wname[0] = ui.getPage().getWindowName());
                windowName = wname[0];
            } else {
                windowName = TARGET_BLANK;
            }
            if (!navigateSpecs.isToLocation()) {
                ui.access(() -> page.open(navigateSpecs.getUrl(), windowName, navigateSpecs.isTryAsPopup()));

            } else {
                ui.access(() -> page.setLocation(navigateSpecs.getUrl()));
            }
        }

        if (!navigateSpecs.getNavigationListeners().isEmpty()) {
            navigateSpecs.getNavigationListeners().forEach(l -> l.navigationPerformed(new NavigationEvent(this)));
        }
    }

    protected NavigateSpecs getNavigateSpecs() {
        return navigateSpecs;
    }
}