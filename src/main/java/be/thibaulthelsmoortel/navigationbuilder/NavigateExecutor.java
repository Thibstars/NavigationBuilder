package be.thibaulthelsmoortel.navigationbuilder;

import com.vaadin.server.Page;

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

    protected NavigateSpecs getNavigateSpecs() {
        return navigateSpecs;
    }
}