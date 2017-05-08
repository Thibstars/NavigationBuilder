package be.thibaulthelsmoortel.navigationbuilder;

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
        if (!navigateSpecs.isInNewTab()) {
            String[] wname = new String[1];
            UI.getCurrent().access(() -> wname[0] = UI.getCurrent().getPage().getWindowName());
            windowName = wname[0];
        } else {
            windowName = TARGET_BLANK;
        }
        if (!navigateSpecs.isToLocation()) {
            UI.getCurrent().access(() -> UI.getCurrent().getPage().open(navigateSpecs.getUrl(), windowName, navigateSpecs.isTryAsPopup()));

        } else {
            UI.getCurrent().access(() -> UI.getCurrent().getPage().setLocation(navigateSpecs.getUrl()));
        }

        if (!navigateSpecs.getNavigationListeners().isEmpty()) {
            navigateSpecs.getNavigationListeners().forEach(l -> l.navigationPerformed(new NavigationEvent(this)));
        }
    }

    protected NavigateSpecs getNavigateSpecs() {
        return navigateSpecs;
    }
}